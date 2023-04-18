package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Board;
import edu.pnu.service.BoardService;

//@RestController
@Controller
public class BoardController {

	@Autowired
	BoardService bs;

	@GetMapping("/hello")
	public void hello(Model model) {
		model.addAttribute("greeting", "Hello Thymeleaf ~~ ^^");
	}

	@GetMapping("/getBoardList")
	public void getBoardList(Model model) {
		model.addAttribute("boardList", bs.getBoardList());
	}

	@GetMapping("/getBoard")
	public void getBoard(Model model, Board board) {
		model.addAttribute("board", bs.getBoard(board.getSeq()));
	}

	@GetMapping("/insertBoard")
	public void getBoard() {
	}

	@PostMapping("/insertBoard")
	public void insertBoard(Board board) {
		bs.addBoard(board);
	}

	@GetMapping("/board")
	public @ResponseBody List<Board> getBoardList() {
		return bs.getBoardList();
	}

	@GetMapping("/board/{id}")
	public @ResponseBody Board getBoard(@PathVariable Long id) {
//		if (bs.getBoard(id) == null) return null;
		return bs.getBoard(id);
	}

	@PostMapping("/board")
	public @ResponseBody Board addBoard(@RequestBody Board b) {
		return bs.addBoard(b);
	}

	@DeleteMapping("/board/{id}")
	public @ResponseBody Board deleteBoard(@RequestBody @PathVariable Long id) {
		return bs.deleteBoard(id);
	}
}
