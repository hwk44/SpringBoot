package edu.pnu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Member;
import edu.pnu.persistence.MemberRepository;

@Service
public class MemberService {
	
	private List<Member> memberList;

	@Autowired
	MemberRepository memberRepo;

//	public MemberService() {
//		// TODO Auto-generated constructor stub
//		for (int i = 0; i < 10;  i++) {
//			Member m1 = new Member();
////			m1.setMemberID(i);
//			m1.setName("길동"+ i);
//		    m1.setPassword("gildong" + i );
//		    m1.setRole("학생");
//		    memberRepo.save(m1);
//		    }
//	}

	public List<Member> getmembers() {
		memberList = (List<Member>) memberRepo.findAll();
		return memberList;
	}

	public void insertmembers() {

		for (int i = 0; i < 10; i++) {
			Member m1 = new Member();
//			m1.setMemberID(i);
			m1.setName("길동" + i);
			m1.setPassword("gildong" + i);
			m1.setRole("학생");
			memberRepo.save(m1);
		}
	}

	public Member getmember(Long i) {
		return memberRepo.findById(i).get();
	}
}
