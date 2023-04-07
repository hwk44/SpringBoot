package edu.pnu.persistence;

import org.springframework.data.repository.CrudRepository;

import edu.pnu.domain.BoardTest;

public interface BoardTestRepository extends CrudRepository<BoardTest, Long> {

}
