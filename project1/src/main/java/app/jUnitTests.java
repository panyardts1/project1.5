package app;

import static org.junit.Assert.*;

import java.awt.List;
import java.util.Date;

import org.junit.Test;

public class jUnitTests {

	@Test
	public void testGetEmployeeService() {
		EmployeeService es = EmployeeService.getEService();
		
		assert(es != null);
	}
	
	@Test
	public void testGetReimbursmentService() {
		ReimbursmentService rs = ReimbursmentService.getRService();
		
		assert(rs != null);
	}
	
	@Test
	public void testGetEmployeeByEmail() {
		Employee e = EmployeeService.getEService().getEmployeeByEmail("managerB@work.com");
		
		assertEquals(e.getFirstname(), "Bob");
		assertEquals(e.getLastname(), "Manager");
		assertEquals(e.getU_ID(), 1);
	}
	
	@Test
	public void testGetEmployeeByID() {
		Employee e = EmployeeService.getEService().getEmployeeById(1);
		
		assertEquals(e.getFirstname(), "Bob");
		assertEquals(e.getLastname(), "Manager");
		assertEquals(e.getEmail(), "managerB@work.com");
	}
	
	@Test
	public void testAddEmployee() {
		Employee e = new Employee(0, "Pete", "Peterson", "petersonP@work2.com", "peteWord", false);
		EmployeeService.getEService().addEmployee(e);
		
		Employee e2 = EmployeeService.getEService().getEmployeeByEmail("petersonP@work2.com");
		
		assert(e2 != null);
	}
	
	@Test
	public void testUpdateName() {
		EmployeeService.getEService().updateName(2, "Sam", "Somebody");
		
		Employee e = EmployeeService.getEService().getEmployeeById(2);
		
		assertEquals(e.getFirstname(), "Sam");
		assertEquals(e.getLastname(), "Somebody");
	}
	
	@Test
	public void testUpdateEmail() {
		EmployeeService.getEService().updateEmail(2, "somebodyS@work.com");
		
		Employee e = EmployeeService.getEService().getEmployeeById(2);
		
		assertEquals(e.getEmail(), "somebodyS@work.com");
	}
	
	@Test
	public void testUpdatePassword() {
		EmployeeService.getEService().updatePassword(2, "wordpass");
		
		Employee e = EmployeeService.getEService().getEmployeeById(2);
		
		assertEquals(e.getPassword(), "wordpass");
	}
	
	@Test
	public void testListEmployees() {
		java.util.List<Employee> eList = EmployeeService.getEService().listEmployees();
		
		assert(eList.size() >= 2);
	}
	
	@Test
	public void testGetReimbursment() {
		Reimbursment r = ReimbursmentService.getRService().getReimbursment(2);
		
		assertEquals(r.getDescription(), "Enthuware");
		assertEquals(r.getStatus(), "approved");
		assertEquals(r.getM_ID(), 1);
	}
	
	@Test
	public void testSubmitReimbursment() {
		Reimbursment r = new Reimbursment(0, (float) 0.50, "jUnit", 1, new Date(), "pending", 0);
		
		assertTrue(ReimbursmentService.getRService().submitReimbursment(r));
	}
	
	@Test
	public void testViewPending() {
		java.util.List<Reimbursment> rList = ReimbursmentService.getRService().viewAllPending();
		
		assertTrue(rList.size() >= 0);
	}
	
	@Test
	public void testViewResolved() {
		java.util.List<Reimbursment> rList = ReimbursmentService.getRService().viewAllResolved();
		
		assertTrue(rList.size() >= 1);	
	}
	
	@Test
	public void testViewEmployeeResolved() {
		java.util.List<Reimbursment> rList = ReimbursmentService.getRService().viewEmployeeReimbursment(2);
		
		assertTrue(rList.size() >= 1);	
	}

}
