package devopsdistilled.operp.client.context.employee;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.employee.panes.controllers.EmployeePaneController;
import devopsdistilled.operp.client.employee.panes.controllers.ListEmployeePaneController;
import devopsdistilled.operp.client.employee.panes.controllers.impl.EmployeePaneControllerImpl;
import devopsdistilled.operp.client.employee.panes.controllers.impl.ListEmployeePaneControllerImpl;

@Configuration
public class MvcControllerContext {

	@Bean
	public EmployeePaneController employeePaneController() {
		return new EmployeePaneControllerImpl();
	}

	@Bean
	public ListEmployeePaneController listEmployeePaneController() {
		return new ListEmployeePaneControllerImpl();
	}
}