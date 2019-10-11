package test.keycloak.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.keycloak.KeycloakSecurityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import test.keycloak.repository.BookRepository;

@Controller
public class ApplicationController {
	   
	@Autowired
	private BookRepository repo;
	
	@GetMapping("/")
	public String getHome() {
		return "index";
	}
	
	@GetMapping("/books")
	public String getBooks(Model model, HttpServletRequest req) {
		model.addAttribute("name", retrieveCurrentUsername(req));
		model.addAttribute("books", repo.findAll());
		return "books";
	}
	
	@GetMapping("/manager")
	public String getManager(Model model, HttpServletRequest req) {
		model.addAttribute("name", retrieveCurrentUsername(req));
		model.addAttribute("infos", getKeycloakContext(req).getIdToken().getEmail());
		return "manager";
	}
	
	@GetMapping(value = "/logout")
	public String logout(HttpServletRequest request) throws ServletException{
		request.logout();
		return "redirect:/";
	}
	 
	private KeycloakSecurityContext getKeycloakContext(HttpServletRequest request) {
		KeycloakSecurityContext keycloakSecContext = (KeycloakSecurityContext) request.getAttribute(KeycloakSecurityContext.class.getName());
		return keycloakSecContext;
	}
	
	private String retrieveCurrentUsername(HttpServletRequest request) {
		return getKeycloakContext(request).getIdToken().getGivenName();
	}
}
