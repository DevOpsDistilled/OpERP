package devopsdistilled.operp.client.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import devopsdistilled.operp.client.context.account.AccountRmiContext;
import devopsdistilled.operp.client.context.business.BusinessRmiContext;
import devopsdistilled.operp.client.context.employee.EmployeeRmiContext;
import devopsdistilled.operp.client.context.items.ItemRmiContext;
import devopsdistilled.operp.client.context.party.PartyRmiContext;
import devopsdistilled.operp.client.context.stock.StockRmiContext;

@Configuration
@PropertySource("client/rmi.properties")
@Import({ ItemRmiContext.class, StockRmiContext.class, PartyRmiContext.class,
		BusinessRmiContext.class, AccountRmiContext.class,
		EmployeeRmiContext.class })
public abstract class RmiContext {

	// @Value("${rmi.port}")
	protected String rmiPort = "1099";

	protected String rmiUrl;

	public RmiContext() {
		String rmiHost = System.getProperty("server.rmi.host.address");
		rmiUrl = new String("rmi://" + rmiHost + ":" + rmiPort);
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}
