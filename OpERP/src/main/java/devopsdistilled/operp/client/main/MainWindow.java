package devopsdistilled.operp.client.main;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.swing.JFrame;
import javax.swing.JSplitPane;

import devopsdistilled.operp.client.abstracts.TaskPane;

public class MainWindow implements MainModelObserver {

	private static MainWindow mainWindow = new MainWindow();

	@Inject
	private MainWindowController controller;

	@Inject
	private MainModel model;

	private JFrame frame;
	private JSplitPane splitPane;

	private MainWindow() {
	}

	public static MainWindow getInstance() {
		return mainWindow;
	}

	@PostConstruct
	private void registerObserver() {
		model.registerObserver(this);
		model.castObservers();
	}

	public void init() {

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				initComponents();
				frame.getContentPane().add(splitPane);

				splitPane.setLeftComponent(new NavigationPane().getPane());
				splitPane.setRightComponent(model.getSelectedTaskPane()
						.getPane());

				frame.setVisible(true);
			}
		});
	}

	private void initComponents() {
		frame = new JFrame(model.getTitle());
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds(new Rectangle(screenSize));
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		splitPane = new JSplitPane();
		splitPane.setDividerLocation(200);
	}

	@Override
	public void updateTaskPane(TaskPane taskPane) {
		splitPane.setRightComponent(taskPane.getPane());
	}

	@Override
	public void updateTitle(String title) {
		frame.setTitle(title);
	}

	public MainModel getModel() {
		return model;
	}

	@Override
	public void updateAll() {

	}
}
