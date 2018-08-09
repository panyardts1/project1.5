package app;

import java.util.List;

import dao.EmployeeDAOImpl;

public class EmployeeService {

	private static EmployeeService es;
	
	private EmployeeService() {
		
	}
	
	public static EmployeeService getEService() {
		if(es == null) {
			es = new EmployeeService();
		}
		
		return es;
	}
	
	public Employee getEmployeeByEmail(String email) {
		return EmployeeDAOImpl.getEmployeeDAO().getEmployeeByEmail(email);
	}
	
	public Employee getEmployeeById(int userID) {
		return EmployeeDAOImpl.getEmployeeDAO().getEmployeeById(userID);
	}
	
	public boolean addEmployee(Employee e) {
		return EmployeeDAOImpl.getEmployeeDAO().addEmployee(e);
	}
	
	public boolean updateName(int userID, String fname, String lname) {
		return EmployeeDAOImpl.getEmployeeDAO().updateName(userID, fname, lname);
	}
	
	public boolean updateEmail(int userID, String email) {
		return EmployeeDAOImpl.getEmployeeDAO().updateEmail(userID, email);
	}
	
	public boolean updatePassword(int userID, String password) {
		return EmployeeDAOImpl.getEmployeeDAO().updatePassword(userID, password);
	}
	
	public List<Employee> listEmployees(){
		return EmployeeDAOImpl.getEmployeeDAO().listEmployees();
	}
}
