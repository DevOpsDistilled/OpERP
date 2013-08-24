package devopsdistilled.operp.client.context.account;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.account.models.PayableAccountModel;
import devopsdistilled.operp.client.account.models.ReceivableAccountModel;
import devopsdistilled.operp.client.account.models.ReceivedTransactionModel;
import devopsdistilled.operp.client.account.models.impl.PayableAccountModelImpl;
import devopsdistilled.operp.client.account.models.impl.ReceivableAccountModelImpl;
import devopsdistilled.operp.client.account.models.impl.ReceivedTransactionModelImpl;

@Configuration
public class EntityModelContext {

	@Bean
	public PayableAccountModel payableAccountModel() {
		return new PayableAccountModelImpl();
	}

	@Bean
	public ReceivableAccountModel receivableAccountModel() {
		return new ReceivableAccountModelImpl();
	}

	@Bean
	public ReceivedTransactionModel receivedTransactionModel() {
		return new ReceivedTransactionModelImpl();
	}
}
