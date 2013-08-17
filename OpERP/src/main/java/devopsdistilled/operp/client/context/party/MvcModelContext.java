package devopsdistilled.operp.client.context.party;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.party.panes.models.VendorPaneModel;
import devopsdistilled.operp.client.party.panes.models.impl.VendorPaneModelImpl;

@Configuration
public class MvcModelContext {

	@Bean
	public VendorPaneModel vendorPaneModel() {
		return new VendorPaneModelImpl();
	}
}
