package es.ariel.app.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller

public class LoginController {
	
	@GetMapping("/login")
	public String login(@RequestParam(value = "error", required =false ) String error, 
			@RequestParam(value = "logput", required =false ) String logout,
						Model model, Principal principal, RedirectAttributes flash) {
		
		if(principal !=null) {
			flash.addAttribute("info", "ya ha iniciado sessión");
			return "redirect:/";
		}
		if(error !=null) {
			model.addAttribute("error"," error en login, usuario o contraseña incorrecta, vuelva a intentarlo ");
		}
		if(logout!=null ) {
			model.addAttribute("success", "Ha cerrado sesion con exito");
		}	
		return"login";
	}
}
