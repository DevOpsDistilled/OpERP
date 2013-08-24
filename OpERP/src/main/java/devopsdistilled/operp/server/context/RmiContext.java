package devopsdistilled.operp.server.context;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import devopsdistilled.operp.server.context.account.AccountRmiContext;
import devopsdistilled.operp.server.context.business.BusinessRmiContext;
import devopsdistilled.operp.server.context.commons.CommonRmiContext;
import devopsdistilled.operp.server.context.items.ItemRmiContext;
import devopsdistilled.operp.server.context.party.PartyRmiContext;
import devopsdistilled.operp.server.context.stock.StockRmiContext;

@Configuration
@Import({ CommonRmiContext.class, ItemRmiContext.class, StockRmiContext.class,
		PartyRmiContext.class, BusinessRmiContext.class,
		AccountRmiContext.class })
public class RmiContext {

}
