package devopsdistilled.operp.client.context.account;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.account.panes.PaidTransactionPane;
import devopsdistilled.operp.client.account.panes.ReceivedTransactionPane;

@Configuration
public class MvcViewContext {

	@Bean
	public ReceivedTransactionPane receivedTransactionPane() {
		return new ReceivedTransactionPane();
	}

	@Bean
	public PaidTransactionPane paidTransactionPane() {
		return new PaidTransactionPane();
	}
}
