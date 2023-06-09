package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Person;
import edu.pnu.sevice.BoardService;

@RestController
public class BoardController {
	
	@Autowired // new 로 강제로 넣는게 아니고 컨테이너를 찾아서 외부에서 넣어줌 injection
	BoardService boardService; //  = new BoardService();
	
	public BoardController() {
		System.out.println("===> BoardController 생성 ");
	}
	
	// get 방식으로 요청이 들어왔을때 실행될 메소드
	@GetMapping("/hello")
	public String hello(String name) {
		
		return "Hello : " + name ;
	}
	
	// post 방식으로 요청이 들어왔을때 실행될 메소드
	// post 방식이라 url 에 아무리 쳐도 나오지 않음
	@PostMapping("/hello")
	public String hello1(String name) {
		return "Hello Post : " + name ;
	}
	
	@GetMapping("/getPerson")
	public Person getPerson() {
		return new Person("홍길동", 2000, "백수", "음주");
	}
	
	
	@GetMapping("/getPersons")
	public List<Person> getPersons() {
//		List<Person> list = new ArrayList<>();
//		list.add(new Person("홍이동", 2001, "백수", "음주"));
//		list.add(new Person("홍길동", 2000, "백수", "음주"));
//		list.add(new Person("홍삼동", 2002, "백수", "음주"));
//		return list;
		
		// boardService 인스턴스의 getPersons 매서드를 이용해서 List객체 return 하도록
		return boardService.getPersons();
	}
	// 구동 방식 설명
	/*
	  브라우저 url 입력 컨트롤러로 감  webServlet("/hello")
	  스프링이 서블릿을 제공해준다.
	  RestController 
	  
	  서블릿에도 container가 있음
	  spring boot 에는 인스턴스를 만들어 container에 만들어놓음
	  어떤 명령에 의해? @RestController 이 명령에 의해
	  저 어노테이션이 있으면 new 명령으로 인스턴스를 만들어 놓음
	 */

}
