package devopsdistilled.operp.client.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.inject.Inject;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;

public class MainWindow {

	private JFrame mainFrame;
	private TaskPaneOld taskPane;
	private StatusPane statusPane;
	private SidePaneOld sidePane;

	@Inject
	private JToolBar toolBar;

	@Inject
	private JMenuBar menuBar;

	@Inject
	private MainWindowListener listener;

	public MainWindow() {

	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public void display() {

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				initialize();

				try {
					getMainFrame().setVisible(true);
					getMainFrame().setJMenuBar(getMenuBar());
					getMainFrame().getContentPane().add(getToolBar(), BorderLayout.NORTH);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void initialize() {
		mainFrame = new JFrame();
		mainFrame.setBounds(100, 100, 450, 300);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public MainWindowListener getListener() {
		return listener;
	}

	public void setListener(MainWindowListener listener) {
		this.listener = listener;
	}

	public JFrame getMainFrame() {
		return mainFrame;
	}

	public void setMainFrame(JFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	public SidePaneOld getSidePane() {
		return sidePane;
	}

	public void setSidePane(SidePaneOld sidePane) {
		this.sidePane = sidePane;
	}

	public TaskPaneOld getTaskPane() {
		return taskPane;
	}

	public void setTaskPane(TaskPaneOld taskPane) {
		this.taskPane = taskPane;
	}

	public StatusPane getStatusPane() {
		return statusPane;
	}

	public void setStatusPane(StatusPane statusPane) {
		this.statusPane = statusPane;
	}

	public JToolBar getToolBar() {
		return toolBar;
	}

	public void setToolBar(JToolBar toolBar) {
		this.toolBar = toolBar;
	}

	public JMenuBar getMenuBar() {
		return menuBar;
	}

	public void setMenuBar(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}
}
