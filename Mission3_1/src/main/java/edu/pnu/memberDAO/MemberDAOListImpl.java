package edu.pnu.memberDAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.pnu.domain.MemberVO;

public class MemberDAOListImpl implements MemberInterface {

	List<MemberVO> l;

	public MemberDAOListImpl() {

		// 생성 시 리스트에 값 넣음
		l = new ArrayList<>();
		for (int i = 1; i < 31; i++) {
			l.add(new MemberVO(i, "pass" + i, "이름" + i, new Date()));
		}
	}

	@Override
	public MemberVO getMember(int id) {
		for (MemberVO vo : l) {
			if (vo.getId() == id)
				return vo;
		}
		return null; // 인덱스 접근이라 값을 하나 빼줌
	}

	@Override
	public List<MemberVO> getMembers() {
		System.out.println("인터페이스 속 getMemberlist");
		return l;
	}

	@Override
	public MemberVO deleteMember(Integer id) {
		for (MemberVO vo : l) {
			if (vo.getId() == id) {
				l.remove(vo);
				return vo;
			}
		}
		return null;
	}

	@Override // 추가 메서드
	public MemberVO addMember(MemberVO member) {
		if (member.getId() == 0) {
			member.setId(l.size() + 1);
			l.add(member);
			return member;
		} else {
			for (MemberVO vo : l) {
				if (vo.getId() == member.getId()) {
					return null;
				} else {
					l.add(member);
					return member;
				}
			}
		}
		return null;
	}

	@Override
	public MemberVO updateMember(MemberVO member) {

		for (MemberVO vo : l) {
			if (vo.getId() == member.getId()) {
				if (member.getName() != null && member.getPass() != null) {
					vo.setName(member.getName());
					vo.setPass(member.getPass());
					vo.setRegidate(member.getRegidate());
					return vo;
				} else if (member.getName() != null && member.getPass() == null) {
					vo.setName(member.getName());
					vo.setRegidate(member.getRegidate());
					return vo;
				} else if (member.getPass() != null && member.getName() == null) {
					vo.setPass(member.getPass());
					vo.setRegidate(member.getRegidate());
					return vo;
				}
			}
		}

		return null;
	}

}
