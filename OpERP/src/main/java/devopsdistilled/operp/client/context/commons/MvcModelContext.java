package devopsdistilled.operp.client.context.commons;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import devopsdistilled.operp.client.commons.panes.models.AddressPaneModel;
import devopsdistilled.operp.client.commons.panes.models.CreateContactInfoPaneModel;
import devopsdistilled.operp.client.commons.panes.models.impl.AddressPaneModelImpl;
import devopsdistilled.operp.client.commons.panes.models.impl.CreateContactInfoPaneModelImpl;

@Configuration
public class MvcModelContext {

	@Bean
	@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
	public AddressPaneModel addressPaneModel() {
		return new AddressPaneModelImpl();
	}

	@Bean
	@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
	public CreateContactInfoPaneModel createContactInfoPaneModel() {
		return new CreateContactInfoPaneModelImpl();
	}

}
