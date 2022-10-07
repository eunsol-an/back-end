package com.corini.www.ctrl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.corini.www.service.BoardService;


@Controller
@RequestMapping("/board/*")
public class BoardController {
	private static Logger log = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardService bsv;
	
	@GetMapping("/list")
	public void list(Model model) {
		model.addAttribute("list", bsv.getList());
	}
	
	@GetMapping("/write")
	public void write() {
		
	}
}
