package edu.pnu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardRepository br;


	public List<Board> getBoardList() {
		return (List<Board>) br.findAll();
	}


	public void insertBoard(Board b) {
		br.save(b);
	}


	public Board getBoard(Board b) {
		return br.findById(b.getSeq()).get();
	}


	public void updateBoard(Board b) {

		Board b1 = br.findById(b.getSeq()).get();
		b1.setTitle(b.getTitle());
		b1.setContent(b.getContent());
		br.save(b1);
	}

	public void deleteBoard(Board b) {
		br.deleteById(b.getSeq());
	}

}
