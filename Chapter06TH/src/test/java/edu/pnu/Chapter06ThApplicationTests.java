package edu.pnu;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@SpringBootTest
class Chapter06ThApplicationTests {

//	@Test
	void contextLoads() {
	}
	
	@Autowired
	BoardRepository br;
	
	@Test
	public void Boardtest() {
		for (int i = 0; i < 10; i++) {
			Board b = new Board();
//			b.setCnt(0L);
			b.setContent("test" + i);
//			b.setCreateDate(new Date());
			b.setTitle("TestTilte" + i);
			b.setWriter("Supervisor" + i);
			br.save(b);
		}
	}

}
