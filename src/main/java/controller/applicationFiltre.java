package controller;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import bo.Utilisateur;


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
	        
	        //Tout ce qui se trouve après .css sera à enlever quand l'application fonctionnera correctement !!
	        if (url.equals("/connexion") 
	        		|| url.equals("/accueil") 
	        		|| url.startsWith("/css/") 
	        		|| url.startsWith("/images/") 
	        		|| url.startsWith("/js/") 
	        		|| url.equals("/listeRestaurants")) {
	            chain.doFilter(httpRequest, httpResponse);
	            return;
	        }

	        Utilisateur utilisateur = (Utilisateur) httpRequest.getSession().getAttribute("utilisateur");
	        if (utilisateur != null) {
	            chain.doFilter(httpRequest, httpResponse);
	            return;
	        }

	        httpResponse.sendRedirect(httpRequest.getContextPath() + "/connexion");
	    }
	}
