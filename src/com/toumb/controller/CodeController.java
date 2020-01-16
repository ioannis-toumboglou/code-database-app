package com.toumb.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.toumb.dao.CodeDAOImpl;
import com.toumb.entity.Code;
import com.toumb.service.CodeService;

@Controller
@RequestMapping("/code")
public class CodeController {
	// Need to inject Code Service
	@Autowired
	private CodeService codeService;
	
	@GetMapping("/list")
	public String listCode(Model model) {
		// Get the code list from the Service
		List<Code> codeList = codeService.getCode();
		
		// Add the code list to the model
		model.addAttribute("codeList", codeList);
		
		return "list-code";
	}
	
	@GetMapping("/showAddForm")
	public String showAddForm(Model model) {
		// Create model attribute to bind form data
		Code code = new Code();
		
		model.addAttribute("code", code);
		
		return "code-add-form";
	}
	
	@RequestMapping("/saveCode")
	public String saveCode(@ModelAttribute("code") Code code, BindingResult result, @RequestParam CommonsMultipartFile[] file) throws IOException {
		for(CommonsMultipartFile aFile : file) {
				code.setFileName(aFile.getOriginalFilename());
				code.setData(aFile.getBytes());
		}
		// Save the code using the service
		codeService.saveCode(code);
		
		return "redirect:/code/list";
	}
	
	@GetMapping("/showUpdateForm")
	public String showUpdateForm(@RequestParam("codeId") int id, Model model) {
		// Get code from the service
		Code code = codeService.getCode(id);
		// Set code as a model attribute to pre-populate the form
		model.addAttribute("code", code);
		// Send to the form		
		return "code-update-form";
	}
	
	@RequestMapping("/updateCode")
	public String updateCode(@ModelAttribute("code") Code code, BindingResult result) {
		// Save the code using the service
		codeService.updateCode(code);
		
		return "redirect:/code/list";
	}
	
	@GetMapping("/delete")
	public String deleteCode(@RequestParam("codeId") int id) {
		// Delete the code record
		codeService.deleteCode(id);
		
		return "redirect:/code/list";
	}
	
	@GetMapping("/search")
	public String searchCode(@RequestParam("searchKeyword") String keyword, Model model) {
		// Search for code using keyword
		List<Code> codeList = codeService.searchCode(keyword);
		model.addAttribute("codeList", codeList);
		
		return "list-code";
	}
	
	@RequestMapping("/download/{code.data}")
	public String download(@PathVariable("codeId") int id, HttpServletResponse response) {
		
		Code code = codeService.getCode(id);
		
		try {
			response.setHeader("Content-Disposition", "inline;filename=\"" + code.getFileName() + "\"");
			OutputStream out = response.getOutputStream();
			//IOUtils.copy(code.getData().get, out);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
}
