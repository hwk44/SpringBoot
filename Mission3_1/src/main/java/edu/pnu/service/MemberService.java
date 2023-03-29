package edu.pnu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.pnu.domain.MemberVO;
import edu.pnu.memberDAO.MemberDAOH2Impl;
import edu.pnu.memberDAO.MemberDAOListImpl;
import edu.pnu.memberDAO.MemberInterface;

public class MemberService {
	
	private MemberInterface memberDao;
//	private List<MemberVO> list;
	
	// 생성자
	public MemberService() {
//		memberDao = new MemberDAOListImpl();
		memberDao = new MemberDAOH2Impl();
		
	}
	
	// 전체 리스트 출력
	public List<MemberVO> getMembers(){
		return memberDao.getMembers();
		
	}

	public MemberVO getMember(int id) {
		return memberDao.getMember(id);
	}

	public MemberVO deleteMember(int id) {
		// TODO Auto-generated method stub
		
		return memberDao.deleteMember(id);
	}

	public MemberVO addMember(MemberVO member) {
		// TODO Auto-generated method stub
		return memberDao.addMember(member);
	}

	public MemberVO updateMember(MemberVO member) {
		// TODO Auto-generated method stub
		return memberDao.updateMember(member);
	}
	
}
