package fr.ocr.climbing.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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
import fr.ocr.climbing.model.TopoInfo;
import fr.ocr.climbing.validator.TopoValidator;

@Controller
// Enable Hibernate Transaction.
@Transactional
// Need To use RedirectAttributes
@EnableWebMvc
public class TopoController {

	
	@Autowired
	private TopoDAO topoDAO;


	
	@Autowired
	private TopoValidator topoValidator;
	

	
	
	
	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");   
	    dateFormat.setLenient(false);
	    binder.registerCustomEditor(Date.class, null,  new CustomDateEditor(dateFormat, true));
	}
	
	
	
	
	@InitBinder
	protected void initBinder(WebDataBinder dataBinder) {
		// Form target
		Object target = dataBinder.getTarget();
		if (target == null) {
			return;
		}
		System.out.println("Target=" + target);

		if (target.getClass() == TopoInfo.class) {
			dataBinder.setValidator(topoValidator);
		}
	}


	   
	@RequestMapping("/topoList")
	public String topoList(Model model) {
		List<TopoInfo> list = topoDAO.listTopoInfos();
		model.addAttribute("topoInfos", list);
		return "topoList";
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
  
	   

}