package com.rubypaper;

import java.util.Date;
import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.rubypaper.domain.Board;

public class JAPClient2 {
	EntityManagerFactory emf;
	EntityTransaction tx;
	
	public static void insertBoard(EntityManagerFactory emf) {
		
			EntityManager em = emf.createEntityManager();	
			
			 //Transaction 생성
			EntityTransaction tx = em.getTransaction();
			
			try {
				// Transaction 시작
				tx.begin();
				
				for (int i = 1; i < 31; i++) {
					Board board = new Board();
					board.setTitle("JAP 제목" + i);
					board.setWriter("관리자");
					board.setContent("글 등록 잘 되네요."+ "_".repeat(i));	
					board.setCreateDate(new Date());
					board.setCnt(0L);
					
					// 글 등록
					// EntityManager 의 persist() 메소드로 Board 엔티티에 설정된 값을 테이블에 저장
					em.persist(board); 
					
					
//					  if (i == 30) { int[] a = new int[2]; a[2] = i; }
					 
					 
				}
				
				// Transaction 커밋
				tx.commit();
	
			} catch (Exception e) {
				e.printStackTrace();
				// Transaction  rollback
				System.out.println("Transaction  rollback");
				tx.rollback();
	
			}finally {
				em.close();
				emf.close();
			}
	}
	public static void main(String[] args) {

			// EntityManager 생성
			EntityManagerFactory emf =
					Persistence.createEntityManagerFactory("Chapter04");
			
			// 데이터 입력
			insertBoard(emf);
		
	}

}
