package dto;

public class LeagueMatchBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String formatted_date;
	private String visitorteam_name;
	private String localteam_name;
	private String ft_score;
	
	public LeagueMatchBean() {
		this(null, null, null, null);
	}

	public LeagueMatchBean(String formatted_date, String visitorteam_name, String localteam_name, String ft_score) {
		super();
		this.formatted_date = formatted_date;
		this.visitorteam_name = visitorteam_name;
		this.localteam_name = localteam_name;
		this.ft_score = ft_score;
	}

	public String getFormatted_date() {
		return formatted_date;
	}

	public void setFormatted_date(String formatted_date) {
		this.formatted_date = formatted_date;
	}

	public String getVisitorteam_name() {
		return visitorteam_name;
	}

	public void setVisitorteam_name(String visitorteam_name) {
		this.visitorteam_name = visitorteam_name;
	}

	public String getLocalteam_name() {
		return localteam_name;
	}

	public void setLocalteam_name(String localteam_name) {
		this.localteam_name = localteam_name;
	}

	public String getFt_score() {
		return ft_score;
	}

	public void setFt_score(String ft_score) {
		this.ft_score = ft_score;
	}

	@Override
	public String toString() {
		return "LeagueMatchBean [formatted_date=" + formatted_date + ", visitorteam_name=" + visitorteam_name
				+ ", localteam_name=" + localteam_name + ", ft_score=" + ft_score + "]";
	}
}
