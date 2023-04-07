package edu.pnu;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.domain.BoardTest;
import edu.pnu.domain.Member;
import edu.pnu.persistence.BoardTestRepository;
import edu.pnu.persistence.MemberRepository;

@SpringBootTest
public class RelationsMappingTest {

	@Autowired
	BoardTestRepository boardtestRepo;
	@Autowired
	MemberRepository memberRepo;
	
//	@Test
	public void testTwoWayMapping() {
		Member m = memberRepo.findById("member1").get();
		System.out.println("=".repeat(30));
		System.out.println(m.getName() + "가 저장한 게시글 목록");
		System.out.println("=".repeat(30));
		List<Board> blist = m.getBoardList();
		for(Board b : blist) {
			System.out.println(b.toString());
		}
	}
	
	@Test
	public void testboard_member() {
		Member m1 = new Member();
		m1.setId("member1");
		m1.setPassword("member111");
		m1.setName("멤버1");
		m1.setRole("User1");
		memberRepo.save(m1);	
			
		BoardTest bt = new BoardTest();
		bt.setMember(m1);
		bt.setTitle("member1 가 등록한 게시글" );
		bt.setContent("member 가 등록한 게시글 내용");
		bt.setCreateDate(new Date());
//		bt.setCnt((long) Math.random() * 50); // 50 이하 임의 정수
		bt.setCnt(0L);
		boardtestRepo.save(bt);
		
//		Member m2 = new Member();
//		m1.setId("member2");
//		m1.setPassword("member222");
//		m1.setName("멤버2");
//		m1.setRole("User2");
//		memberRepo.save(m2);	
//			
//		BoardTest bt2 = new BoardTest();
//		bt.setMember(m2);
//		bt.setTitle("member2 가 등록한 게시글" );
//		bt.setContent("membe2 가 등록한 게시글 내용");
//		bt.setCreateDate(new Date());
////		bt.setCnt((long) Math.random() * 50); // 50 이하 임의 정수
//		bt.setCnt(0L);
//		boardtestRepo.save(bt2);
	}
}
