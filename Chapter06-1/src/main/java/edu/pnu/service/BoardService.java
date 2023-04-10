package edu.pnu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domain.DBoard;
import edu.pnu.persistence.BoardRepository;

@Service
public class BoardService {

	@Autowired
	BoardRepository boardRepo;
	
	public DBoard getDBoard(Long id) {
		return boardRepo.findById(id).get();
//		return null;
	}

	public List<DBoard> getDBoardList() {
		return (List<DBoard>) boardRepo.findAll();
//		return null;
	}

}
