package devopsdistilled.operp.client.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import net.miginfocom.swing.MigLayout;

public class MainWindow {

	private static MainWindow window;
	private JFrame mainFrame;

	private JPanel sidePane;
	private JPanel taskPane;
	private JPanel statusPane;
	private JToolBar toolBar;
	private JMenuBar menuBar;

	public JPanel getTaskPane() {
		return taskPane;
	}

	public void setTaskPane(JPanel taskPane) {
		this.mainFrame.remove(getTaskPane());
		this.taskPane = taskPane;
		System.out.println("From setTaskPane");
		this.mainFrame.getContentPane().add(this.taskPane, "width 75%");

		this.mainFrame.validate();
	}

	public JMenuBar getMenuBar() {
		return menuBar;
	}

	public void setMenuBar(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}

	public JPanel getSidePane() {
		return sidePane;
	}

	public void setSidePane(JPanel sidePane) {
		this.sidePane = sidePane;
	}

	public JPanel getStatusPane() {
		return statusPane;
	}

	public void setStatusPane(JPanel statusPane) {
		this.statusPane = statusPane;
	}

	public JToolBar getToolBar() {
		return toolBar;
	}

	public void setToolBar(JToolBar toolBar) {
		this.toolBar = toolBar;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {

					for (LookAndFeelInfo info : UIManager
							.getInstalledLookAndFeels()) {
						if ("Nimbus".equals(info.getName())) {
							UIManager.setLookAndFeel(info.getClassName());
							break;
						}
					}
					window = new MainWindow();
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainWindow() {
		initialize();
		buildUI();
	}

	private void initialize() {
		mainFrame = new JFrame();
		mainFrame.getContentPane().setLayout(
				new MigLayout("debug", "[]", "[top]"));
		menuBar = MenuBar.getInstance();
		statusPane = StatusPane.getInstance();
		sidePane = SidePane.getInstance();
		toolBar = ToolBar.getInstance();
	}

	private void buildUI() {
		mainFrame.setTitle("OpERP");
		mainFrame.setBounds(100, 100, 450, 300);
		mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setJMenuBar(menuBar);
		mainFrame.getContentPane().add(toolBar, "north, growx");
		mainFrame.getContentPane().add(sidePane, "width 25%, growy, pushy");
		taskPane = new JPanel();
		taskPane.add(new JLabel("From Task Pane"));
		mainFrame.getContentPane().add(taskPane, " width 75%");
		mainFrame.getContentPane().add(statusPane, "south");
	}

	public static MainWindow getInstance() {
		if (window == null) {
			new MainWindow();
		}
		return window;
	}
}
