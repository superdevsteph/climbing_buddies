package fr.ocr.climbing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.ocr.climbing.dao.UserDAO;
import fr.ocr.climbing.model.UserInfo;
import fr.ocr.climbing.validator.UserValidator;

@Controller
// Enable Hibernate Transaction.
@Transactional
// Need To use RedirectAttributes
@EnableWebMvc
public class MyController {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private UserValidator userValidator;

	@RequestMapping("/")
	public String homePage(Model model) {

		return home(model);
	}

	@RequestMapping("/home")
	public String home(Model model) {

		return "home";
	}

	@RequestMapping("/logout")
	public String logout(Model model) {

		return "home";
	}

	@RequestMapping("/userList")
	public String userList(Model model) {
		List<UserInfo> list = userDAO.listUserInfos();
		model.addAttribute("userInfos", list);
		return "userList";
	}

	private String formUser(Model model, UserInfo userInfo) {
		model.addAttribute("userForm", userInfo);

		if (userInfo.getId() == null) {
			model.addAttribute("formTitle", "Create User");
		} else {
			model.addAttribute("formTitle", "Edit User");
		}

		return "formUser";
	}

	@RequestMapping("/formUser")
	public String createUser(Model model) {

		UserInfo userInfo = new UserInfo();

		return this.formUser(model, userInfo);
	}

	@RequestMapping("/editUser")
	public String editUser(Model model, @RequestParam("id") Long id) {
		UserInfo userInfo = null;
		if (id != 0) {
			userInfo = this.userDAO.findUserInfo(id);
		}
		if (userInfo == null) {
			return "redirect:/userList";
		}

		return this.formUser(model, userInfo);
	}

	@RequestMapping("/deleteUser")
	public String deleteUser(Model model, @RequestParam("id") Long id) {
		if (id != 0) {
			this.userDAO.deleteUser(id);
		}
		return "redirect:/userList";
	}

	// Set a form validator
	@InitBinder
	protected void initBinder(WebDataBinder dataBinder) {
		// Form target
		Object target = dataBinder.getTarget();
		if (target == null) {
			return;
		}
		System.out.println("Target=" + target);

		if (target.getClass() == UserInfo.class) {
			dataBinder.setValidator(userValidator);
		}
	}

	// Save or update User
	// 1. @ModelAttribute bind form value
	// 2. @Validated form validator
	// 3. RedirectAttributes for flash value
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveUser(Model model, //
			@ModelAttribute("userForm") @Validated UserInfo userInfo, //
			BindingResult result, //
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return this.formUser(model, userInfo);
		}

		this.userDAO.saveUser(userInfo);

		// Important!!: Need @EnableWebMvc
		// Add message to flash scope
		redirectAttributes.addFlashAttribute("message", "Save User Successful");

		return "redirect:/userList";

	}

	@RequestMapping("/login")
	public String login(Model model) {

		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)

	public String login(Model model, String error, String logout) {

		if (error != null)

			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)

			model.addAttribute("message", "You have been logged out successfully.");
		return "login";

	}

	@RequestMapping(value = { "/welcome" }, method = RequestMethod.GET)

	public String welcome(Model model) {

		return "welcome";

	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)

	public String registration(Model model) {

		model.addAttribute("userForm", new UserInfo());

		return "registration";

	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)

	public String registration(@ModelAttribute("userForm") UserInfo userInfo, BindingResult bindingResult,
			Model model) {

		userValidator.validate(userInfo, bindingResult);

		if (bindingResult.hasErrors()) {
			return "registration";
		}

		if (userInfo.getId() == null) {
			model.addAttribute("formTitle", "Create User");
		} else {
			model.addAttribute("formTitle", "Edit User");
		}
		return "redirect:/welcome";
	}

}