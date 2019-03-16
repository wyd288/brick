package com.fan1111.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrameController {
	
	@RequestMapping(value="/frame")
	public String index(Model model){
		model.addAttribute("activeFrame", "activeMenu");
		return "frame";
	}
	
	

	@RequestMapping(value="/form.html")
	public String form(Model model){
		model.addAttribute("activeForm", "activeMenu");
		return "form";
	}
	
	@RequestMapping(value="/ui.html")
	public String ui(Model model){
		model.addAttribute("activeUI", "activeMenu");
		return "ui";
	}
	
	@RequestMapping(value="/chart.html")
	public String chart(Model model){
		model.addAttribute("activeChart", "activeMenu");
		return "chart";
	}
	
	@RequestMapping(value="/tabpanel.html")
	public String tabpanel(Model model){
		model.addAttribute("activetabpanel", "activeMenu");
		return "tabpanel";
	}
	
	
	
	
	
}
