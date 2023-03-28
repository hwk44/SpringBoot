package edu.pnu;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.DAO.memberDAO;
import edu.pnu.domain.memberVO;

@SpringBootTest
class Mission3ApplicationTests {

	@Test
	void contextLoads() {
		System.out.println("테스트입니다.");
	}
	
	@Test
	void testMemberDAO() {
		System.out.println("이것은 MemberDAO를 테스트 합니다.");
		
		memberDAO DAO = new  memberDAO();
		
		List<memberVO> list = DAO.getMemberlist();
		for(memberVO m : list) {
			System.out.println(m);
		}
		
	}

}
