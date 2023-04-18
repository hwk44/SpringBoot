package edu.pnu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.domain.Member;
import edu.pnu.persistence.BoardRepository;
import edu.pnu.persistence.MemberRepository;

@SpringBootTest
class Chapter06ThfullApplicationTests {

	@Autowired
	BoardRepository br;
	
	@Autowired
	MemberRepository mr;
	
	@Test
	void contextLoads() {
		
		Member m1 = new Member();
		m1.setId("member1");
		m1.setName("둘리");
		m1.setPassword("member111");
		m1.setRole("ROLE_USER");
		mr.save(m1);
		
		Member m2 = new Member();
		m2.setId("member2");
		m2.setName("도우너");
		m2.setPassword("member222");
		m2.setRole("ROLE_ADMIN");
		mr.save(m2);
		for (int i = 1; i <= 3; i++) {
			Board board = new Board();
			board.setTitle(m1.getName()+ "가 등록한 게시글");
			board.setWriter(m1.getName());
			board.setContent(m1.getName()+ "가 등록한 게시글 내용" + i);
			br.save(board);			
		}
		for (int i = 1; i <= 3; i++) {
			Board board = new Board();
			board.setTitle(m2.getName()+ "가 등록한 게시글");
			board.setWriter(m2.getName());
			board.setContent(m2.getName()+ "가 등록한 게시글 내용" + i);
			br.save(board);			
		}
	}

}
