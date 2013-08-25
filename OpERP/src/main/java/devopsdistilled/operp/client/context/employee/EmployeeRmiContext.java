package devopsdistilled.operp.client.context.employee;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import devopsdistilled.operp.client.context.RmiContext;
import devopsdistilled.operp.server.data.service.employee.EmployeeService;

@Configuration
public class EmployeeRmiContext extends RmiContext {

	@Bean
	public RmiProxyFactoryBean employeeService() {
		RmiProxyFactoryBean rmiProxy = new RmiProxyFactoryBean();
		rmiProxy.setServiceInterface(EmployeeService.class);
		String serviceName = rmiProxy.getServiceInterface().getCanonicalName();
		rmiProxy.setServiceUrl(rmiUrl + "/" + serviceName);
		return rmiProxy;
	}

}