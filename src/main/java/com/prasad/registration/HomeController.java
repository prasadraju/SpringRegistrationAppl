package com.prasad.registration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import  com.prasad.registration.model.User;
import com.prasad.registration.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@Autowired
	UserService service;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) { 
		logger.info("Welcome home!", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	 @RequestMapping(value = "/HelloWorld", method = RequestMethod.GET)
	 @ResponseBody
	 public String getData(){
		 
	    return getProperty(); 
     }
	 
	 private String getProperty() {
		 try {
			 File configDir = new File(System.getProperty("catalina.base"), "conf");
			 File configFile = new File(configDir, "catalina.properties");
			 InputStream stream = new FileInputStream(configFile);
			 Properties props = new Properties();
			 props.load(stream);
			return props.getProperty("name");

			} catch (IOException e) {
				logger.info(e.toString());
				e.printStackTrace();
				return e.toString();
			}
	 }
	
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() {
		 return new ModelAndView("registerform", "command", new User());
	}
	
	@RequestMapping(value = "/addUser",method=RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("SpringWeb") User user,  ModelMap model) {
		
		
		service.register(user);
		String resultMsg=user.getUsername()+" added successfully";
		return new ModelAndView("successpage","resultMsg",resultMsg);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
		 return new ModelAndView("loginform", "command", new User());
	}
	
	
	
	@RequestMapping(value = "/authenticateuser",method=RequestMethod.POST)
	public ModelAndView checkUser(@ModelAttribute("SpringWeb") User user,  ModelMap model) {

		System.out.println("HomeController.addLogin()"+user.getUsername()+":"+user.getPassword());
		
		boolean result=service.checkUser(user);
		
		
		String resultMsg;
		if(result) {
			resultMsg="Welcome "+user.getUsername();
			return new ModelAndView("successpage","resultMsg",resultMsg);
		}else {
			resultMsg="Username not exists try again! ";
			return new ModelAndView("errorpage","resultMsg",resultMsg);
		}
		
		
		
//	    public void addLogin( Login login) {
	    
//		model.addAttribute("ID", login.getUsername());
//	    model.addAttribute("name", login.getPassword());
	     
//	    ModelAndView mav=new ModelAndView();
//	    mav.addObject("user", login);
//	    mav.setViewName("successpage");
//	    return mav;
		
//		String resultMsg;
//		if(user.getUsername().equalsIgnoreCase("raju")&&user.getPassword().equalsIgnoreCase("123")) {
//			resultMsg="Welcome "+user.getUsername();
//		}else {
//			resultMsg="Username not exists try again! ";
//		}
		
		
	   
		
		
		
	
	
	}
	
}
