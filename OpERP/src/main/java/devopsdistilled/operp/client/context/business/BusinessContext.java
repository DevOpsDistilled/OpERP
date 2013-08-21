package devopsdistilled.operp.client.context.business;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ EntityModelContext.class, EntityControllerContext.class,
		MvcContext.class, EntityDetailsContext.class })
public class BusinessContext {

}
