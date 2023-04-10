package edu.pnu;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.domain.Member;
import edu.pnu.persistence.BoardRepository;
import edu.pnu.persistence.MemberRepository;
import edu.pnu.service.MemberService;

@SpringBootTest
class Mission6ApplicationTests {

	@Autowired
	MemberRepository memberRepo;
	@Autowired
	BoardRepository boardRepo;

	@Test
	void contextLoads() {
//		MemberService ms = new MemberService();
//		ms.insertmembers();
		Member m = new Member();
		m.setName("병원");
		m.setPassword("병원1");
		m.setRole("개인병원");
		memberRepo.save(m);
		
		for (int j = 0; j < 2; j++) {
			Board b = new Board();
			b.setContent("휴진입니다.");
			b.setCreateDate(new Date());
			b.setCount(0);
			b.setMember(m);
			boardRepo.save(b);
		}
		

	}

}
