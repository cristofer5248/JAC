	package com.jac.app.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model, Principal principal,
			RedirectAttributes flash) {
		model.addAttribute("titulo","inicio");
		if (principal != null) {
			flash.addFlashAttribute("info", "Ya has iniciado sesion anteriormente");
			return "redirect:/notificaciones/";
		}
		if (error != null) {
			model.addAttribute("error", "Error en el login");
		}
		if (logout != null) {
			model.addAttribute("success", "Has cerrado sesion con exito");
		}
		return "login";
	}

}
