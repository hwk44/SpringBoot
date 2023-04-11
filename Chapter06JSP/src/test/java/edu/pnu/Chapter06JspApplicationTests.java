package edu.pnu;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@SpringBootTest
class Chapter06JspApplicationTests {

	@Autowired
	BoardRepository boardRepo;
	
	@Test
	void contextLoads() {
		
		for(long i =1 ; i <= 10; i++) {
			Board board = new Board();
			board.setSeq(i);
			board.setTitle("게시판프로그램테스트");
			board.setWriter("도우너");
			board.setContent("게시판 프로그램 테스트입니다.");
			board.setCreateDate(new Date());
			board.setCnt(0L);
			boardRepo.save(board);
		}
	}

}
