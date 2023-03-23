package edu.pnu.sevice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.pnu.domain.Person;

@Service
public class BoardService {

	private List<Person> list = new ArrayList<>();
	
	
	public BoardService() {
		
		System.out.println("===> BoardService 생성 ");
		
		list.add(new Person("홍이동", 2001, "백수", "음주"));
		list.add(new Person("홍길동", 2000, "백수", "음주"));
		list.add(new Person("홍삼동", 2002, "백수", "음주"));
	}

	public List<Person> getPersons() {
		return list;
	}
}
