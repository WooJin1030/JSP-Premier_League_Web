package dao;

import java.util.List;

import dto.LeagueTeamInfoBean;


public interface LeagueTeamInfoDAO {
	
	int edit(LeagueTeamInfoBean bean);
	LeagueTeamInfoBean select(int id);
	List<LeagueTeamInfoBean> selectList();
	LeagueTeamInfoBean selectByName(String name);
	LeagueTeamInfoBean selectMemberTeam(int id);
	LeagueTeamInfoBean selectTeamById(int id);
}

