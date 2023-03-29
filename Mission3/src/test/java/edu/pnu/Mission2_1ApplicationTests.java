package edu.pnu;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.DAO.MemberDAO;
import edu.pnu.domain.MemberVO;

@SpringBootTest
class Mission2_1ApplicationTests {

	@Test
	void contextLoads() {
		System.out.println("테스트입니다.");
	}
	
	@Test
	void testMemberDAO() {
		System.out.println("이것은 MemberDAO를 테스트 합니다.");
		
		MemberDAO DAO = new  MemberDAO();
		
		List<MemberVO> list = DAO.getMemberlist();
		for(MemberVO m : list) {
			System.out.println(m);
		}
		
	}

}
