package devopsdistilled.operp.client.context.employee;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.employee.panes.controllers.EmployeePaneController;
import devopsdistilled.operp.client.employee.panes.controllers.impl.EmployeePaneControllerImpl;

@Configuration
public class MvcControllerContext {

	@Bean
	public EmployeePaneController employeePaneController() {
		return new EmployeePaneControllerImpl();
	}
}