package dto;

public class LeagueTeamInfoBean implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String origin;
	private int establishment;
	private String nickname;
	private String logoUrl;
	private String managername;
	private String managerimageurl;
	private String chairmanname;
	private String officialsite;
	private String stadiumname;
	private String stadiumimageurl;
	private int capacity;
	private String fieldsize;
	private String teamcolor;
	private int managercount;
	
	
	
	public LeagueTeamInfoBean() {
		this(0, null, null, 0, null, null, null, null, null, null, null, null, 0, null, null, 0);
	}

	public LeagueTeamInfoBean(int id, String name, String origin, int establishment, String nickname, String logoUrl,
			String managername, String managerimageurl, String chairmanname, String officialsite, String stadiumname,
			String stadiumimageurl, int capacity, String fieldsize, String teamcolor, int managercount) {
		super();
		this.id = id;
		this.name = name;
		this.origin = origin;
		this.establishment = establishment;
		this.nickname = nickname;
		this.logoUrl = logoUrl;
		this.managername = managername;
		this.managerimageurl = managerimageurl;
		this.chairmanname = chairmanname;
		this.officialsite = officialsite;
		this.stadiumname = stadiumname;
		this.stadiumimageurl = stadiumimageurl;
		this.capacity = capacity;
		this.fieldsize = fieldsize;
		this.teamcolor = teamcolor;
		this.managercount = managercount;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public int getEstablishment() {
		return establishment;
	}
	public void setEstablishment(int establishment) {
		this.establishment = establishment;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getLogoUrl() {
		return logoUrl;
	}
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}
	public String getManagername() {
		return managername;
	}
	public void setManagername(String managername) {
		this.managername = managername;
	}
	public String getManagerimageurl() {
		return managerimageurl;
	}
	public void setManagerimageurl(String managerimageurl) {
		this.managerimageurl = managerimageurl;
	}
	public String getChairmanname() {
		return chairmanname;
	}
	public void setChairmanname(String chairmanname) {
		this.chairmanname = chairmanname;
	}
	public String getOfficialsite() {
		return officialsite;
	}
	public void setOfficialsite(String officialsite) {
		this.officialsite = officialsite;
	}
	public String getStadiumname() {
		return stadiumname;
	}
	public void setStadiumname(String stadiumname) {
		this.stadiumname = stadiumname;
	}
	public String getStadiumimageurl() {
		return stadiumimageurl;
	}
	public void setStadiumimageurl(String stadiumimageurl) {
		this.stadiumimageurl = stadiumimageurl;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getFieldsize() {
		return fieldsize;
	}
	public void setFieldsize(String fieldsize) {
		this.fieldsize = fieldsize;
	}
	public String getTeamcolor() {
		return teamcolor;
	}
	public void setTeamcolor(String teamcolor) {
		this.teamcolor = teamcolor;
	}
	
	public int getManagercount() {
		return managercount;
	}
	public void setManagercount(int managercount) {
		this.managercount = managercount;
	}
	
	@Override
	public String toString() {
		return "LeagueTeamInfoBean [id=" + id + ", name=" + name + ", origin=" + origin + ", establishment="
				+ establishment + ", nickname=" + nickname + ", logoUrl=" + logoUrl + ", managername=" + managername
				+ ", managerimageurl=" + managerimageurl + ", chairmanname=" + chairmanname + ", officialsite="
				+ officialsite + ", stadiumname=" + stadiumname + ", stadiumimageurl=" + stadiumimageurl + ", capacity="
				+ capacity + ", fieldsize=" + fieldsize + "teamcolor=" + teamcolor + "managercount=" + managercount + "]";
	}
	
	
}
