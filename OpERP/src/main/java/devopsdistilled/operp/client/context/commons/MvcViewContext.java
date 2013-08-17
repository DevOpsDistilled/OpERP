package devopsdistilled.operp.client.context.commons;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import devopsdistilled.operp.client.commons.panes.AddressPane;
import devopsdistilled.operp.client.commons.panes.CreateContactInfoPane;

@Configuration
public class MvcViewContext {

	@Bean
	@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
	public AddressPane addressPane() {
		return new AddressPane();
	}

	@Bean
	@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
	public CreateContactInfoPane createContactInfoPane() {
		return new CreateContactInfoPane();
	}

}
