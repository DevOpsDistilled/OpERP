package devopsdistilled.operp.client.context.account;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.account.models.PayableAccountModel;
import devopsdistilled.operp.client.account.models.ReceivableAccountModel;
import devopsdistilled.operp.client.account.models.impl.PayableAccountModelImpl;
import devopsdistilled.operp.client.account.models.impl.ReceivableAccountModelImpl;

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
}
