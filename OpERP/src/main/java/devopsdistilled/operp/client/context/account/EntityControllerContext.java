package devopsdistilled.operp.client.context.account;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.account.controllers.PaidTransactionController;
import devopsdistilled.operp.client.account.controllers.ReceivedTransactionController;
import devopsdistilled.operp.client.account.controllers.impl.PaidTransactionControllerImpl;
import devopsdistilled.operp.client.account.controllers.impl.ReceivedTransactionControllerImpl;

@Configuration
public class EntityControllerContext {

	@Bean
	public ReceivedTransactionController receivedTransactionController() {
		return new ReceivedTransactionControllerImpl();
	}
	
	@Bean
	public PaidTransactionController paidTransactionController() {
		return new PaidTransactionControllerImpl();
	}
}
