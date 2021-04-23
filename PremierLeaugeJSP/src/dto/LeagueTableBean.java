package dto;

public class LeagueTableBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private int rank;
	private String team;
	private int played; // 경기 수 
	private int win; // 승
	private int draw; // 무
	private int loss;// 패
	private int goalsFor; // 득점
	private int goalsAgainst; // 실점
	private int points; // 승점
	
	public LeagueTableBean() {
		this(0, null, 0, 0, 0, 0, 0, 0, 0);
	}
	
	public LeagueTableBean(int rank, String team, int played, int win, int draw, int loss, int goalsFor, int goalsAgainst,
			int points) {
		super();
		this.rank = rank;
		this.team = team;
		this.played = played;
		this.win = win;
		this.draw = draw;
		this.loss = loss;
		this.goalsFor = goalsFor;
		this.goalsAgainst = goalsAgainst;
		this.points = points;
	}
	
	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public int getPlayed() {
		return played;
	}
	public void setPlayed(int played) {
		this.played = played;
	}
	public int getWin() {
		return win;
	}
	public void setWin(int win) {
		this.win = win;
	}
	public int getDraw() {
		return draw;
	}
	public void setDraw(int draw) {
		this.draw = draw;
	}
	public int getLoss() {
		return loss;
	}
	public void setLoss(int loss) {
		this.loss = loss;
	}
	public int getGoalsFor() {
		return goalsFor;
	}
	public void setGoalsFor(int goalsFor) {
		this.goalsFor = goalsFor;
	}
	public int getGoalsAgainst() {
		return goalsAgainst;
	}
	public void setGoalsAgainst(int goalsAgainst) {
		this.goalsAgainst = goalsAgainst;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "LeagueTableBean [rank=" + rank + ", team=" + team + ", played=" + played + ", win=" + win + ", draw="
				+ draw + ", loss=" + loss + ", goalsFor=" + goalsFor + ", goalsAgainst=" + goalsAgainst + ", points="
				+ points + "]";
	}


	
	
	
}
