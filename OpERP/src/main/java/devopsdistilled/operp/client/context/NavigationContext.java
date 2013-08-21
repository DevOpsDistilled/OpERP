package devopsdistilled.operp.client.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.items.ItemMgmtPane;
import devopsdistilled.operp.client.main.NavigationPane;
import devopsdistilled.operp.client.main.NavigationTree;
import devopsdistilled.operp.client.party.PartyMgmtPane;
import devopsdistilled.operp.client.sales.SalesMgmtPane;
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
	public NavigationTree navigationTree() {
		NavigationTree navTree = new NavigationTree();
		navTree.addNode(partyMgmtPane(), 0);
		navTree.addNode(itemMgmtPane(), 1);
		navTree.addNode(stockMgmtPane(), 2);
		navTree.addNode(salesMgmtPane(), 3);

		return navTree;
	}

	@Bean
	public NavigationPane navigationPane() {
		return new NavigationPane();
	}

}
