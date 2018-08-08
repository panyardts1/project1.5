package app;

public class Employee {
	
	private int u_ID;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private boolean isManager;
	
	public Employee(int u_ID, String firstname, String lastname, String email, String password, boolean isManager) {
		super();
		this.u_ID = u_ID;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.isManager = isManager;
	}

	public int getU_ID() {
		return u_ID;
	}

	public void setU_ID(int u_ID) {
		this.u_ID = u_ID;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isManager() {
		return isManager;
	}

	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}

	@Override
	public String toString() {
		return u_ID + "	" + firstname + "	" + lastname + "	" + email
				+ "	" + password;
	}
	
	
}
