package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import dto.CommentBean;
import dto.MemberBean;


public class CommentImpl implements CommentDAO {
	
	private Connection conn = null;
	
	public CommentImpl(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public int insert(CommentBean bean) {
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into comments values (?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bean.getId());
			pstmt.setInt(2, bean.getTeamid());
			pstmt.setString(3, bean.getSessionid());
			pstmt.setString(4, bean.getText());
			
			Date date = Date.valueOf(bean.getDate());
			pstmt.setDate(5, date);
			
			Time time= Time.valueOf(bean.getTime());
			pstmt.setTime(6, time);
			
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return 0;	
	}
	
	@Override
	public int delete(int id) {
		PreparedStatement pstmt = null;
		try {
			String sql = "delete from comments where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return 0;
	}
	
	@Override
	public List<CommentBean> selectList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from comments order by date(date) desc,time desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<CommentBean> commentList = new ArrayList<>();
			while (rs.next()) {
				commentList.add(createFromResultSet(rs));
			}
			return commentList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	@Override
	public CommentBean selectById(int id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from comments where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return createFromResultSet(rs);
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}
	
	public CommentBean createFromResultSet(ResultSet rs) {
			
			int id = -1;
			int teamid = -1;
			String sessionid = null;
			String text = null;
			
			Date date = null;
			Time time = null;
			
			try {
				id = rs.getInt("id");
				teamid= rs.getInt("teamid");
				sessionid = rs.getString("sessionid");
				text = rs.getString("text");
				
				date = rs.getDate("date");
				time = rs.getTime("time");
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return new CommentBean(id, teamid, sessionid, text, date.toLocalDate(), time.toLocalTime());
			
			
		}
	
	
}
