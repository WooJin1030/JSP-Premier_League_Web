package dto;

public class MemberBean implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String password;
	private String name;
	private String email;
	private int teamname;
	
	public MemberBean () {
		this(null, null, null, null, 0);
	}
	
	public MemberBean(String id, String password, String name, String email, int teamname) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.teamname = teamname;
		
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTeamname() {
		return teamname;
	}

	public void setTeamname(int teamname) {
		this.teamname = teamname;
	}

	@Override
	public String toString() {
		return "MemberBean [id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + ", teamname="
				+ teamname + "]";
	}

	
	
	
	
}
