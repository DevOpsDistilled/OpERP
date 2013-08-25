package devopsdistilled.operp.client.context.employee;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.employee.models.EmployeeModel;
import devopsdistilled.operp.client.employee.models.impl.EmployeeModelImpl;

@Configuration
public class EntityModelContext {

	@Bean
	public EmployeeModel employeeModel() {
		return new EmployeeModelImpl();
	}

}
