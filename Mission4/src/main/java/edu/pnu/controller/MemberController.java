package edu.pnu.controller;

import java.util.List;

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

	
	MemberService memberService;


	public MemberController() {
		 memberService =  new MemberService();
	}
	
	@GetMapping("/member/{id}")
	public MemberVO getMember(@PathVariable int id) {
		return memberService.getMember(id);
	}
	@GetMapping("/member")
	public List<MemberVO> getMember() {
		return memberService.getMembers();
	}
	
	@PutMapping("/member")
	public MemberVO updateMember(MemberVO member) {
		return memberService.updateMember(member);
	}
	
	@PostMapping("/member")
	public MemberVO addMember(MemberVO member) {
		return memberService.addMember(member);
	}
	@DeleteMapping("/member/{id}")
	public MemberVO deleteMember(@PathVariable int id) {
		return memberService.deleteMember(id);
	}
}
