package edu.pnu.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.pnu.domain.Board;
import edu.pnu.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	// 하나만 받을때
//	@RequestMapping(value="/getBoardList", method = RequestMethod.GET )

	
	// get put post delete 4개 다 받음
	@RequestMapping("/getBoardList")
	public String getBoardList(Model model, Board board) {
//		public List<Board> getBoardList(Model model) {
//		List<Board> boardList = new ArrayList<>();
		List<Board> boardList = boardService.getBoardList(board);
//		for(long i =1 ; i <= 10; i++) {
//			Board board = new Board();
//			board.setSeq(i);
//			board.setTitle("게시판프로그램테스트");
//			board.setWriter("도우너");
//			board.setContent("게시판 프로그램 테스트입니다.");
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
//			boardList.add(board);
//		}
		model.addAttribute("boardList", boardList);
		return "board/getboardlist"; // 뷰 이름을 리턴
//		return boardList;
	}
	
	// 상세보기
	@GetMapping("/getBoard")
	public String getBoard(Board board, Model model) {
		model.addAttribute("board", boardService.getBoard(board));
		return "board/getBoard";
	}
	
	// 게시글 작성/추가 화면 보여주기
	@GetMapping("/insertBoardView")
	public String insertBoardView() {
		return "board/insertBoard";
	}
	@GetMapping("/insertBoard")
	public String insertBoard() {
		return "board/insertBoard";
	}
	
	// 게시글 추가 메서드
	@PostMapping("/insertBoard")
	public String insertBoard(Board board) {
		boardService.insertBoard(board);
		return "redirect:getBoardList";
	}
	
	//
	@PostMapping("/updateBoard")
	public String updateBoard(Board board) {
		boardService.updateBoard(board);
		return "forward:getBoardList";
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(Board board) {
		boardService.deleteBoard(board);
		return "redirect:getBoardList";
	}
	
}
