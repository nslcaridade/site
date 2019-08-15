package br.com.caridade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.caridade.model.User;
import br.com.caridade.service.SecurityServiceImpl;
import br.com.caridade.service.UserServiceImpl;
import br.com.caridade.validator.UserValidator;

@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private SecurityServiceImpl securityService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration/registration";
    }
    
	/*
	 * @PostMapping("/registration") public String
	 * registration2(@ModelAttribute("userForm") User userForm, BindingResult
	 * bindingResult) { userValidator.validate(userForm, bindingResult);
	 * 
	 * if (bindingResult.hasErrors()) { return "registration"; }
	 * 
	 * userService.save(userForm);
	 * 
	 * securityService.autoLogin(userForm.getUsername(),
	 * userForm.getPasswordConfirm());
	 * 
	 * return "redirect:/welcome"; }
	 */

	
	  @PostMapping("/registration") public String registration(@RequestBody User userForm, BindingResult bindingResult) { 
		  userValidator.validate(userForm, bindingResult);
	  
		  if (bindingResult.hasErrors()) { 
			  return "registration/registration"; 
		  }
	  
		  userService.save(userForm);
	  
		  securityService.autoLogin(userForm.getUsername(),userForm.getPasswordConfirm());
	  
		  return "caridade"; 
	  }
	 

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

}