package com.toumb.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.toumb.entity.Code;
import com.toumb.service.CodeService;

@Controller
@RequestMapping("/code")
public class CodeController {
	File f = new File("test.txt");
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
			// Get file's name
			code.setFileName(aFile.getOriginalFilename());
			// Get file's data
			code.setData(aFile.getBytes());
			// Create a copy of the file
			copy_file(aFile.getInputStream(), aFile.getOriginalFilename());
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
		Code code = codeService.getCode(id);
		String fileName = code.getFileName();
		String path = SystemPath.path();
		File file = new File(path + fileName);
		file.delete();
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
	
	@RequestMapping(value="/resources/code-files/{code.fileName}", method=RequestMethod.GET)
	public void download(@PathVariable("fileName") String fileName, HttpServletResponse response) throws IOException {
		
		File file = new File("WebContent/resources/code-files/" + fileName);
		
		String mimeType = URLConnection.guessContentTypeFromName(file.getName());
		
		if (mimeType == null) {
			System.out.println("mimetype is not detectable, will get default");
			mimeType = "application/octet-stream";
		}
		System.out.println("mimeType: " + mimeType);
		
		response.setContentType(mimeType);
		response.setHeader("Content-Disposition", "inline;filename=\"" + file.getName() + "\"");
		response.setContentLength((int) file.length());
		
		InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
		
		FileCopyUtils.copy(inputStream, response.getOutputStream());

	}
	
	public void copy_file(InputStream file, String fileName) throws IOException {
		// Create the folder in which the files are stored
		String path = SystemPath.path();
		Path destinationPath = Paths.get(path);
		
		if(!Files.exists(destinationPath)) {
			try {
				Files.createDirectories(destinationPath);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// Create a copy of the desired file in the directory
		File copiedFile = new File(path + fileName);
		
		try (				
			InputStream in = new BufferedInputStream(file);
			OutputStream out = new BufferedOutputStream(new FileOutputStream(copiedFile))) {
			
			byte[] buffer = new byte[1024];
			int lengthRead;
			while((lengthRead = in.read(buffer)) > 0) {
			    out.write(buffer, 0, lengthRead);
			    out.flush();
			}
		}
		
	}
	
}
