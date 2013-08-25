package devopsdistilled.operp.client.context.employee;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.employee.panes.EmployeePane;

@Configuration
public class MvcViewContext {

	@Bean
	public EmployeePane employeePane() {
		return new EmployeePane();
	}

}
