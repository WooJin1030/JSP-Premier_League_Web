package dto;


public class MyTeamBean implements Comparable<MyTeamBean> {
	
	// private static final long serialVersionUID = 1L;
	private String when;
	private String referee;
	private int matchNumber;
	private String team1Name;
	private int team1Score;
	private int team1FirstHalfScore;
	private String team2Name;
	private int team2Score;
	private int team2FirstHalfScore;
	
	public MyTeamBean () {
		this(null, null, 0, null, 0, 0, null, 0, 0);
	}

	public MyTeamBean(String when, String referee, int matchNumber, String team1Name, int team1Score,
			int team1FirstHalfScore, String team2Name, int team2Score, int team2FirstHalfScore) {
		super();
		this.when = when;
		this.referee = referee;
		this.matchNumber = matchNumber;
		this.team1Name = team1Name;
		this.team1Score = team1Score;
		this.team1FirstHalfScore = team1FirstHalfScore;
		this.team2Name = team2Name;
		this.team2Score = team2Score;
		this.team2FirstHalfScore = team2FirstHalfScore;
	}

	public String getWhen() {
		return when;
	}

	public void setWhen(String when) {
		this.when = when;
	}

	public String getReferee() {
		return referee;
	}

	public void setReferee(String referee) {
		this.referee = referee;
	}

	public int getMatchNumber() {
		return matchNumber;
	}

	public void setMatchNumber(int matchNumber) {
		this.matchNumber = matchNumber;
	}

	public String getTeam1Name() {
		return team1Name;
	}

	public void setTeam1Name(String team1Name) {
		this.team1Name = team1Name;
	}

	public int getTeam1Score() {
		return team1Score;
	}

	public void setTeam1Score(int team1Score) {
		this.team1Score = team1Score;
	}

	public int getTeam1FirstHalfScore() {
		return team1FirstHalfScore;
	}

	public void setTeam1FirstHalfScore(int team1FirstHalfScore) {
		this.team1FirstHalfScore = team1FirstHalfScore;
	}

	public String getTeam2Name() {
		return team2Name;
	}

	public void setTeam2Name(String team2Name) {
		this.team2Name = team2Name;
	}

	public int getTeam2Score() {
		return team2Score;
	}

	public void setTeam2Score(int team2Score) {
		this.team2Score = team2Score;
	}

	public int getTeam2FirstHalfScore() {
		return team2FirstHalfScore;
	}

	public void setTeam2FirstHalfScore(int team2FirstHalfScore) {
		this.team2FirstHalfScore = team2FirstHalfScore;
	}

	@Override
	public String toString() {
		return "MyTeamBean [when=" + when + ", referee=" + referee + ", matchNumber=" + matchNumber + ", team1Name="
				+ team1Name + ", team1Score=" + team1Score + ", team1FirstHalfScore=" + team1FirstHalfScore
				+ ", team2Name=" + team2Name + ", team2Score=" + team2Score + ", team2FirstHalfScore="
				+ team2FirstHalfScore + "]";
	}
	
	@Override
	public int compareTo(MyTeamBean compareMyteam) {
		
	   int compareMatchNumber = compareMyteam.getMatchNumber();
        return this.matchNumber-compareMatchNumber;

	}

	
}
