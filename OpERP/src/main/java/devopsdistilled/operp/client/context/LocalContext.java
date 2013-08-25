package devopsdistilled.operp.client.context;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import devopsdistilled.operp.client.context.account.AccountContext;
import devopsdistilled.operp.client.context.business.BusinessContext;
import devopsdistilled.operp.client.context.commons.CommonsContext;
import devopsdistilled.operp.client.context.employee.EmployeeContext;
import devopsdistilled.operp.client.context.items.ItemContext;
import devopsdistilled.operp.client.context.party.PartyContext;
import devopsdistilled.operp.client.context.stock.StockContext;

@Configuration
@Import({ UIContext.class, ItemContext.class, StockContext.class,
		CommonsContext.class, PartyContext.class, BusinessContext.class,
		AccountContext.class, EmployeeContext.class })
public class LocalContext {

}
