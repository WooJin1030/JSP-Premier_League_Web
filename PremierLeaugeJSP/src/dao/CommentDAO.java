package dao;

import java.util.List;

import dto.CommentBean;

public interface CommentDAO {
	int insert(CommentBean bean);
	int delete(int id);
	List<CommentBean> selectList();
	CommentBean selectById(int id);
}
