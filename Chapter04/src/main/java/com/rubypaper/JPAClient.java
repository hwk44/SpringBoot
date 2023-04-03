package com.rubypaper;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.rubypaper.domain.Board;

public class JPAClient {

	public static void main(String[] args) {

		// EntityManager 생성
		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();
		
		
//		// Transaction 생성
//		EntityTransaction tx = em.getTransaction();
//		
//		try {
//			// Transaction 시작
//			tx.begin();
//			
//			Board board = new Board();
//			board.setTitle("JAP 제목");
//			board.setWriter("관리자");
//			board.setContent("글 등록 잘 되네요.");	
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
//			
//			// 글 등록
//			em.persist(board); // EntityManager 의 persist() 메소드로 Board 엔티티에 설정된 값을 테이블에 저장
//			
//			// Transaction 커밋
//			tx.commit();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			// Transaction  rollback
//			tx.rollback();
//
//		}finally {
//			em.close();
//			emf.close();
//		}
		try { // 글 상세 조회
			Board searchBoard = em.find(Board.class, 1L);
			System.out.println("------>" + searchBoard.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
			emf.close();
		}
	}

}
