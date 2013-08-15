package devopsdistilled.operp.client.context.party;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.party.models.VendorModel;
import devopsdistilled.operp.client.party.models.impl.VendorModelImpl;

@Configuration
public class EntityModelContext {

	@Bean
	public VendorModel vendorModel() {
		return new VendorModelImpl();
	}
}
