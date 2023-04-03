package edu.pnu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.dao.log.LogDAO;
import edu.pnu.dao.member.MemberDAO;
import edu.pnu.domain.MemberVO;

@Service
public class MemberService {

	@Autowired
	MemberDAO memberDAO;

	@Autowired
	LogDAO logDAO;

//	public MemberService() throws ClassNotFoundException, SQLException {
//		memberDAO = new MemberDAO(); 
//		logDAO = new LogDAO();
//	}

	public MemberVO getMember(int id) {
		MemberVO vo = memberDAO.getMember(id);
		logDAO.addlog(memberDAO.getMap());
		return vo;
	}

	public List<MemberVO> getMembers() {
		List<MemberVO> a = memberDAO.getMembers();
		logDAO.addlog(memberDAO.getMap());
		return a;
	}

	public MemberVO addMember(MemberVO member) {
		MemberVO vo = memberDAO.addMember(member);
		logDAO.addlog(memberDAO.getMap());
		return vo;
	}

	public MemberVO updateMember(MemberVO member) {
		MemberVO vo = memberDAO.updateMember(member);
		logDAO.addlog(memberDAO.getMap());
		return vo;
	}

	public MemberVO deleteMembers(int id) {
		MemberVO vo = memberDAO.deleteMember(id);
		logDAO.addlog(memberDAO.getMap());
		return vo;
	}

}
