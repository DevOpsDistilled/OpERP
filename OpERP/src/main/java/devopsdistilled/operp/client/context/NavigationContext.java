package devopsdistilled.operp.client.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.account.AccountMgmtPane;
import devopsdistilled.operp.client.business.sales.SalesMgmtPane;
import devopsdistilled.operp.client.items.ItemMgmtPane;
import devopsdistilled.operp.client.main.NavigationPane;
import devopsdistilled.operp.client.main.NavigationTree;
import devopsdistilled.operp.client.party.PartyMgmtPane;
import devopsdistilled.operp.client.stock.StockMgmtPane;

@Configuration
public class NavigationContext {

	@Bean
	public PartyMgmtPane partyMgmtPane() {
		return new PartyMgmtPane();
	}

	@Bean
	public ItemMgmtPane itemMgmtPane() {
		return new ItemMgmtPane();
	}

	@Bean
	public StockMgmtPane stockMgmtPane() {
		return new StockMgmtPane();
	}

	@Bean
	public SalesMgmtPane salesMgmtPane() {
		return new SalesMgmtPane();
	}

	@Bean
	public AccountMgmtPane accountMgmtPane() {
		return new AccountMgmtPane();
	}

	@Bean
	public NavigationTree navigationTree() {
		NavigationTree navTree = new NavigationTree();
		navTree.addNode(partyMgmtPane());
		navTree.addNode(itemMgmtPane());
		navTree.addNode(stockMgmtPane());
		navTree.addNode(salesMgmtPane());
		navTree.addNode(accountMgmtPane());

		return navTree;
	}

	@Bean
	public NavigationPane navigationPane() {
		return new NavigationPane();
	}

}
