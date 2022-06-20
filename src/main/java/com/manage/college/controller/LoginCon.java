package com.manage.college.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manage.college.models.Login;
import com.manage.college.services.LoginSer;

@Controller
public class LoginCon {
	@Autowired
	 private LoginSer service;

	 @RequestMapping("/")
		public String shownewstudent(Model model) throws Exception {
		 Login student=new Login ();
			model.addAttribute("adduserlogin", student);
			return "Login";
		}

		@RequestMapping(value="/Login",method=RequestMethod.POST)
		public String saveStudent(@ModelAttribute("student") Login student) throws Exception {
		service.save(student);
			return "index";
		}
		@RequestMapping("/Login")
		public String Loginnew() throws Exception {		
			return "index";

		}
}