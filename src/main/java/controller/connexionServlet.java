package controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import bll.UtilisateurBLL;
import bo.Utilisateur;

/**
 * Servlet implementation class ConnexionServlet
 */
@WebServlet("/connexion")
public class connexionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String rememberMe = request.getParameter("remember-me");
        
        if (login != null && !login.isBlank() && password != null && !password.isBlank()) {
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setLogin(login);
            utilisateur.setPassword(password);
            
            UtilisateurBLL bll = new UtilisateurBLL();
            
    		HttpSession session = request.getSession(false);
            
            try {
				utilisateur = bll.connecterUtilisateur(login, password);
				if (utilisateur == null) {
                    request.setAttribute("message", "Identifiant ou mot de passe incorrect.");
                    request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp").forward(request, response);
                    return;
                }
				
				session.setAttribute("utilisateur", utilisateur);
				
			} catch (NamingException e) {
				e.printStackTrace();
				request.setAttribute("message", "Une erreur est survenue. Veuillez réessayer.");
                request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp").forward(request, response);
			}
   
            // Set user in session
            request.getSession().setAttribute("utilisateur", utilisateur);
            
            // Create cookies if "remember-me" is checked
            if (rememberMe != null && rememberMe.equals("on")) {
                Cookie cookieUsername = new Cookie("login", utilisateur.getLogin());
                cookieUsername.setMaxAge(604800); // 7 days in seconds
                //cookieUsername.setPath("/");
                response.addCookie(cookieUsername);
                
                Cookie cookiePassword = new Cookie("password", utilisateur.getPassword());
                cookiePassword.setMaxAge(604800); // 7 days in seconds
                //cookiePassword.setPath("/");
                response.addCookie(cookiePassword);
            }
            
            response.sendRedirect("accueil");
            return;
        }
    
        
        
        // If authentication fails
        request.setAttribute("error", "Invalid login credentials");
        request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp").forward(request, response);
    }
}