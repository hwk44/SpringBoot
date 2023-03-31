package edu.pnu.memberDAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.pnu.domain.MemberVO;

public class MemberDAOListImpl implements MemberInterface {

	List<MemberVO> l;
	Map<String, Object> map;

	public MemberDAOListImpl() {

		// 생성 시 리스트에 값 넣음
		l = new ArrayList<>();
		for (int i = 1; i < 31; i++) {
			l.add(new MemberVO(i, "pass" + i, "이름" + i, new Date()));
		}
	}

	@Override
	public MemberVO getMember(int id) {
		map = new HashMap<>();
		map.put("method", "get");
		map.put("regidate", new Date());
		map.put("sqlstring", "select * from member where id = " + id);
		for (MemberVO vo : l) {
			if (vo.getId() == id) {
				map.put("success", true);
				return vo;
			}else map.put("success", false);
		}
		return null; // 인덱스 접근이라 값을 하나 빼줌
	}

	@Override
	public List<MemberVO> getMembers() {
		System.out.println("인터페이스 속 getMembers");
		map = new HashMap<>();
		map.put("method", "get");
		map.put("regidate", new Date());
		map.put("sqlstring", "getmembers");
		map.put("success", true);
		return l;
	}

	@Override
	public MemberVO deleteMember(Integer id) {
		map = new HashMap<>();
		map.put("method", "delete");
		map.put("regidate", new Date());
		map.put("sqlstring", "delete from member where id = "+ id);
		for (MemberVO vo : l) {
			if (vo.getId() == id) {
				map.put("success", true);
				l.remove(vo);
				return vo;
			}else {
				map.put("success", false);
			}
		}
		return null;
	}

	@Override // 추가 메서드
	public MemberVO addMember(MemberVO member) {
		map = new HashMap<>();
		map.put("method", "post");
		map.put("regidate", new Date());
		map.put("sqlstring", "insert into member(pass, name) values("
				+member.getPass() + "," + member.getName()+")");
		
		if (member.getId() == 0) { // id입력이 안되면?
			member.setId(l.size() + 1);
			l.add(member); // 멤버 추가
			map.put("success", true);
			return member;
		} else { // 입력되면?
			for (MemberVO vo : l) {
				if (vo.getId() == member.getId()) { // 실패
					map.put("success", false);
					return null;
				} else {// 성공
					l.add(member);
					map.put("success", true);
					return member;
				}
			}
		}
		return null;
	}

	@Override
	public MemberVO updateMember(MemberVO member) {
		map = new HashMap<>();
		map.put("method", "put");
		map.put("regidate", new Date());
		map.put("sqlstring", "UPDATE MEMBER SET pass="+member.getPass()
				+ ", name=" +member.getName() + " where id=" + member.getId());

		for (MemberVO vo : l) {
			if (vo.getId() == member.getId()) {
				if (member.getName() != null && member.getPass() != null) {
					vo.setName(member.getName());
					vo.setPass(member.getPass());
					vo.setRegidate(member.getRegidate());
					map.put("success", true);
					return vo;
				} else if (member.getName() != null && member.getPass() == null) {
					vo.setName(member.getName());
					vo.setRegidate(member.getRegidate());
					map.put("success", true);
					return vo;
				} else if (member.getPass() != null && member.getName() == null) {
					vo.setPass(member.getPass());
					vo.setRegidate(member.getRegidate());
					map.put("success", true);
					return vo;
				}
			}
			map.put("success", false);
			
		}

		return null;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	@Override
	public Map<String, Object> getMap() {
		// TODO Auto-generated method stub
		return map;
	}

}
