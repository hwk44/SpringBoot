package edu.pnu;


import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@SpringBootTest
public class BoardRepositoryTest {
	
	@Autowired
	BoardRepository boardRepo;
//	@Test
	public void BoardInsertTest() {
		for (int i = 0; i < 101; i++) {
			
		    double d = Math.random();
	        Long data = (long) (d * 100);
	        
			Board b = new Board();
			b.setTitle("title"+i);
			b.setContent("content" + i);
			b.setWriter("writer" +i);
			b.setCreateDate(new Date());
			b.setCnt(data);
			
			boardRepo.save(b);
//			if(i==4) i= i/0;
		}
		
		
	}
	
//	@Test
	public void findByTitleContaining() {
		List<Board> boardList = boardRepo.findByTitleContaining("1");
		System.out.println("findByTitleContaining 검색 결과");
		for (Board board : boardList) {
			System.out.println("====>" + board.toString());
		}
	}
	
//	@Test
	public void findByTitleContainingAndCntGreaterthan() {
		List<Board> boardList = boardRepo.findByTitleContainingAndCntGreaterThan("1", 50);
		System.out.println("findByTitleContainingAndCntGreaterthan 검색 결과");
		for (Board board : boardList) {
			System.out.println("====>" + board.toString());
		}
	}
	
//	@Test
	public void findBySeqGreaterThanAndLessThan() {
		List<Board> boardList = boardRepo.findBySeqGreaterThanEqualAndSeqLessThanEqualOrderBySeq(10, 50);
		System.out.println("findBySeqGreaterThanAndLessThan 검색 결과");
		for (Board board : boardList) {
			System.out.println("====>" + board.toString());
		}
	}
	
	
//	@Test
	public void findByTitleContainingOrContentContainingOrderBySeqDesc() {
		List<Board> boardList = boardRepo.findByTitleContainingOrContentContainingOrderBySeqDesc("10", "2");
		System.out.println("findByTitleContainingOrContentContainingOrderBySeqDesc 검색 결과");
		for (Board board : boardList) {
			System.out.println("====>" + board.toString());
		}
	}
	
	
	// 아이디로 조회 
//	@Test
	public void testGetBoard() {
		Board b = boardRepo.findById(1L).get();
		System.out.println(b.toString());
	}
	
	// 수정 테스트
//	@Test
	public void testUpdateBoard() {
		System.out.println("1번 게시글 조회");
		Board b = boardRepo.findById(1L).get();
		
		System.out.println("=== 1번 게시글 제목 수정 ===");
		b.setTitle("제목 수정");
		boardRepo.save(b);
	}
	
	// 삭제 테스트
//	@Test
	public void testDeleteBoard() {
		System.out.println("=== 게시글 삭제 ===");
		boardRepo.deleteById(1L);
	}
	
	@Test
	public void test() {
//		Pageable page = PageRequest.of(0, 3, Sort.Direction.DESC );
		Pageable page = PageRequest.of(0, 5);
		List<Board> list = boardRepo.queryAnnotationTest(page, "91");
		
		for (Board board : list) {
			System.out.println(board.toString());
		}
		
//		for (Object[] board : list) {
//		//	System.out.println("===>" +board.toString());
//			for (Object s : board) {
//				System.out.print(s + "  ");
//			}
//			System.out.println();
//		}
//		for(String board : list) 
	}
	
	
}
