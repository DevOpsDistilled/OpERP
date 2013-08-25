package devopsdistilled.operp.client.context.employee;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.employee.panes.models.EmployeePaneModel;
import devopsdistilled.operp.client.employee.panes.models.impl.EmployeePaneModelImpl;

@Configuration
public class MvcModelContext {

	@Bean
	public EmployeePaneModel employeePaneModel() {
		return new EmployeePaneModelImpl();
	}
}
