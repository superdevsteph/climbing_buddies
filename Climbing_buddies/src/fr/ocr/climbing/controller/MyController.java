package fr.ocr.climbing.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.ocr.climbing.dao.TopoDAO;
import fr.ocr.climbing.dao.UserDAO;
import fr.ocr.climbing.model.TopoInfo;
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
	private TopoDAO topoDAO;

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

	@RequestMapping("/infos")
	public String infos(Model model) {

		return "infos";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)

	public String username(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}

	@RequestMapping("/userList")
	public String userList(Model model) {
		List<UserInfo> list = userDAO.listUserInfos();
		model.addAttribute("userInfos", list);
		return "userList";
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
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, null, new CustomDateEditor(dateFormat, true));
	}

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


	@RequestMapping(value = { "/welcome" }, method = RequestMethod.GET)

	public String welcome(Model model) {

		return "welcome";

	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String register(Model model, //
			@ModelAttribute("registration") @Validated UserInfo userInfo, //
			BindingResult result, //
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return this.registration(model, userInfo);
		}

		this.userDAO.saveUser2(userInfo);

		// Important!!: Need @EnableWebMvc
		// Add message to flash scope
		redirectAttributes.addFlashAttribute("message", "Create Account Successful");

		return "redirect:/welcome";

	}

	private String registration(Model model, UserInfo userInfo) {
		model.addAttribute("userForm", userInfo);

		if (userInfo.getId() == null) {
			model.addAttribute("formTitle", "Create User");
		} else {
			model.addAttribute("formTitle", "Edit User");
		}

		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)

	public String registration(Model model) {

		model.addAttribute("userForm", new UserInfo());

		return "registration";

	}

	@RequestMapping("/topoList")
	public String topoList(Model model) {
		List<TopoInfo> list = topoDAO.listTopoInfos();
		model.addAttribute("topoInfos", list);
		return "topoList";
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

	private String formTopo(Model model, TopoInfo topoInfo) {
		model.addAttribute("userForm", topoInfo);

		if (topoInfo.getId() == null) {
			model.addAttribute("formTitle", "Create Topo");
		} else {
			model.addAttribute("formTitle", "Edit Topo");
		}

		return "formTopo";
	}

	@RequestMapping("/formTopo")
	public String createTopo(Model model) {

		TopoInfo topoInfo = new TopoInfo();

		return this.formTopo(model, topoInfo);
	}

	@RequestMapping("/editTopo")
	public String editTopo(Model model, @RequestParam("id") Long id) {
		TopoInfo topoInfo = null;
		if (id != 0) {
			topoInfo = this.topoDAO.findTopoInfo(id);
		}
		if (topoInfo == null) {
			return "redirect:/topoList";
		}

		return this.formTopo(model, topoInfo);
	}

	@RequestMapping("/deleteTopo")
	public String deleteTopo(Model model, @RequestParam("id") Long id) {
		if (id != 0) {
			this.topoDAO.deleteTopo(id);
		}
		return "redirect:/topoList";
	}

	// Save or update Topo
	// 1. @ModelAttribute bind form value
	// 2. @Validated form validator
	// 3. RedirectAttributes for flash value
	@RequestMapping(value = "/saveTopo", method = RequestMethod.POST)
	public String saveTopo(Model model, //
			@ModelAttribute("userForm") @Validated TopoInfo topoInfo, //
			BindingResult result, //
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return "formTopo";
		}

		this.topoDAO.saveTopo(topoInfo);

		// Important!!: Need @EnableWebMvc
		// Add message to flash scope
		redirectAttributes.addFlashAttribute("message", "Save Topo Successful");

		return "redirect:/topoList";

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
	
	
	// Save or update User
		// 1. @ModelAttribute bind form value
		// 2. @Validated form validator
		// 3. RedirectAttributes for flash value
		@RequestMapping(value = "/saveUser2", method = RequestMethod.POST)
		public String saveUser2(Model model, //
				@ModelAttribute("userForm") @Validated UserInfo userInfo, //
				BindingResult result, //
				final RedirectAttributes redirectAttributes) {

			if (result.hasErrors()) {
				return this.registration(model, userInfo);
			}

			this.userDAO.saveUser2(userInfo);

			// Important!!: Need @EnableWebMvc
			// Add message to flash scope
			redirectAttributes.addFlashAttribute("message", "Save User Successful");

			return "redirect:/welcome";

		}
	
	
	
	
}