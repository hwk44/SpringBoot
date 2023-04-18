package edu.pnu.service;

import java.util.List;

import edu.pnu.domain.Board;

public interface BoardService {

	List<Board> getBoardList();

	void insertBoard(Board b);

	Board getBoard(Board b);

	void updateBoard(Board b);

	void deleteBoard(Board b);

}