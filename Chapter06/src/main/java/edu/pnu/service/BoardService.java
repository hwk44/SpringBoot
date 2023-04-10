package edu.pnu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@Service
public class BoardService {
	public static void main(String[] args) {
	}

	@Autowired
	BoardRepository boardRepo;

	public String getBoard(Long i) {
		return boardRepo.findById(i).get().toString();
	}

	
	public void insertboard() {
//		for (int i = 0; i < 10; i++) {
//
//			Board b = new Board();
//			b.setContent("내용" + i);
//			b.setCount(0L);
//			b.setCreateDate(new Date());
//			boardRepo.save(b);
//		}
//		Board b = new Board();
//		b.setContent("content");
//		b.setCount(0);
//		b.setMember(null);
	}


	public List<Board> getBoards() {
		return (List<Board>) boardRepo.findAll();
	}

	

	public Board addboard(Board b) {
		// TODO Auto-generated method stub
//		if(!(List<Board>) boardRepo.findAll().contains(b))
		boardRepo.save(b);
		return null;
	}

}
