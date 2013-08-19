package devopsdistilled.operp.client.context.party;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.party.panes.ListCustomerPane;
import devopsdistilled.operp.client.party.panes.ListVendorPane;
import devopsdistilled.operp.client.party.panes.VendorPane;

@Configuration
public class MvcViewContext {

	@Bean
	public VendorPane vendorPane() {
		return new VendorPane();
	}

	@Bean
	public ListVendorPane listVendorPane() {
		return new ListVendorPane();
	}

	@Bean
	public ListCustomerPane listCustomerPane() {
		return new ListCustomerPane();
	}
}
