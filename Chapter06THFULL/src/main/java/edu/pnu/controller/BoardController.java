package edu.pnu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Board;
import edu.pnu.domain.Member;
import edu.pnu.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService bs;
	
	@RequestMapping("/hello")
	public void hello(Model model) {
		model.addAttribute("greeting", "Hello 타임리프.^^~~");
	}
	
	@RequestMapping("/getBoardList")
	public void getBoardList(Model model) {
		model.addAttribute("boardList", bs.getBoardList());
	}
	@GetMapping("/insertBoard")
	public String insertBoard(@ModelAttribute("member") Member member) {
		if(member.getId() == null) {
			return "redirect:login";
		}
		return "insertBoard";
	}
	
	@PostMapping("/insertBoard")
	public String insertBoard(Board b) {
		bs.insertBoard(b);
		return "forward:getBoardList";
	}
	
	@RequestMapping("/getBoard")
	public void getBoard(Board b , Model model) {
		model.addAttribute("board", bs.getBoard(b));
	}
	
	@PostMapping("/updateBoard")
	public String updateBoard(Board b, Model model) {
		model.addAttribute("board", bs.getBoard(b));
		bs.updateBoard(b);
		return "forward:getBoardList";
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard( Board board) {
//		model.addAttribute("board", bs.getBoard(b));
		bs.deleteBoard(board);
		return "redirect:getBoardList";
	}
	
//	@GetMapping("/login")
//	public void loginView() {
//		
//	}
}
