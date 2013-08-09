package devopsdistilled.operp.client.context.stock;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import devopsdistilled.operp.client.context.MainWindowContext;

@Configuration
@Import({ MainWindowContext.class, EntityModelContext.class,
		EntityControllerContext.class, MvcContext.class,
		EntityDetailsContext.class })
public class StockContext {

}
