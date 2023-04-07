package edu.pnu;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.domain.Member;
import edu.pnu.persistence.BoardRepository;
import edu.pnu.persistence.MemberRepository;

@SpringBootTest
public class RelationMappingTest {

	@Autowired
	BoardRepository boardRepo;
	
	@Autowired
	MemberRepository memberRepo;
	
//	@Test
	public void testManyToOneInsert() {
		
		System.out.println("Test");
		for (int j = 0; j < 5; j++) {
			Member m1 = new Member();
			m1.setId("member" + j);
			m1.setPassword("member1" + j);
			m1.setName("멤버1" + j);
			m1.setRole("User" + j);
			memberRepo.save(m1);	

		
			for(int i = 0; i < 3 ; i++) {
				Board b = new Board();
				b.setMember(m1);
				b.setTitle("member" + i +"가 등록한 게시글" + j);
				b.setContent("member" + i +"가 등록한 게시글 내용" + j);
				b.setCreateDate(new Date());
				b.setCnt((long) Math.random() * 50); // 50 이하 임의 정수
//				b.setCnt(0L);
				boardRepo.save(b);
				
			}
		}
	}
	
	@Test
	public void testTwoWayMapping() {
		Member m = memberRepo.findById("member0").get();
		
		System.out.println("=".repeat(30));
		System.out.println(m.getName() + "가(이) 저장한 게시글 목록");
		System.out.println("=".repeat(30));
		List<Board> blist = m.getBoardList();
		for (Board b : blist) {
			System.out.println(b);
		}
		
	}
	
}
