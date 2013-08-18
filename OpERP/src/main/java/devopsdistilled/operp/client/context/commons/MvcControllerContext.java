package devopsdistilled.operp.client.context.commons;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import devopsdistilled.operp.client.commons.panes.controllers.AddressPaneController;
import devopsdistilled.operp.client.commons.panes.controllers.ContactInfoPaneController;
import devopsdistilled.operp.client.commons.panes.controllers.impl.AddressPaneControllerImpl;
import devopsdistilled.operp.client.commons.panes.controllers.impl.ContactInfoPaneControllerImpl;

@Configuration
public class MvcControllerContext {

	@Bean
	@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
	public AddressPaneController addressPaneController() {
		return new AddressPaneControllerImpl();
	}

	@Bean
	@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
	public ContactInfoPaneController contactInfoPaneController() {
		return new ContactInfoPaneControllerImpl();
	}

}