package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.LeagueTeamInfoBean;


public class LeagueTeamInfoImpl implements LeagueTeamInfoDAO {
	
	private Connection conn = null;
	
	public LeagueTeamInfoImpl(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public int edit(LeagueTeamInfoBean bean) {
		PreparedStatement pstmt = null;
		try {
			String sql = "update teamdata set name=?, origin=?, nickname=?, logoUrl=?, managername=?, managerimageurl=?, chairmanname=?, stadiumname=?, stadiumimageurl=?, capacity=?, fieldsize=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getOrigin());
			pstmt.setString(3, bean.getNickname());
			pstmt.setString(4, bean.getLogoUrl());
			pstmt.setString(5, bean.getManagername());
			pstmt.setString(6, bean.getManagerimageurl());
			pstmt.setString(7, bean.getChairmanname());
			pstmt.setString(8, bean.getStadiumname());
			pstmt.setString(9, bean.getStadiumimageurl());
			pstmt.setInt(10, bean.getCapacity());
			pstmt.setString(11, bean.getFieldsize());
			
			pstmt.setInt(12, bean.getId());
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
	public LeagueTeamInfoBean select(int id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from teamdata where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return createFromResultSet(rs);
			}
			else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("fuck");
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
	public LeagueTeamInfoBean selectByName(String name) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from teamdata where name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return createFromResultSet(rs);
			}
			else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("fuck");
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
	public LeagueTeamInfoBean selectMemberTeam(int id) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from teamdata inner join members on teamdata.id=members.myteam where teamdata.id=?";
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
	
	
	public LeagueTeamInfoBean createFromResultSet(ResultSet rs) {
		
		int id = -1;
		String name = null;
		String origin = null;
		int establishment = -1;
		String nickname = null;
		String logoUrl= null;
		String managername = null;
		String managerimageurl = null;
		String chairmanname = null;
		String officialsite = null;
		String stadiumname = null;
		String stadiumimageurl = null;
		int capacity = -1;
		String fieldsize = null;
		String teamcolor = null;
		
		try {
			id = rs.getInt("id");
			name = rs.getString("name");
			origin = rs.getString("origin");
			establishment = rs.getInt("establishment");
			nickname = rs.getString("nickname");
			logoUrl = rs.getString("logoUrl");	
			managername = rs.getString("managername");
			managerimageurl = rs.getString("managerimageurl");
			chairmanname = rs.getString("chairmanname");
			officialsite = rs.getString("officialsite");
			stadiumname = rs.getString("stadiumname");
			stadiumimageurl = rs.getString("stadiumimageurl");
			capacity = rs.getInt("capacity");
			fieldsize = rs.getString("fieldsize");
			teamcolor = rs.getString("teamcolor");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return new LeagueTeamInfoBean(id, name, origin, establishment, nickname, logoUrl, managername, managerimageurl, chairmanname, officialsite, stadiumname, stadiumimageurl, capacity, fieldsize, teamcolor);
	}
	
}
