package com.cn.ugia.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cn.ugia.domain.User;
import com.cn.ugia.service.IUserService;
import com.cn.ugia.util.Page;
import com.github.pagehelper.PageHelper;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private IUserService userService;

	@RequestMapping("listUser")
	public ModelAndView listUser(Page page) {
		if(page == null || page.getStart() < 0) {
			page = new Page();
			page.setStart(0);
		}
		PageHelper.offsetPage(page.getStart(),5);
		ModelAndView modelAndView = new ModelAndView();
		List<User> users = userService.listUser();
		modelAndView.addObject("users", users);
		modelAndView.setViewName("listUser");
		return modelAndView;
	}
	
//	@RequestMapping("/showUser")
//	public String toIndex(HttpServletRequest request, Model model) {
//		int userId = Integer.parseInt(request.getParameter("id"));
//		User user = this.userService.getUserById(userId);
//		model.addAttribute("user", user);
//		return "showUser";
//	}
	
	@RequestMapping("/showAddUser")
	public String showAddUser(HttpServletRequest request, Model model) {
		return "showAddUser";
	}
	
	@RequestMapping("/addUser")
	public ModelAndView addUser(User user) {
		userService.addUser(user);
		return null;
	}
}
