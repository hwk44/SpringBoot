package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;

@RestController
public class MemberController {

	@Autowired
	MemberService memberService;

//	public MemberController() {
//		System.out.println("MemberController 생성자");
//		memberService = new MemberService();
//	}

	@GetMapping("/member/{id}")
	public MemberVO getMember(@PathVariable int id) {
		return memberService.getMember(id);
	}

	@GetMapping("/member")
	public List<MemberVO> getMembers() {
		return memberService.getMembers();
	}

	@PostMapping("/member")
	public MemberVO addMember(MemberVO member) {
		return memberService.addMember(member);
	}

	@PutMapping("/member")
	public MemberVO updateMember(MemberVO member) {
		return memberService.updateMember(member);
	}

	@DeleteMapping("/member/{id}")
	public MemberVO deleteMembers(@PathVariable int id) {
		return memberService.deleteMembers(id);
	}
}
