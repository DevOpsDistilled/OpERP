package devopsdistilled.operp.client.context.commons;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import devopsdistilled.operp.client.commons.panes.controllers.CreateAddressPaneController;
import devopsdistilled.operp.client.commons.panes.controllers.CreateContactInfoPaneController;
import devopsdistilled.operp.client.commons.panes.controllers.impl.CreateAddressPaneControllerImpl;
import devopsdistilled.operp.client.commons.panes.controllers.impl.CreateContactInfoPaneControllerImpl;

@Configuration
public class MvcControllerContext {

	@Bean
	@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
	public CreateAddressPaneController createAddressPaneController() {
		return new CreateAddressPaneControllerImpl();
	}

	@Bean
	@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
	public CreateContactInfoPaneController createContactInfoPaneController() {
		return new CreateContactInfoPaneControllerImpl();
	}

}