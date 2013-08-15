package devopsdistilled.operp.client.context.party;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.party.panes.CreateVendorPane;

@Configuration
public class MvcViewContext {

	@Bean
	public CreateVendorPane createVendorPane() {
		return new CreateVendorPane();
	}
}
