package devopsdistilled.operp.client.context;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import devopsdistilled.operp.client.context.items.ItemRmiContext;
import devopsdistilled.operp.client.context.party.PartyRmiContext;
import devopsdistilled.operp.client.context.stock.StockRmiContext;

@Configuration
@PropertySource("client/rmi.properties")
@Import({ ItemRmiContext.class, StockRmiContext.class, PartyRmiContext.class })
public class RmiContext {

	@Value("${rmi.url}")
	protected String rmiUrl;

	@Bean
	public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}
