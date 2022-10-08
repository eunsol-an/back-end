package com.myweb.www.ctrl;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myweb.www.domain.PagingVO;
import com.myweb.www.domain.ProductVO;
import com.myweb.www.handler.PagingHandler;
import com.myweb.www.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/product/*")
public class ProductController {
	
	@Inject
	private ProductService psv;
	
	@GetMapping("/write")
	public void write() {
		log.info(">>> ProductController > write - GET");
	}
	@PostMapping("/write")
	public String write(ProductVO pvo) {
		int isUp = psv.write(pvo);
		log.info(">>> ProductController > write - POST : {}", isUp > 0 ? "OK" : "FAIL");
		return "redirect:/product/list";
	}
	@GetMapping("/list")
	public void list(Model model, PagingVO pgvo) {
		log.info(">>> ProductController > list - GET");
		model.addAttribute("list", psv.getList(pgvo));
		int totalCount = psv.getTotalCount();
		log.info(">>> {}", pgvo);
		model.addAttribute("pgn", new PagingHandler(pgvo, totalCount));
	}
	@GetMapping(value = {"/detail", "/modify"})
	public void detail(Model model, @RequestParam("pno") long pno, @ModelAttribute("pgvo") PagingVO pgvo) {
		log.info(">>> ProductController > detail - GET");
		model.addAttribute("pvo", psv.getDetail(pno));
	}
//	@GetMapping("/modify")
//	public void modify(Model model, @RequestParam("pno") long pno) {
//		log.info(">>> ProductController > modify - GET");
//		model.addAttribute("pvo", psv.getDetail(pno));
//	}
	@PostMapping("/modify")
	public String modify(ProductVO pvo, RedirectAttributes rttr, PagingVO pgvo) {
		log.info(">>> ProductController > modify - POST");
		int isUp = psv.modify(pvo);
		rttr.addFlashAttribute("msg_mod", isUp);
		rttr.addAttribute("pageNo", pgvo.getPageNo());
		rttr.addAttribute("qty", pgvo.getQty());
		log.info(">>> ProductController > modify - POST : {}", isUp > 0 ? "OK" : "FAIL");
		return "redirect:/product/detail?pno=" + pvo.getPno();
	}
	@PostMapping("/remove")
	public String remove(@RequestParam("pno") long pno, RedirectAttributes rttr, PagingVO pgvo) {
		log.info(">>> ProductController > remove - POST");
		int isUp = psv.remove(pno);
		rttr.addFlashAttribute("msg_del", isUp);
		rttr.addAttribute("pageNo", pgvo.getPageNo());
		rttr.addAttribute("qty", pgvo.getQty());
		log.info(">>> ProductController > remove - POST : {}", isUp > 0 ? "OK" : "FAIL");
		return "redirect:/product/list";
	}
}
