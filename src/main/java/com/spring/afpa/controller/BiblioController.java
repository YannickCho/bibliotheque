package com.spring.afpa.controller;

import java.text.Normalizer;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.valves.rewrite.InternalRewriteMap.UpperCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.afpa.dao.BibliothecaireRepository;
import com.spring.afpa.dao.EmpruntRepository;
import com.spring.afpa.dao.EmprunteurRepository;
import com.spring.afpa.dao.JournalRepository;
import com.spring.afpa.dao.LivreRepository;
import com.spring.afpa.dao.MagazineRepository;
import com.spring.afpa.dao.PublicationRepository;
import com.spring.afpa.dao.ReservationRepository;
import com.spring.afpa.dao.UtilisateurRepository;
import com.spring.afpa.model.Bibliothecaire;
import com.spring.afpa.model.Emprunt;
import com.spring.afpa.model.Emprunteur;
import com.spring.afpa.model.Journal;
import com.spring.afpa.model.Livre;
import com.spring.afpa.model.Magazine;
import com.spring.afpa.model.Publication;
import com.spring.afpa.model.Reservation;
import com.spring.afpa.model.Utilisateur;




@Controller
public class BiblioController {
	@Autowired
	private UtilisateurRepository utilisateurRepository;

	@Autowired
	private BibliothecaireRepository bibliothecaireRepository;

	@Autowired
	private EmprunteurRepository emprunteurRepository;

	@Autowired
	private EmpruntRepository empruntRepository;

	@Autowired
	private PublicationRepository publicationRepository;

	@Autowired
	private LivreRepository livreRepository;

	@Autowired
	private MagazineRepository magazineRepository;

	@Autowired
	private JournalRepository journalRepository;

	@Autowired
	private ReservationRepository reservationRepository;

	@GetMapping(value = {"/bibliotheque/index", "/bibliotheque"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	
	@PostMapping(value = "/bibliotheque/connexion")
	public ModelAndView connexion(@RequestParam(value = "login") String login, @RequestParam(value = "pwd") String pwd, HttpSession httpSession, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		ArrayList<Utilisateur> utilisateurs = (ArrayList<Utilisateur>)utilisateurRepository.findAll();
		boolean trouve = false;
		String erreur = "", path = "index";
		for (Utilisateur utilisateur : utilisateurs) {
			if (utilisateur.getLogin().equals(login)) {
				if(utilisateur.getPassword().equals(pwd)) {
					trouve = true;
					Cookie cookie = new Cookie("loginBibliotheque", login);
					cookie.setMaxAge(60*60*24);
					response.addCookie(cookie);
					httpSession.setAttribute("utilisateur", utilisateur);
					if (utilisateur instanceof Bibliothecaire)
						path = "bibliothecaire";
					else 
						path = "emprunteur";
				}
				else
					erreur = "Mauvais mot de passe";
				break;
			}
		}
		if(!trouve && erreur.equals("")) {
			erreur = "Ce login n'existe pas";
		}		
		mv.setViewName(path);
		mv.addObject("erreur", erreur);
		return mv;
	}
	
	@GetMapping(value = "/bibliotheque/bibliothecaire")
	public String retourAccueilBiblio() {
		return "bibliothecaire";
	}
	
	@GetMapping(value = "/bibliotheque/emprunteur")
	public String retourAccueilEmpr() {
		return "emprunteur";
	}
	
	@GetMapping(value = "/bibliotheque/deconnect")
	public ModelAndView deconnexion(HttpSession httpSession, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		httpSession.invalidate();
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("loginBibliotheque")) {
				cookies[i].setMaxAge(0);
				response.addCookie(cookies[i]);
				break;
			}
		}
		return mv;
	}
	
	@GetMapping(value = "/bibliotheque/gestionUtilisateur")
	public String gestionUtilisateur() {
		return "gestionUtilisateur";		
	}
	
	@GetMapping(value = "/bibliotheque/gestionPublication")
	public String gestionPublication() {
		return "gestionPublication";		
	}
	
	@GetMapping(value = "/bibliotheque/ajoutUtilisateur")
	public String ajoutUtilisateur() {
		return "ajoutUtilisateur";		
	}
	
	@PostMapping(value = "/bibliotheque/ajoutUtilisateur")
	public String ajoutUtilisateur(@RequestParam(value = "nom") String nom, @RequestParam(value = "prenom") String prenom, 
	@RequestParam(value = "mail") String mail, @RequestParam(value = "login") String login, @RequestParam(value = "pwd") String pwd, 
	@RequestParam(value = "type", required = false) String type) {
		Utilisateur u;
		if (type != null)
			u = new Bibliothecaire(nom, prenom, login, pwd, mail);
		else
			u = new Emprunteur(nom, prenom, login, pwd, mail);
		
		utilisateurRepository.save(u);
		return "gestionUtilisateur";
	}
	
	
		
