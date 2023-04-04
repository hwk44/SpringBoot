package com.rubypaper;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.transaction.Transaction;

import com.rubypaper.domain.Board;
import com.rubypaper.domain.BoardJPA;

public class JAPClient2 {
	EntityManagerFactory emf;
	EntityTransaction tx;

	public static void main(String[] args) {

		// EntityManager 생성
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04_mysql");
		
		// 데이터 입력
		insertBoard(emf);

//		 id 가 1 인 데이터 출력
//		findBoard(emf, 2L);

		
		//
//		findBoardManyNativeQuery(emf);
		emf.close();

	}
	private static void updateBoard(EntityManagerFactory emf, Long seq) {
		System.out.println("updateBoard");

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			Board board = em.find(Board.class, seq);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		TypedQuery<Board> result = em.createQuery("select b from Board b", Board.class);
	}
	
	private static void findBoardManyJPAQuery(EntityManagerFactory emf) {
		System.out.println("findBoardManyJPAQuery");

		EntityManager em = emf.createEntityManager();
		TypedQuery<Board> result = em.createQuery("select b from Board b", Board.class);
	}

	
	
	private static void findBoardManyNativeQuery(EntityManagerFactory emf) {
		System.out.println("findBoardManyNativeQuery");
		System.out.println("-".repeat(60));
		
		EntityManager em = emf.createEntityManager();
//		TypedQuery<Board> result = em.createQuery("select b from Board b", Board.class);
		
		List<?> list1 = em.createNativeQuery("select * from Board", Board.class).getResultList();
		
		for (Object b : list1) {
			System.out.println(b);
		}
		System.out.println("-".repeat(60));

		// 방법 3-2
//		@SuppressWarnings("unchecked")
//		List<Object[]> list2 = em.createNativeQuery("select * from Board").getResultList();
//		for (Object[] b : list2) {
//			for (int i = 0; i < b.length; i++) {
//				if(i != 0) System.out.print(",");
//				System.out.print(b[i]);
//			}
//			System.out.println();
//		}
//		System.out.println("=".repeat(80));
		
		em.close();
	}

	private static void findBoard(EntityManagerFactory emf, long l) {

		EntityManager em = emf.createEntityManager();
		try {
			// 글 상세 조회
			Board searchBoard = em.find(Board.class, l);
			System.out.println("-----> " + searchBoard.toString());

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			em.close();

		}

	}

	public static void insertBoard(EntityManagerFactory emf) {

		EntityManager em = emf.createEntityManager();
		// Transaction 생성
		EntityTransaction tx = em.getTransaction();
		try {

			// Transaction 시작
			tx.begin();

			for (int i = 1; i < 31; i++) {
				
				Board board = Board.builder()
//				BoardJPA board = BoardJPA.builder()
						.title("title" + +i)
						.content("content" + i)
						.createDate(new Date())
						.writer("writer" + i).build();
//				
//				Board board = new Board();
//				board.setTitle("JAP 제목" + i);
//				board.setWriter("관리자");
//				board.setContent("글 등록 잘 되네요." + "_".repeat(i));
//				board.setCreateDate(new Date());
//				board.setCnt(0L);

				// 글 등록
				// EntityManager 의 persist() 메소드로 Board 엔티티에 설정된 값을 테이블에 저장
				em.persist(board);
//				if (i == 30) {
//					int[] a = new int[2];
//					a[2] = i;
//				}
			}
			// Transaction 커밋
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			// Transaction rollback
			System.out.println("Transaction rollback");
			tx.rollback();
		} finally {
			em.close();
		}

	}

}
