package com.myweb.www.ctrl;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myweb.www.domain.FileVO;
import com.myweb.www.domain.MemberDTO;
import com.myweb.www.domain.MemberVO;
import com.myweb.www.domain.PagingVO;
import com.myweb.www.handler.FileHandler;
import com.myweb.www.handler.PagingHandler;
import com.myweb.www.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	private static Logger log = LoggerFactory.getLogger(MemberController.class);
	// 스프링 프레임워크는 실행할 때 @Component로 등록된 모든 클래스를 사전에 인스턴스로 만든다
	// @Component로 인스턴스된 클래스들은 @Inject, @Autowired를 통해 사용할 수 있다
	// DispatcherServlet은 request가 발생하면 분석하기 위해 @requestMapping을 호출한다
	// @requestMappping은 uri값의 패턴에 따라 각 메서드에게 실행주문을 전달한다
	
	@Inject
	private MemberService msv;
	
	@Inject
	private FileHandler fhd;
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public void register() {
		// request의 uri 패턴이 같다면 void로 선언 후 그대로 viewResolver에게 전달
		// 해당 uri와 같은 위치의 jsp로 forward 된다
		log.info(">>> MemberController > register - GET");
	}
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String register(MemberVO mvo, 
			@RequestParam(name = "imgAttached", required = false) MultipartFile file) {
		log.info(">>> register-mvo : {}", mvo);
		FileVO fvo = new FileVO();
		if (file != null) {
			fvo = fhd.getFile(file);
		}
		int isUp = msv.register(new MemberDTO(mvo, fvo));
		log.info(">>> MemberController > register - POST : {}", isUp > 0 ? "OK" : "FAIL");
		return "redirect:/";
	}
	@GetMapping("/list") // Spring framework 4.3 부터 지원
	public void list(Model model, PagingVO pgvo) {
		log.info(">>> MemberController > list - GET");
		List<MemberVO> list = msv.getList(pgvo);
		model.addAttribute("list", list);
		model.addAttribute("pgn", new PagingHandler(pgvo, msv.getTotalCount(pgvo)));
	}
	@GetMapping(value = {"/detail", "/modify"})
	public void detail(Model model, @RequestParam("email") String email,
			@ModelAttribute("pgvo") PagingVO pgvo) {
		log.info(">>> MemberController > detail - GET");
		model.addAttribute("mdto", msv.getDetail(email));
	}
	@PostMapping("/modify")
	public String modify(MemberVO mvo, 
			@RequestParam(name = "imgAttached", required = false) MultipartFile file, 
			RedirectAttributes rttr, 
			PagingVO pgvo) {
		log.info(">>> MemberController > modify - POST");
		FileVO fvo = new FileVO();
		if (file != null) {
			fvo = fhd.getFile(file);
		}
		int isUp = msv.modify(new MemberDTO(mvo, fvo));
//		ses.setAttribute("ses", mvo);
		rttr.addAttribute("pageNo", pgvo.getPageNo());
		rttr.addAttribute("qty", pgvo.getQty());
		rttr.addAttribute("type", pgvo.getType());
		rttr.addAttribute("kw", pgvo.getKw());
		log.info("{}", pgvo);
		log.info(">>> MemberController > update - POST : {}", isUp > 0 ? "OK" : "FAIL");
		return "redirect:/member/detail?email=" + mvo.getEmail();
	}
	@DeleteMapping(value = "/img/{uuid}", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> removeImg(@PathVariable("uuid") String uuid) {
		return msv.removeImg(uuid) > 0 ?
				new ResponseEntity<String>("1", HttpStatus.OK)
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@PostMapping("/remove")
	public String remove(MemberVO mvo, RedirectAttributes rttr,
			PagingVO pgvo) {
		log.info(">>> MemberController > remove - POST");
		int isUp = msv.remove(mvo.getEmail());
		rttr.addAttribute("pageNo", pgvo.getPageNo());
		rttr.addAttribute("qty", pgvo.getQty());
		rttr.addAttribute("type", pgvo.getType());
		rttr.addAttribute("kw", pgvo.getKw());
		log.info(">>> MemberController > delete - POST : {}", isUp > 0 ? "OK" : "FAIL");
		return "redirect:/member/list";
	}
	@GetMapping("/login")
	public void login() {
		log.info(">>> MemberController > login - GET");
	}
	@PostMapping("/login")
	public String login(MemberVO mvo, HttpSession ses, RedirectAttributes rttr) {
		log.info(">>> MemberController > login - POST");
		MemberDTO sesMdto = msv.login(mvo);
		if (sesMdto != null) {
			ses.setAttribute("sesDto", sesMdto);
			ses.setMaxInactiveInterval(600); // 초단위
			log.info(">>> MemberController > login - OK");
			rttr.addFlashAttribute("isLogin", 1);
			return "redirect:/";
		}else {
			rttr.addFlashAttribute("isLogin", 1);
			return "redirect:/member/login";
		}
	}
	@GetMapping("/logout")
	public String logout(HttpSession ses, RedirectAttributes rttr) {
		log.info(">>> MemberController > logout - POST");
		ses.removeAttribute("ses"); // ses 라는 이름을 갖는 세션 객체를 삭제
		ses.invalidate();
		log.info(">>> MemberController > logout - OK");
		rttr.addFlashAttribute("isLogout", 1);
		return "redirect:/";
	}
	@ResponseBody
	@PostMapping(value = "/dupleCheck", consumes = "application/json",
				produces = {MediaType.TEXT_PLAIN_VALUE})
	public String dupleCheck(@RequestBody HashMap<String, String> map) {
		// ajax -> email: ?
		log.info(">>> {}", map.get("email"));
		int isExist = msv.dupleCheck(map.get("email"));
		return isExist > 0? "1" : "0";
	}
}
