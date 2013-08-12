package devopsdistilled.operp.client.stock.panes.details;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import net.miginfocom.swing.MigLayout;
import devopsdistilled.operp.client.abstracts.SubTaskPane;
import devopsdistilled.operp.server.data.entity.stock.StockKeeper;

public class TransferStockDetailsPane extends SubTaskPane {

	private final JSplitPane splitPane;
	private final JPanel pane;

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

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		pane.add(btnDelete, "flowx,cell 0 3 2 1");

		JButton btnEdit = new JButton("Edit");
		pane.add(btnEdit, "cell 0 3 2 1");

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getDialog().dispose();
			}
		});
		pane.add(btnOk, "cell 0 3 2 1");
	}

	@Override
	public JComponent getPane() {
		return pane;
	}

	public void show(StockKeeper srcStockKeeper, StockKeeper destStockKeeper) {

		// Check if transfer stock pair
		if (srcStockKeeper.compareTo(destStockKeeper.getTransferStockKeeper()) == 0
				&& destStockKeeper.compareTo(srcStockKeeper
						.getTransferStockKeeper()) == 0) {

			StockKeepingDetailsPane srcDetails = new StockKeepingDetailsPane();
			StockKeepingDetailsPane destDetails = new StockKeepingDetailsPane();

			srcDetails.init(srcStockKeeper);
			destDetails.init(destStockKeeper);

			splitPane.setLeftComponent(srcDetails.getPane());
			splitPane.setRightComponent(destDetails.getPane());

			getDialog().getContentPane().add(getPane(), "grow");
			getDialog().setSize(800, 400);
			getDialog().setTitle("Stock Transfer Details");
			getDialog().setVisible(true);
		} else {
			getDialog().dispose();
			JOptionPane.showMessageDialog(getPane(),
					"Stock Activity pair not a transaction");
		}

	}
}
