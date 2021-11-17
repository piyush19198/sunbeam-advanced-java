package pojos;

public class Topic {

	private int id;
	private String name;
	
	public Topic(String name) {
		super();
		this.name = name;
	}
	
	public Topic() {
		super();
	}

	public Topic(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return "Topic [name=" + name + "]";
	}
	
}
