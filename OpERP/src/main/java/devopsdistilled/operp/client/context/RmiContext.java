package devopsdistilled.operp.client.context;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import devopsdistilled.operp.client.context.items.ItemRmiContext;
import devopsdistilled.operp.client.context.stock.StockRmiContext;

@Configuration
@Import({ ItemRmiContext.class, StockRmiContext.class })
public class RmiContext {

}
