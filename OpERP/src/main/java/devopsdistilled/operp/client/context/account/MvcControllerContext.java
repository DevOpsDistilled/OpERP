package devopsdistilled.operp.client.context.account;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.account.panes.controllers.ReceivedTransactionPaneController;
import devopsdistilled.operp.client.account.panes.controllers.impl.ReceivedTransactionPaneControllerImpl;

@Configuration
public class MvcControllerContext {

	@Bean
	public ReceivedTransactionPaneController receivedTransactionPaneController() {
		return new ReceivedTransactionPaneControllerImpl();
	}

}