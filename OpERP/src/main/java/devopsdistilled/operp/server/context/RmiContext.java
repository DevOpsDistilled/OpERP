package devopsdistilled.operp.server.context;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import devopsdistilled.operp.server.context.items.ItemRmiContext;
import devopsdistilled.operp.server.context.stock.StockRmiContext;

@Configuration
@Import({ ItemRmiContext.class, StockRmiContext.class })
public class RmiContext {

}
