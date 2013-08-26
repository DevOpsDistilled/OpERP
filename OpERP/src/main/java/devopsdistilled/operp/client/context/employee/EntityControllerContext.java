package devopsdistilled.operp.client.context.employee;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.employee.controllers.EmployeeController;
import devopsdistilled.operp.client.employee.controllers.impl.EmployeeControllerImpl;

@Configuration
public class EntityControllerContext {

	@Bean
	public EmployeeController employeeController() {
		return new EmployeeControllerImpl();
	}

}
