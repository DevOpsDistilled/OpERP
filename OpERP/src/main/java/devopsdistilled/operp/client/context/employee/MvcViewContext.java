package devopsdistilled.operp.client.context.employee;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.employee.panes.EmployeePane;
import devopsdistilled.operp.client.employee.panes.ListEmployeePane;

@Configuration
public class MvcViewContext {

	@Bean
	public EmployeePane employeePane() {
		return new EmployeePane();
	}

	@Bean
	public ListEmployeePane listEmployeePane() {
		return new ListEmployeePane();
	}
}
