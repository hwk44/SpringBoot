package edu.pnu.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import edu.pnu.domain.TestVO;
//import edu.pnu.sevice.BoardService;
import edu.pnu.service.MemberService;
import edu.pnu.service.TestDAO;

@RestController
public class MemberController {

	private TestDAO testdao;
	private MemberService memberService;
	
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);

	public MemberController() {
		memberService = new MemberService();
		testdao = new TestDAO(); // 드라이버 로드 
	}
	
	@GetMapping("/member")
	public List<MemberVO> showMembers() {
		return memberService.getMembers();
	}
	
	@GetMapping("/member/{id}")
	public MemberVO showMember(@PathVariable int id) {
		log.info("getMember() "+ id);
		
		return memberService.getMember(id);
	}
	
	@PostMapping("/member")
	public MemberVO addMember(MemberVO member) {
		log.info("addMember()");
		return memberService.addMember(member);
	}
	
	@PutMapping("/member")
	public MemberVO updateMember(MemberVO member) {
		log.info("updateMember()");
		return memberService.updateMember(member);
	}
	
	@DeleteMapping("/member/{id}")
	public MemberVO deleteMember(@PathVariable Integer id) {
		log.info("deleteMember()");
		return memberService.deleteMember(id);
	}
	
	// -----------------------------------------------------------------------------
	// Test table
	
	
	@GetMapping("/test/{id}")
	public TestVO member(@PathVariable int id) {
		log.info("test() "+ id);
		
		return testdao.getTest(id);
	}


	

}
