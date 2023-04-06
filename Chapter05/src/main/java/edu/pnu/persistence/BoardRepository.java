package edu.pnu.persistence;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.pnu.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long> {
	
	List<Board> findByTitle(String searchKeyword);
	
	List<Board> findByTitleContaining(String searchKeyword);
	
	List<Board> findByTitleContainingAndCntGreaterThan(String searchKeyword, int a);
	
	List<Board> findBySeqGreaterThanEqualAndSeqLessThanEqualOrderBySeq(int a, int b);
	
	List<Board> findByTitleContainingOrContentContainingOrderBySeqDesc(String s1, String s2);
	
	
	@Query("select b from Board b where b.title like %?1% order by b.seq DESC")
	List<Board> queryAnnotationTest(Pageable paging, @Param("searchKeyword") String searchKeyword);
	

	@Query("select b from Board b where b.title like %:searchKeyword% order by b.seq DESC")
	List<Board> queryAnnotationTest2(@Param("searchKeyword") String searchKeyword);
	
	@Query(value = "SELECT SEQ, TITLE, WRITER, create_date"
			+ " from Board WHERE TITLE LIKE '%'||?1||'%' ORDER BY seq DESC"
			, nativeQuery = true)
	List<Object[]> queryAnnotationTest3(String searchKeyword); // 오브젝트 배열이 담긴 리스트

	@Query("select b from Board b order by b.seq DESC")
	List<Board> queryAnnotationTest4(Pageable paging);
}
