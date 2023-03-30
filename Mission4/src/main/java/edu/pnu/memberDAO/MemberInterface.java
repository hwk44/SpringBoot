package edu.pnu.memberDAO;

import java.util.List;
import java.util.Map;

import edu.pnu.memberdomain.MemberVO;

public interface MemberInterface {

	// 전체 리스트 출력
	List<MemberVO> getMembers();

	// post add 
	MemberVO addMember(MemberVO member);

	// 자원 닫기
	void close();

	// get
	MemberVO getMember(int id);

	// put update
	MemberVO updateMember(MemberVO member);

	// get list 받기
	Map<String, Object> getMap();

	// delete 지우기
	MemberVO deleteMember(Integer id);

}