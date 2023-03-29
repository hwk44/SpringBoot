package edu.pnu.memberDAO;

import java.util.List;

import edu.pnu.domain.MemberVO;

public interface MemberInterface {

	// 특정 아이디만 받아 출력
	MemberVO getMember(int id);

	// 전체 출력
	List<MemberVO> getMembers();

	// 데이터 삭제 
	MemberVO deleteMember(Integer id);

	// 데이터 추가 post add
	MemberVO addMember(MemberVO member);
	
	// 데이터 변경 put update
	MemberVO updateMember(MemberVO member);


}