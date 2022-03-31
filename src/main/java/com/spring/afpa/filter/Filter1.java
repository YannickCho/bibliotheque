package com.spring.afpa.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.afpa.dao.UtilisateurRepository;
import com.spring.afpa.model.Bibliothecaire;
import com.spring.afpa.model.Emprunteur;
import com.spring.afpa.model.Utilisateur;



/**
 * Servlet Filter implementation class Filter1
 */
@Component
public class Filter1 extends HttpFilter implements Filter {

	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	/**
	 * @see HttpFilter#HttpFilter()
	 */
	public Filter1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession httpSession = req.getSession();
		String methode = req.getMethod();
		String chemin = req.getServletPath();
		
		Cookie[] cookies = req.getCookies();
		Bibliothecaire bibliothecaire = null;
		Emprunteur emprunteur = null;

		Utilisateur utilisateur = (Utilisateur)httpSession.getAttribute("utilisateur");

		if (utilisateur == null && cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("loginBibliotheque")) {
					String login = cookies[i].getValue();
					
					List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
					for(Utilisateur user : utilisateurs) {
						if (user.getLogin().equals(login)) {
							utilisateur = user;
							break;
						}
					}
					httpSession.setAttribute("utilisateur", utilisateur);
					break;
				}
			}
		}
		
		if (utilisateur != null || chemin.equals("/bibliotheque/") || chemin.equals("/bibliotheque/index")  
				|| chemin.equals("/bibliotheque/connexion") && methode.equals("POST")) {
			chain.doFilter(request, response);
			
		}
		else
			res.sendRedirect(req.getContextPath());
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
