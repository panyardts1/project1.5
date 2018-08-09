package app;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class consoleApp {

	public static void main(String[] args) {
		
		String email = "managerB@work.com";
		
		Employee e = EmployeeService.getEService().getEmployeeByEmail(email);
		
		System.out.println(e.toString());
	}
	
}
