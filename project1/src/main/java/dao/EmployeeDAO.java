package dao;

import java.util.List;

import app.Employee;

public interface EmployeeDAO {

	public Employee getEmployeeByEmail(String email);
	public Employee getEmployeeById (int userid);
	public boolean addEmployee(Employee e);
	public boolean updateName(int userid, String newFirst, String newLast);
	public boolean updateEmail(int userid, String newEmail);
	public boolean updatePassword(int userid, String newPass);
	public List<Employee> listEmployees();
	
}
