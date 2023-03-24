package edu.pnu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.TestVO;
import edu.pnu.service.TestDAO;

@RestController
public class TestController {
	
	private TestDAO testdao;
	private static final Logger log = LoggerFactory.getLogger(TestController.class);

	
	
	public TestController() {
		// TODO Auto-generated constructor stub
		testdao = new TestDAO();
		
	}

}
