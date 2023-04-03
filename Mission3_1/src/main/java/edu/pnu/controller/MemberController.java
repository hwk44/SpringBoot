package edu.pnu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;
import edu.pnu.domain.MemberVO;
import edu.pnu.memberDAO.MemberDAOListImpl;
import edu.pnu.memberDAO.MemberInterface;
import edu.pnu.service.MemberService;

@RestController
public class MemberController {
	
	MemberInterface memberdaoh2impl ;
	MemberDAOListImpl memberDAOListImpl;
	MemberService memberService;
	
	// private static final Logger log = (Logger) LoggerFactory.getLogger(MemberController.class);
	
	
	public MemberController() {
		// TODO Auto-generated constructor stub
		memberService = new MemberService();
		System.out.println("member controller 생성자");
	}
	
	@GetMapping("/member/{id}")
	public MemberVO getmember(@PathVariable int id) {
		return memberService.getMember(id);
	}
	
	@GetMapping("/member")
	public List<MemberVO> getMembers() {
		return memberService.getMembers();
	}
	
	@DeleteMapping("/member/{id}")
	public MemberVO deleteMember(@PathVariable int id) {
		return memberService.deleteMember(id);
	}
	
	@PostMapping("/member")
	public MemberVO addMember(MemberVO member) {
		return memberService.addMember(member);
	}
	
	@PutMapping("/member")
	public MemberVO updateMember(MemberVO member) {
		return memberService.updateMember(member);
	}
	
	 
}
