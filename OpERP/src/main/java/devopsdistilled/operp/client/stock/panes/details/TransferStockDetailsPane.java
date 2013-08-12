package devopsdistilled.operp.client.stock.panes.details;

import javax.inject.Inject;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.AbstractEntityDetailsPane;
import devopsdistilled.operp.client.stock.controllers.StockKeeperController;
import devopsdistilled.operp.server.data.entity.stock.StockKeeper;

public class TransferStockDetailsPane extends
		AbstractEntityDetailsPane<StockKeeper, StockKeeperController> {

	@Inject
	private StockKeeperController stockKeeperController;

	private final JSplitPane splitPane;

	private final JPanel pane;

	private StockKeeper srcStockKeeper;

	public TransferStockDetailsPane() {
		pane = new JPanel();
		pane.setLayout(new MigLayout("",
				"[209px,grow,center][209px,grow,center]", "[][][29px][center]"));

		JLabel lblSource = new JLabel("Source");
		pane.add(lblSource, "cell 0 0");

		JLabel lblDestination = new JLabel("Destination");
		pane.add(lblDestination, "cell 1 0");
		splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.5);
		splitPane.setContinuousLayout(false);
		pane.add(splitPane, "cell 0 2 2 1,alignx left,aligny top,grow");
	}

	@Override
	public JPanel getPane() {
		return pane;
	}

	@Override
	public StockKeeperController getEntityController() {
		return stockKeeperController;
	}

	@Override
	protected StockKeeper getEntity() {
		return srcStockKeeper;
	}

	@Override
	public void show(StockKeeper srcStockKeeper) {
		if (srcStockKeeper.getTransferStockKeeper() != null) {

			this.srcStockKeeper = srcStockKeeper;
			StockKeeper destStockKeeper = srcStockKeeper
					.getTransferStockKeeper();

			StockKeepingDetailsPane srcDetails = new StockKeepingDetailsPane();
			StockKeepingDetailsPane destDetails = new StockKeepingDetailsPane();

			srcDetails.init(srcStockKeeper);
			destDetails.init(destStockKeeper);

			splitPane.setLeftComponent(srcDetails.getPane());
			splitPane.setRightComponent(destDetails.getPane());

			showDetailsPane(getPane());

		} else {

			getDialog().dispose();
			JOptionPane.showMessageDialog(getPane(),
					"StockKeeper is not a Transfer Pair");
		}

	}

	@Override
	public String getTitle() {
		return "Transfer Stock Details";
	}
}
