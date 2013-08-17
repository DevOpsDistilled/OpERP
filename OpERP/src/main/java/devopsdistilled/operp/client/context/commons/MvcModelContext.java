package devopsdistilled.operp.client.context.commons;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import devopsdistilled.operp.client.commons.panes.models.CreateAddressPaneModel;
import devopsdistilled.operp.client.commons.panes.models.CreateContactInfoPaneModel;
import devopsdistilled.operp.client.commons.panes.models.impl.CreateAddressPaneModelImpl;
import devopsdistilled.operp.client.commons.panes.models.impl.CreateContactInfoPaneModelImpl;

@Configuration
public class MvcModelContext {

	@Bean
	@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
	public CreateAddressPaneModel createAddressPaneModel() {
		return new CreateAddressPaneModelImpl();
	}

	@Bean
	@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
	public CreateContactInfoPaneModel createContactInfoPaneModel() {
		return new CreateContactInfoPaneModelImpl();
	}

}
