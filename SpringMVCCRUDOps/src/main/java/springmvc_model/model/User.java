package springmvc_model.model;

public class User {
	private int id; //ID
	private String uname; //USERNAME
	private String pword; //PASSWORD
	
	// These are the fields of the inputs that are gathered from the form and database columns
	// Model generally represents the data that 
	// will be passed to and from an operation 
	//	(defined in a web controller) and the view.
	public User() {
		super();
	}
	public User(Integer id){
		super();
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPword() {
		return pword;
	}
	public void setPword(String pword) {
		this.pword = pword;
	}
	
}
