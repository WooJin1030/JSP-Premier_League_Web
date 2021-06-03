package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
			String sql = "update teamdata set name=?, origin=?, establishment=?, nickname=?, logoUrl=?, managername=?, managerimageurl=?, chairmanname=?, officialsite=?, stadiumname=?, stadiumimageurl=?, capacity=?, fieldsize=?, teamcolor=?, managercount=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getOrigin());
			pstmt.setInt(3, bean.getEstablishment());
			pstmt.setString(4, bean.getNickname());
			pstmt.setString(5, bean.getLogoUrl());
			pstmt.setString(6, bean.getManagername());
			pstmt.setString(7, bean.getManagerimageurl());
			pstmt.setString(8, bean.getChairmanname());
			pstmt.setString(9, bean.getOfficialsite());
			pstmt.setString(10, bean.getStadiumname());
			pstmt.setString(11, bean.getStadiumimageurl());
			pstmt.setInt(12, bean.getCapacity());
			pstmt.setString(13, bean.getFieldsize());
			pstmt.setString(14, bean.getTeamcolor());
			pstmt.setInt(15, bean.getManagercount());
			pstmt.setInt(16, bean.getId());
			
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
	
	@Override
	public LeagueTeamInfoBean selectTeamById(int id) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from teamdata inner join comments on teamdata.id=comments.teamid where teamdata.id=?";
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
	
	
	@Override
	public List<LeagueTeamInfoBean> selectList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from teamdata";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<LeagueTeamInfoBean> teamList = new ArrayList<>();
			while (rs.next()) {
				teamList.add(createFromResultSet(rs));
			}
			return teamList;
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
		int managercount = -1;
		
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
			managercount = rs.getInt("managercount");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return new LeagueTeamInfoBean(id, name, origin, establishment, nickname, logoUrl, managername, managerimageurl, chairmanname, officialsite, stadiumname, stadiumimageurl, capacity, fieldsize, teamcolor, managercount);
	}
	
}
