package devopsdistilled.operp.client.context.party;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.party.panes.models.CreateVendorPaneModel;
import devopsdistilled.operp.client.party.panes.models.impl.CreateVendorPaneModelImpl;

@Configuration
public class MvcModelContext {

	@Bean
	public CreateVendorPaneModel createVendorPaneModel() {
		return new CreateVendorPaneModelImpl();
	}
}
