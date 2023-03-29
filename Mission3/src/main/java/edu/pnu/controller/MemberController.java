package edu.pnu.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.DAO.MemberDAO;
import edu.pnu.domain.MemberVO;
//import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;

@RestController
public class MemberController {
	
	private MemberDAO memberdao;
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	
	public MemberController() {
		memberdao = new MemberDAO();
//		log.info("TestController 생성자");
//		log.error("Error Message 입니다.");
//		log.warn("warn Message 입니다.");
//		log.info("info Message 입니다.");
//		log.debug("debug Message 입니다.");
//		log.trace("trace Message 입니다.");
	}
	
	
	// Get 아이디 하나만
	@GetMapping("/member/{id}")
	public MemberVO member(@PathVariable int id) {
		log.info("member() "+ id);
//		memberdao.close();
		return memberdao.getMember(id);
		
	}
	
	// Get 아이디 전체
	@GetMapping("/member")
	public List<MemberVO> getmembers() {
		log.info("memberlist()");
//		memberdao.close();
		return memberdao.getMemberlist();
	}
	
	
	// post 방식으로 add
	@PostMapping("/member")
	public MemberVO addMember(MemberVO member) {
		log.info("addMember(member) post 방식");
		System.out.println(member);
		return memberdao.addMember(member);
	}
	
	// put 방식으로 update
	@PutMapping("/member")
	public MemberVO updateMember(MemberVO member) { // put 방식으로는 객체 자체를 던짐
		log.info("updateMember(member) put 방식");
		return memberdao.updateMember(member);
	}

	// Delete 방식으로 delete
	@DeleteMapping("/member/{id}")
	public Integer deleteMember(@PathVariable Integer id) {
		log.info("deleteMember()");
		return memberdao.deleteMember(id);
	}
}
