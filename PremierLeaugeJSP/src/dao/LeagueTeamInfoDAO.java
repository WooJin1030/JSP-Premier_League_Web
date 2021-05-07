package dao;

import dto.LeagueTeamInfoBean;


public interface LeagueTeamInfoDAO {
	
	int edit(LeagueTeamInfoBean bean);
	LeagueTeamInfoBean select(int id);
	LeagueTeamInfoBean selectMemberTeam(int id);
}

