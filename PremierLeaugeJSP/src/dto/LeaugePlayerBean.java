package dto;

public class LeaugePlayerBean implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String imgUrl;
	private int id;
	private String number;
	private String name;
	private String position;
	private String age;
	private int goals;
	private int assists;
	
	public LeaugePlayerBean() {
		this(null, 0, null, null, null, null, 0, 0);
	}

	public LeaugePlayerBean(String imgUrl, int id, String number, String name, String position, String age, int goals, int assists) {
		super();
		this.imgUrl = imgUrl;
		this.id = id;
		this.number = number;
		this.name = name;
		this.position = position;
		this.age = age;
		this.goals = goals;
		this.assists = assists;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public int getGoals() {
		return goals;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}

	public int getAssists() {
		return assists;
	}

	public void setAssists(int assists) {
		this.assists = assists;
	}

	@Override
	public String toString() {
		return "LeaugePlayerBean [imgUrl=" + imgUrl + ", id=" + id + ", number=" + number + ", name=" + name
				+ ", position=" + position + ", age=" + age + ", goals=" + goals + ", assists=" + assists + "]";
	}



}
