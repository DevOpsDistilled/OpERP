package devopsdistilled.operp.server.data.service.business.impl;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import devopsdistilled.operp.server.data.entity.account.PaidTransaction;
import devopsdistilled.operp.server.data.entity.business.Purchase;
import devopsdistilled.operp.server.data.entity.business.PurchaseDescRow;
import devopsdistilled.operp.server.data.entity.stock.Stock;
import devopsdistilled.operp.server.data.entity.stock.StockKeeper;
import devopsdistilled.operp.server.data.repo.business.PurchaseRepository;
import devopsdistilled.operp.server.data.service.account.PaidTransactionService;
import devopsdistilled.operp.server.data.service.business.PurchaseService;
import devopsdistilled.operp.server.data.service.stock.StockKeeperService;

@Service
public class PurchaseServiceImpl extends
		BusinessServiceImpl<Purchase, PurchaseRepository> implements
		PurchaseService {

	private static final long serialVersionUID = 2688393943868408691L;

	@Inject
	private PurchaseRepository repo;

	@Inject
	private PaidTransactionService paidTransactionService;

	@Inject
	private StockKeeperService stockKeeperService;

	@Override
	protected PurchaseRepository getRepo() {
		return repo;
	}

	@Override
	@Transactional
	public <S extends Purchase> S save(S purchase) {
		purchase.setDate(new Date());
		S savedPurchase = super.save(purchase);

		for (PurchaseDescRow purchaseDescRow : savedPurchase.getBusinessDesc()
				.getDescRows()) {

			Stock stock = new Stock();
			stock.setItem(purchaseDescRow.getItem());
			stock.setWarehouse(purchaseDescRow.getWarehouse());

			StockKeeper stockKeeper = new StockKeeper();
			stockKeeper.setStock(stock);
			stockKeeper.setQuantity(purchaseDescRow.getQuantity());
			stockKeeper.setNote("From Purchase #" + purchase.getBusinessId());
			stockKeeper.setStockUpdateDate(new Date());
			stockKeeperService.save(stockKeeper);
		}

		PaidTransaction transaction = new PaidTransaction();
		transaction.setAccount(savedPurchase.getParty().getAccount());
		transaction.setNote("From Purchase #"
				+ savedPurchase.getBusinessId().toString() + " on "
				+ savedPurchase.getDate());
		transaction.setAmount(savedPurchase.getAmount() * (-1));
		paidTransactionService.save(transaction);
		return savedPurchase;

	}
}
