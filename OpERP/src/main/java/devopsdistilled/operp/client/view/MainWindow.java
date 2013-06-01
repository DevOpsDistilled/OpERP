package devopsdistilled.operp.client.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.inject.Inject;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class MainWindow {

	private static MainWindow mainWindow = new MainWindow();
	private JFrame mainFrame;

	private SidePane sidePane;
	private TaskPane taskPane;
	private StatusPane statusPane;
	private JToolBar toolBar;
	private JMenuBar menuBar;

	@Inject
	private MainWindowListener listener;

	private JButton button;

	private MainWindow() {

	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public void display(){
		
		initialize();
		buildUI();
	}
	public void initialize() {
		mainFrame = new JFrame();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
		mainFrame.setBounds(5, 5, 400, 400);
	}

	public void buildUI() {
		JPanel contentPane = (JPanel) getMainFrame().getContentPane();
		button = new JButton("Test Button");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listener.buttonPressed();
			}
		});
		contentPane.add(button);
	}

	public JButton getButton() {
		return button;
	}

	public void setButton(JButton button) {
		this.button = button;
	}

	public static MainWindow getInstance() {
		
		return mainWindow;
	}

	public MainWindowListener getListener() {
		return listener;
	}

	public void setListener(MainWindowListener listener) {
		this.listener = listener;
	}

	public static MainWindow getMainWindow() {
		return mainWindow;
	}

	public static void setMainWindow(MainWindow mainWindow) {
		MainWindow.mainWindow = mainWindow;
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
