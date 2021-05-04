package dao;

import dto.MemberBean;

public interface MemberDAO {
	int insert(MemberBean bean);
	MemberBean selectList(String id);
}
