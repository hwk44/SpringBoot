package edu.pnu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import edu.pnu.domain.DBoard;
import edu.pnu.service.BoardService;

@Controller
public class DBoardController {

	@Autowired
	BoardService dbService;
	
	@GetMapping("/board/{id}")
	public DBoard getDBoard(@PathVariable Long id) {
		return dbService.getDBoard(id);
	}
	
	@GetMapping("/board")
	public List<DBoard> getDBoard() {
		return dbService.getDBoardList();
	}

	public void getBoardList(org.springframework.ui.Model model) {
	List<DBoard> list = dbService.getDBoardList();
	model.addAttribute("boardlist", list);
	}
	
	
//	@GetMapping("/board")
//	public List<DBoard> getDBoardList(Long seq) {
//		if(seq == null) {
//			System.out.println("getBoard : ALL");
//			return dbService.getDBoardList();
//		}
////		return dbService.getDBoard(id);
//		System.out.println("getBoard : " + seq);
//		List<DBoard> list = new ArrayList<>();
//		list.add(dbService.getDBoard(seq));
//		return list;
//	}
}
