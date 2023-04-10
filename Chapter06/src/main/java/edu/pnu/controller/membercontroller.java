package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Board;
import edu.pnu.domain.Member;
import edu.pnu.persistence.BoardRepository;
import edu.pnu.persistence.MemberRepository;
import edu.pnu.service.BoardService;
import edu.pnu.service.MemberService;

@RestController
public class membercontroller {

	BoardRepository boardRepo;
	MemberRepository memberRepo;

//	public membercontroller() {
		// TODO Auto-generated constructor stub
//		for (int i = 0; i < 2; i++) {
//			Member m = new Member();
//			m.setName("길동"+ i);
//		    m.setPassword("gildong" + i );
//		    m.setRole("학생");
//		    memberRepo.save(m);
//		    for (int j = 0; j < 2; j++) {
//		    	Board b = new Board();
//				b.setContent("content");
//				b.setCount(0);
//				b.setMember(m);
//				boardRepo.save(b);
//			}
//		}
//	}

	@Autowired
	MemberService memberService;

	@Autowired
	BoardService boardService;

	@GetMapping("/board/{id}")
	public String getBoard(@PathVariable Long id) {
		return boardService.getBoard(id);
	}

	@GetMapping("/board")
	public List<Board> getBoards() {
		return boardService.getBoards();
	}

	@GetMapping("/insertboard")
	public void insertBoard() {
		boardService.insertboard();
	}

	@PostMapping("/board")
	public Board addBoard(Board b) {
		return boardService.addboard(b);
	}

	// -----------------------------------------------
	
	@GetMapping("/member")
	public List<Member> getmembers() {
		System.out.println("memberController __ getmembers");
		return memberService.getmembers();
	}

	@GetMapping("/member/{id}")
	public Member getmember(@PathVariable Long id) {
		System.out.println("memberController __ getmembers");
		return memberService.getmember(id);
	}

	@GetMapping("/insertmembers")
	public void insertMembers() {
		System.out.println("insertMembers");
		memberService.insertmembers();

	}

}
