package edu.pnu.service;

import java.util.List;

import edu.pnu.domain.MemberVO;
import edu.pnu.logDAO.LogDAO;
import edu.pnu.logDAO.LogInterface;
import edu.pnu.memberDAO.MemberDAO;
import edu.pnu.memberDAO.MemberInterface;

public class MemberService {

	private MemberInterface memberDAO;
	private LogInterface logdao;

	public MemberService() {
		memberDAO = new MemberDAO();
//		memberDAO = new MemberDAOListImpl();
		
		logdao = new LogDAO();
		
		
		}

	public MemberVO getMember(int id) {
		MemberVO vo = memberDAO.getMember(id);
		logdao.addLog(memberDAO.getMap());
		return vo;
	}

	public List<MemberVO> getMembers() {
		List<MemberVO> list = memberDAO.getMembers();
		logdao.addLog(memberDAO.getMap());
		return list;
	}

	public MemberVO updateMember(MemberVO member) {
		MemberVO vo = memberDAO.updateMember(member);
		logdao.addLog(memberDAO.getMap());
		return vo;
	}

	public MemberVO addMember(MemberVO member) {
		MemberVO vo = memberDAO.addMember(member);
		logdao.addLog(memberDAO.getMap());
		return vo;
	}

	public MemberVO deleteMember(int id) {
		MemberVO vo = memberDAO.deleteMember(id);
		logdao.addLog(memberDAO.getMap());
		return vo;
	}

}
