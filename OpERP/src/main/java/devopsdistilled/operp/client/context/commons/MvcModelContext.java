package devopsdistilled.operp.client.context.commons;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.commons.panes.models.CreateAddressPaneModel;
import devopsdistilled.operp.client.commons.panes.models.CreateContactInfoPaneModel;
import devopsdistilled.operp.client.commons.panes.models.impl.CreateAddressPaneModelImpl;
import devopsdistilled.operp.client.commons.panes.models.impl.CreateContactInfoPaneModelImpl;

@Configuration
public class MvcModelContext {

	@Bean
	public CreateAddressPaneModel createAddressPaneModel() {
		return new CreateAddressPaneModelImpl();
	}

	@Bean
	public CreateContactInfoPaneModel createContactInfoPaneModel() {
		return new CreateContactInfoPaneModelImpl();
	}

}
