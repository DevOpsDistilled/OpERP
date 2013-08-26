package devopsdistilled.operp.client.context.account;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.account.panes.controllers.PaidTransactionPaneController;
import devopsdistilled.operp.client.account.panes.controllers.ReceivedTransactionPaneController;
import devopsdistilled.operp.client.account.panes.controllers.impl.PaidTransactionPaneControllerImpl;
import devopsdistilled.operp.client.account.panes.controllers.impl.ReceivedTransactionPaneControllerImpl;

@Configuration
public class MvcControllerContext {

	@Bean
	public ReceivedTransactionPaneController receivedTransactionPaneController() {
		return new ReceivedTransactionPaneControllerImpl();
	}

	@Bean
	public PaidTransactionPaneController paidTransactionPaneController() {
		return new PaidTransactionPaneControllerImpl();
	}
}