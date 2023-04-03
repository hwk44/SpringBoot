package edu.pnu.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.pnu.domain.MemberVO;

@Service
public class MemberService {

	List<MemberVO> a = new ArrayList<>();
	
	public MemberService() {
		String s= "이름";
		String pass = "1234";
		for (int i = 1; i <= 5; i++) {
			a.add(new MemberVO(i, pass, s+String.valueOf(i), new Date()));
		}
	}
	
	public List<MemberVO> getMembers() {
		
		return a;
	}

	
	public MemberVO getMember(int id) {
		for (int i = 0; i < a.size(); i++) {
			if(a.get(i).getId() == id) return a.get(i);
		}
		return null;
		
	}


	public MemberVO addMember(MemberVO member) {
		member.setId(a.size() + 1);
		member.setRegidate(new Date());
		a.add(member);
		return member;
	}

	public MemberVO updateMember(MemberVO member) {
		for (int i = 0; i < a.size(); i++) {
			if(a.get(i).getId() == member.getId()) {
				a.get(i).setName(member.getName());
				a.get(i).setPass(member.getPass());
				return member;
			}
		}
		return null;
	}

	public MemberVO deleteMember(Integer id) {
		
		for (int i = 0; i < a.size(); i++) {
			if(a.get(i).getId() == id) {
//				MemberVO temp = a.get(i);
				a.remove(a.get(i));
				return a.get(i);
			}
		}
		return null;
	}



}
