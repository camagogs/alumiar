package com.project.alumiar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.alumiar.models.NewsLetter;
import com.project.alumiar.services.NewsLetterService;

@Controller
public class NewsLetterController {
	
	@Autowired
	private NewsLetterService newsService;
	
	@RequestMapping("/admin/newsletter/listEmails")
	public String listarEmail(Model model) {
		
		Iterable<NewsLetter> users = newsService.list(); 
		
		model.addAttribute("users", users);
		
		return "forms/newsletter/listEmails";
	}
	
	
	@RequestMapping("/admin/newsletter/saveEmail")
	public String saveNewsLetter(Model model,
			RedirectAttributes redirectAtt,
			@RequestParam("nome") String nome,
			@RequestParam("email") String email) {
		
		NewsLetter n = new NewsLetter(nome, email);
		
		newsService.save(n);
		
		redirectAtt.addFlashAttribute("messageEmail", "Pronto, agora é só aguardar, email cadastrado com sucesso!!!");
		
		return "redirect:/#email-confirmado";
	}
	

}
