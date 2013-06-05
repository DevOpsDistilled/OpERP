package devopsdistilled.operp.client.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.inject.Inject;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;

public class MainWindow {

	private JFrame mainFrame;
	private TaskPane taskPane;
	private StatusPane statusPane;
	private SidePane sidePane;

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
					
					JButton btnHideTaskbar = new JButton("Hide Taskbar");
					btnHideTaskbar.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							listener.btnHideTaskbarPressed();
						}
					});
					mainFrame.getContentPane().add(btnHideTaskbar, BorderLayout.EAST);
					
					JButton btnShowTaskbar = new JButton("Show Taskbar");
					btnShowTaskbar.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							listener.btnShowTaskbarPressed();
						}
					});
					mainFrame.getContentPane().add(btnShowTaskbar, BorderLayout.WEST);

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

	public SidePane getSidePane() {
		return sidePane;
	}

	public void setSidePane(SidePane sidePane) {
		this.sidePane = sidePane;
	}

	public TaskPane getTaskPane() {
		return taskPane;
	}

	public void setTaskPane(TaskPane taskPane) {
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
