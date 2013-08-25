package devopsdistilled.operp.client.context.employee;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.employee.panes.models.EmployeePaneModel;
import devopsdistilled.operp.client.employee.panes.models.ListEmployeePaneModel;
import devopsdistilled.operp.client.employee.panes.models.impl.EmployeePaneModelImpl;
import devopsdistilled.operp.client.employee.panes.models.impl.ListEmployeePaneModelImpl;

@Configuration
public class MvcModelContext {

	@Bean
	public EmployeePaneModel employeePaneModel() {
		return new EmployeePaneModelImpl();
	}

	@Bean
	public ListEmployeePaneModel listEmployeePaneModel() {
		return new ListEmployeePaneModelImpl();
	}
}
