package devopsdistilled.operp.client.context.commons;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.commons.panes.CreateAddressPane;
import devopsdistilled.operp.client.commons.panes.CreateContactInfoPane;

@Configuration
public class MvcViewContext {

	@Bean
	public CreateAddressPane createAddressPane() {
		return new CreateAddressPane();
	}

	@Bean
	public CreateContactInfoPane createContactInfoPane() {
		return new CreateContactInfoPane();
	}

}