	@GetMapping(value = "/bibliotheque/listeUtilisateur")
	public ModelAndView listeUtilisateur() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("listeUtilisateur");
		ArrayList<Utilisateur> utilisateurs = (ArrayList<Utilisateur>)utilisateurRepository.findAll();
		mv.addObject("utilisateurs", utilisateurs);
		return mv;
	}
	
	@GetMapping(value = "/bibliotheque/majUtilisateur")
	public ModelAndView majUtilisateur(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView();
		Utilisateur u = utilisateurRepository.getById(id);
		mv.addObject("u", u);
		mv.setViewName("majUtilisateur");
		return mv;
	}
	
	@PostMapping(value = "/bibliotheque/majUtilisateur")
	public ModelAndView majUtilisateur(@RequestParam(value = "nom") String nom, @RequestParam(value = "prenom") String prenom, 
			@RequestParam("id") int id, @RequestParam(value = "mail") String mail, @RequestParam(value = "pwd") String pwd) {
		ModelAndView mv = new ModelAndView();
		Utilisateur utilisateur = utilisateurRepository.getById(id);
		utilisateur.setNom(nom);
		utilisateur.setPrenom(prenom);
		utilisateur.setPassword(pwd);
		utilisateur.setMail(mail);
		utilisateurRepository.save(utilisateur);
		ArrayList<Utilisateur> utilisateurs = (ArrayList<Utilisateur>)utilisateurRepository.findAll();
		mv.addObject("utilisateurs", utilisateurs);
		mv.setViewName("listeUtilisateur");
		return mv;
	}
	
	@GetMapping(value = "/bibliotheque/suppUtilisateur")
	public ModelAndView suppUtilisateur(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView();
		Utilisateur utilisateur = utilisateurRepository.getById(id);
		utilisateurRepository.delete(utilisateur);
		ArrayList<Utilisateur> utilisateurs = (ArrayList<Utilisateur>)utilisateurRepository.findAll();
		mv.addObject("utilisateurs", utilisateurs);
		mv.setViewName("listeUtilisateur");
		return mv;
	}
	
	@GetMapping(value = "/bibliotheque/ajoutPublication")
	public String ajoutPublication() {
		return "ajoutPublication";		
	}
	
	@PostMapping(value = "/bibliotheque/ajoutPublication")
	public ModelAndView ajoutPublication(@RequestParam("titre") String titre, @RequestParam("nbPages") int nbPages, 
			@RequestParam("type") String type, @RequestParam("quantite") int quantite) {
		ModelAndView mv = new ModelAndView();
		Publication publication = null;
		System.out.println(titre);
		
		switch (type) {
		case "livre":
			publication = new Livre(titre, nbPages, quantite);
			break;
		case "magazine":
			publication = new Magazine(titre, nbPages, quantite);
			break;
		case "journal":
			publication = new Journal(titre, nbPages, quantite);
			break;
		}
		
		publicationRepository.save(publication);
		mv.addObject("publication", publication);
		mv.addObject("type", type);
		mv.setViewName("ajoutPublication2");
		return mv;
	}
	
	@PostMapping(value = "/bibliotheque/ajoutPublication2")
	public String ajoutPublication2(@RequestParam("id") int id, @RequestParam(value = "auteur", required = false) String auteur, 
			@RequestParam("annee") int annee, @RequestParam(value = "mois", required = false) String mois, 
			@RequestParam(value = "jour", required = false) String jour) {
		Publication publication = publicationRepository.getById(id);
		String type = publicationRepository.findType(id);
		System.out.println(type);
		publication.setAnneePublication(annee);
		if (type.equals("LIVRE"))
			publication.setAuteur(auteur);
		if (type.equals("MAGAZINE") || type.equals("JOURNAL")) {
			int moisPubli = Integer.parseInt(mois);
			publication.setMoisPublication(moisPubli);
		}
		if (type.equals("JOURNAL")) {
			int jourPubli = Integer.parseInt(jour);
			publication.setJourPublication(jourPubli);
		}
		publicationRepository.save(publication);
		return "gestionPublication";
	}
	
	@GetMapping(value = "/bibliotheque/listePublication")
	public ModelAndView listePublication() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("listePublication");
		ArrayList<Publication> publications = (ArrayList<Publication>)publicationRepository.findAll();
		mv.addObject("publications", publications);
		return mv;
	}
	
	@GetMapping(value = "/bibliotheque/majPublication")
	public ModelAndView majPublication(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView();
		Publication publication = publicationRepository.getById(id);
		mv.addObject("publication", publication);
		mv.setViewName("majPublication");
		return mv;
	}
	
	@PostMapping(value = "/bibliotheque/majPublication")
	public ModelAndView majPublication(@RequestParam("titre") String titre, @RequestParam(value = "auteur", required = false) String auteur, 
			@RequestParam("id") int id, @RequestParam("quantite") int quantite, @RequestParam("datePubli") String date) {
		ModelAndView mv = new ModelAndView();
		
		Publication publication = publicationRepository.getById(id);
		publication.setTitre(titre);
		if (!auteur.equals(""))
			publication.setAuteur(auteur);
		
		publication.setQuantite(quantite);
		publicationRepository.save(publication);
		ArrayList<Publication> publications = (ArrayList<Publication>)publicationRepository.findAll();
		mv.addObject("publications", publications);
		mv.setViewName("listePublication");
		return mv;
	}
	
	@GetMapping(value = "/bibliotheque/suppPublication")
	public ModelAndView suppPublication(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView();
		Publication publication = publicationRepository.getById(id);
		publicationRepository.delete(publication);
		mv.setViewName("listePublication");
		ArrayList<Publication> publications = (ArrayList<Publication>)publicationRepository.findAll();
		mv.addObject("publications", publications);
		return mv;
	}
	
	@GetMapping(value = "/bibliotheque/gestionEmprunt")
	public String gestionEmprunt() {
		return "gestionEmprunt";
	}
	
	@GetMapping(value = "/bibliotheque/ajoutEmprunt")
	public ModelAndView ajoutEmprunt() {
		ModelAndView mv = new ModelAndView();
		ArrayList<Publication> publications = (ArrayList<Publication>)publicationRepository.findAll();
		mv.addObject("publications", publications);
		ArrayList<Emprunteur> emprunteurs = (ArrayList<Emprunteur>)emprunteurRepository.findAll();
		mv.addObject("emprunteurs", emprunteurs);
		mv.setViewName("ajoutEmprunt");
		return mv;
	}
	
	@PostMapping(value = "/bibliotheque/ajoutEmprunt")
	public String ajoutEmprunt(@RequestParam("idEmprunteur") int idEmprunteur, @RequestParam("idPublication") int idPublication) {
		Emprunteur emprunteur = emprunteurRepository.getById(idEmprunteur);
		Publication publication = publicationRepository.getById(idPublication);
		publication.destocker();
		Emprunt emprunt = new Emprunt(LocalDate.now(), emprunteur, publication);
		empruntRepository.save(emprunt);
		
		return "gestionEmprunt";
	}
	
	@GetMapping(value = "/bibliotheque/retour")
	public ModelAndView retour() {
		ModelAndView mv = new ModelAndView();
		ArrayList<Emprunt> emprunts = (ArrayList<Emprunt>)empruntRepository.findAll();
		mv.addObject("emprunts", emprunts);
		
		mv.setViewName("retour");
		return mv;
	}
	
	@PostMapping(value = "/bibliotheque/retour")
	public ModelAndView retour(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView();
		
		Emprunt emprunt = empruntRepository.getById(id);
		System.out.println(emprunt.getDateFin());
		emprunt.setDateFin(LocalDate.now());
		emprunt.getPublication().retour();
		empruntRepository.save(emprunt);
		ArrayList<Emprunt> emprunts = (ArrayList<Emprunt>)empruntRepository.findAll();
		mv.addObject("emprunts", emprunts);
		
		mv.setViewName("retour");
		return mv;
	}
	
	@GetMapping(value = "/bibliotheque/recherchePublication")
	public ModelAndView recherchePublication() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("recherchePublication");
		ArrayList<Publication> publications = (ArrayList<Publication>)publicationRepository.findAll();
		mv.addObject("publications", publications);
		return mv;
	}
	
	@PostMapping(value = "/bibliotheque/recherchePublication")
	public ModelAndView recherchePublication(@RequestParam("type") String type, @RequestParam(value = "titre", required=false) String titre, 
			@RequestParam(value = "auteur", required=false) String auteur) {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("recherchePublication");
		ArrayList<Publication> publications = (ArrayList<Publication>)publicationRepository.findAll();
		if (type != "")
			publications.retainAll(publicationRepository.findByType(type));
		if (titre != "") 
			publications.retainAll(publicationRepository.findLikeTitre(titre));
		if (auteur != "") 
			publications.retainAll(publicationRepository.findLikeAuteur(auteur));
		
		mv.addObject("publications", publications);
		return mv;
	}
	
	@GetMapping(value = "bibliotheque/reservation")
	public ModelAndView reservation(@RequestParam("id") int id, HttpSession httpSession) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("recherchePublication");
		Publication publication = publicationRepository.getById(id);
		Emprunteur emprunteur = (Emprunteur)httpSession.getAttribute("utilisateur");
		Reservation reservation = new Reservation(emprunteur, publication);
		reservationRepository.save(reservation);
		ArrayList<Publication> publications = (ArrayList<Publication>)publicationRepository.findAll();
		mv.addObject("publications", publications);
		return mv;
	}
}
