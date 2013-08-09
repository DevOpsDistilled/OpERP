package devopsdistilled.operp.client.context;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import devopsdistilled.operp.client.context.items.ItemContext;
import devopsdistilled.operp.client.context.stock.StockContext;

@Configuration
@Import({ ItemContext.class, StockContext.class })
public class AppContext {

}
