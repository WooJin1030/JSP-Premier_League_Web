package dto;


import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class CommentBean implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int teamid;
	private String sessionid;
	private String text;
	private LocalDate date;
	private LocalTime time;
	
	
	
	public CommentBean() {
		super();
	}

	public CommentBean(int id, int teamid, String sessionid, String text, LocalDate date2, LocalTime time2) {
		super();
		this.id = id;
		this.teamid = teamid;
		this.sessionid = sessionid;
		this.text = text;
		this.date = date2;
		this.time = time2;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTeamid() {
		return teamid;
	}
	public void setTeamid(int teamid) {
		this.teamid = teamid;
	}
	public String getSessionid() {
		return sessionid;
	}
	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "CommentBean [id=" + id + ", teamid=" + teamid + ", sessionid=" + sessionid + ", text=" + text
				+ ", date=" + date + ", time=" + time + "]";
	}
	
	
	
}
