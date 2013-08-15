package devopsdistilled.operp.client.context.commons;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.commons.panes.controllers.CreateAddressPaneController;
import devopsdistilled.operp.client.commons.panes.controllers.CreateContactInfoPaneController;
import devopsdistilled.operp.client.commons.panes.controllers.impl.CreateAddressPaneControllerImpl;
import devopsdistilled.operp.client.commons.panes.controllers.impl.CreateContactInfoPaneControllerImpl;

@Configuration
public class MvcControllerContext {

	@Bean
	public CreateAddressPaneController createAddressPaneController() {
		return new CreateAddressPaneControllerImpl();
	}

	@Bean
	public CreateContactInfoPaneController createContactInfoPaneController() {
		return new CreateContactInfoPaneControllerImpl();
	}

}