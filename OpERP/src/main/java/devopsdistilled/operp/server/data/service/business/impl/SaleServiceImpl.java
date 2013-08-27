package devopsdistilled.operp.server.data.service.business.impl;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import devopsdistilled.operp.server.data.entity.account.ReceivedTransaction;
import devopsdistilled.operp.server.data.entity.business.Sale;
import devopsdistilled.operp.server.data.entity.business.SaleDescRow;
import devopsdistilled.operp.server.data.entity.stock.Stock;
import devopsdistilled.operp.server.data.entity.stock.StockKeeper;
import devopsdistilled.operp.server.data.repo.business.SaleRepository;
import devopsdistilled.operp.server.data.service.account.ReceivedTransactionService;
import devopsdistilled.operp.server.data.service.business.SaleService;
import devopsdistilled.operp.server.data.service.stock.StockKeeperService;

@Service
public class SaleServiceImpl extends BusinessServiceImpl<Sale, SaleRepository>
		implements SaleService {

	private static final long serialVersionUID = 2688393943868408691L;

	@Inject
	private SaleRepository repo;

	@Inject
	private ReceivedTransactionService receivedTransactionService;

	@Inject
	private StockKeeperService stockKeeperService;

	@Override
	protected SaleRepository getRepo() {
		return repo;
	}

	@Override
	@Transactional
	public <S extends Sale> S save(S sale) {
		sale.setDate(new Date());
		S savedSale = super.save(sale);

		for (SaleDescRow saleDescRow : savedSale.getBusinessDesc()
				.getDescRows()) {

			Stock stock = new Stock();
			stock.setItem(saleDescRow.getItem());
			stock.setWarehouse(saleDescRow.getWarehouse());

			StockKeeper stockKeeper = new StockKeeper();
			stockKeeper.setStock(stock);
			stockKeeper.setQuantity(saleDescRow.getQuantity() * (-1));
			stockKeeper.setNote("From Sale #" + sale.getBusinessId());
			stockKeeper.setStockUpdateDate(new Date());
			stockKeeperService.save(stockKeeper);
		}

		ReceivedTransaction transaction = new ReceivedTransaction();
		transaction.setAccount(savedSale.getParty().getAccount());
		transaction.setNote("From Sale #"
				+ savedSale.getBusinessId().toString() + " on "
				+ savedSale.getDate());
		transaction.setAmount(savedSale.getAmount() * (-1));
		receivedTransactionService.save(transaction);
		return savedSale;

	}
}
