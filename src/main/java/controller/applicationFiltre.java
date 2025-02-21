package controller;

import java.io.IOException;
import java.sql.SQLException;

import bll.UtilisateurBLL;
import bo.Utilisateur;
import jakarta.servlet.DispatcherType;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebFilter(
	    dispatcherTypes = { DispatcherType.REQUEST },
	    urlPatterns = { "/*" }
	)
	public class applicationFiltre extends HttpFilter implements Filter {
	    private static final long serialVersionUID = 1L;

	    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	            throws IOException, ServletException {
	        HttpServletResponse httpResponse = (HttpServletResponse) response;
	        HttpServletRequest httpRequest = (HttpServletRequest) request;

	        String url = httpRequest.getServletPath();

	        // Check if user is already in session
	        Utilisateur utilisateur = (Utilisateur) httpRequest.getSession().getAttribute("utilisateur");
	        if (utilisateur != null) {
	            chain.doFilter(httpRequest, httpResponse);
	            return;
	        }
	        
	        // Try to authenticate using cookies
	        String login = null;
	        String password = null;
	        
	        Cookie[] cookies = httpRequest.getCookies();
	        if (cookies != null) {
	            for (Cookie current : cookies) {
	                if ("login".equals(current.getName())) {
	                    login = current.getValue();
	                    System.out.println(login);
	                }
	                if ("password".equals(current.getName())) {
	                    password = current.getValue();
	                    System.out.println(password);
	                }
	            }
	            
	            if (login != null && password != null) {
	                utilisateur = new Utilisateur();
	                UtilisateurBLL bll = new UtilisateurBLL();
	                try {
						if (bll.selectByLoginPassword(login, password) != null) {
							utilisateur = bll.selectByLoginPassword(login, password);
							System.out.println(utilisateur.getId());
						    httpRequest.getSession().setAttribute("utilisateur", utilisateur);
						    chain.doFilter(httpRequest, httpResponse);
						    return;
						}
					} catch (IOException e) {
						e.printStackTrace();
					} catch (ServletException e) {
						e.printStackTrace();
					}
	            }
	        }
	        
	        
	     // Public pages that don't need authentication
	        if (url.equals("/connexion") 
	        		|| url.equals("/accueil") 
	                || url.startsWith("/css/") 
	                || url.startsWith("/images/")
	                || url.startsWith("/inscription")
	                || url.startsWith("/js/") 
	                || url.equals("/listeRestaurants")
	                || url.equals("/restaurant")
	                || url.equals("/carte")
	                ) {
	            chain.doFilter(httpRequest, httpResponse);
	            return;
	        }
	        
	        
	        // If all authentication methods fail, redirect to login page
	        httpResponse.sendRedirect("connexion");
	    }
	}