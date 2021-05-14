package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dto.MemberBean;

public class MemberImpl implements MemberDAO {
	
	private Connection conn = null;
	
	public MemberImpl(Connection conn) {
		this.conn = conn;
	}
	
	public int insert(MemberBean bean) {
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into members values (?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bean.getId());
			pstmt.setString(2, bean.getPassword());
			pstmt.setString(3, bean.getName());
			pstmt.setString(4, bean.getEmail());
			pstmt.setInt(5, bean.getMyteam());
			
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
	public MemberBean selectList(String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from members where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
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
	
	@Override
	public int edit(MemberBean bean) {
		PreparedStatement pstmt = null;
		try {
			String sql = "update members set password=?, name=?, email=?, myteam=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getPassword());
			pstmt.setString(2, bean.getName());
			pstmt.setString(3, bean.getEmail());
			pstmt.setInt(4, bean.getMyteam());
			pstmt.setString(5, bean.getId());
			
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
	
	public MemberBean createFromResultSet(ResultSet rs) {
		String id = null;
		String password = null;
		String name = null;
		String email = null;
		int myteam = -1;
		
		try {
			id = rs.getString("id");
			password = rs.getString("password");
			name = rs.getString("name");
			email = rs.getString("email");
			myteam = rs.getInt("myteam");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return new MemberBean(id, password, name, email, myteam);
	}
}
