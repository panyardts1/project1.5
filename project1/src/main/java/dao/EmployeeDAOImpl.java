package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import app.Employee;
import app.dbConnection;

public class EmployeeDAOImpl implements EmployeeDAO {

	Logger employeeDaoLog = Logger.getLogger(EmployeeDAOImpl.class);

	private static EmployeeDAOImpl employeedao;

	private EmployeeDAOImpl() {

	}

	public static EmployeeDAOImpl getEmployeeDAO() {
		if (employeedao == null) {
			employeedao = new EmployeeDAOImpl();
		}

		return employeedao;
	}

	@Override
	public Employee getEmployeeByEmail(String email) {

		try {
			Connection conn = dbConnection.getConnection();
			String sql = "select * from employees where email = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);

			ResultSet rs = ps.executeQuery();

			Employee employ = null;
			while (rs.next()) {
				employ = new Employee(rs.getInt("u_ID"), rs.getString("fname"), rs.getString("lname"),
						rs.getString("email"), rs.getString("password"), rs.getBoolean("isManager"));
			}

			return employ;
		} catch (SQLException e) {
			employeeDaoLog.error(e.getStackTrace());
		}

		return null;
	}

	@Override
	public Employee getEmployeeById(int userid) {
		try {
			Connection conn = dbConnection.getConnection();
			String sql = "select * from employees where u_ID = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userid);

			ResultSet rs = ps.executeQuery();

			Employee employ = null;
			while (rs.next()) {
				employ = new Employee(rs.getInt("u_ID"), rs.getString("fname"), rs.getString("lname"),
						rs.getString("email"), rs.getString("password"), rs.getBoolean("isManager"));
			}

			return employ;
		} catch (SQLException e) {
			employeeDaoLog.error(e.getStackTrace());
		}

		return null;
	}

	@Override
	public boolean addEmployee(Employee e) {

		try {
			Connection conn = dbConnection.getConnection();
			String sql = "CALL add_employee(?, ?, ?, ?, ?)";

			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, e.getFirstname());
			cs.setString(2, e.getLastname());
			cs.setString(3, e.getEmail());
			cs.setString(4, e.getPassword());
			cs.setBoolean(5, e.isManager());

			return cs.executeUpdate() <= 0;

		} catch (SQLException e1) {
			employeeDaoLog.error(e1.getStackTrace());
		}

		return false;
	}

	@Override
	public boolean updateName(int userid, String newFirst, String newLast) {

		try {
			Connection conn = dbConnection.getConnection();
			String sql = "update employees set fname = ?, lname = ? where u_ID = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newFirst);
			ps.setString(2, newLast);
			ps.setInt(3, userid);

			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			employeeDaoLog.error(e.getStackTrace());
		}

		return false;
	}

	@Override
	public boolean updateEmail(int userid, String newEmail) {
		try {
			Connection conn = dbConnection.getConnection();
			String sql = "update employees set email = ? where u_ID = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newEmail);
			ps.setInt(2, userid);

			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			employeeDaoLog.error(e.getStackTrace());
		}

		return false;
	}

	@Override
	public boolean updatePassword(int userid, String newPass) {
		try {
			Connection conn = dbConnection.getConnection();
			String sql = "update employees set password = ? where u_ID = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newPass);
			ps.setInt(2, userid);

			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			employeeDaoLog.error(e.getStackTrace());
		}

		return false;
	}

	@Override
	public List<Employee> listEmployees() {
		
		try {
			Connection conn = dbConnection.getConnection();
			String sql = "select * from employees";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();

			List<Employee> employees = new ArrayList<Employee>();
			while (rs.next()) {
				Employee employ = new Employee(rs.getInt("u_ID"), rs.getString("fname"), rs.getString("lname"), rs.getString("email"), rs.getString("password"), rs.getBoolean("isManager"));
				employees.add(employ);
			}
			
			return employees;
		}catch(SQLException e) {
			employeeDaoLog.error(e.getStackTrace());
		}
		
		return null;
	}

}
