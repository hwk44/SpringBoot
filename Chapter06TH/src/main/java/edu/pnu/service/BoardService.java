package edu.pnu.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@Service
public class BoardService {
	
	@Autowired
	BoardRepository br;
	
//	@PostConstruct
//	public BoardService() {
//		for (int i = 0; i < 10; i++) {
//			Board b = new Board();
//			b.setCnt(0L);
//			b.setContent("test" + i);
//			b.setCreateDate(new Date());
//			b.setTitle("TestTilte" + i);
//			b.setWriter("Supervisor" + i);
//			br.save(b);
//		}
//	}

	public List<Board> getBoardList() {
		return (List<Board>) br.findAll();
	}

	public Board getBoard(long id) {
		return br.findById(id).get();
	}

	public Board addBoard(Board b) {
//		if (br.findById(b.getSeq()) == null) {
			br.save(b);
//		}
		return b;
	}

	public Board deleteBoard(long id) {
		Board b = br.findById(id).get();
		br.delete(b);
		return b;
	}

}
