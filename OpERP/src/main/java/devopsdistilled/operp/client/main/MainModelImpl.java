package devopsdistilled.operp.client.main;

import java.util.ArrayList;
import java.util.List;

public class MainModelImpl extends AbstractModel implements MainModel {

	private TaskPane selectedTaskPane;
	private String title;

	protected List<MainModelObserver> observers;

	public MainModelImpl() {
		this.selectedTaskPane = new DefaultTaskPane();
		this.title = new String("OpERP");
		observers = new ArrayList<>();
	}

	@Override
	public void castObservers() {
		for (Observer observer : super.observers) {
			observers.add((MainModelObserver) observer);
		}
	}

	@Override
	public void setSelectedTaskPane(TaskPane taskPane) {
		this.selectedTaskPane = taskPane;
		for (MainModelObserver observer : observers) {
			observer.updateTaskPane(taskPane);
		}
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
		for (MainModelObserver observer : observers) {
			observer.updateTitle(title);
		}
	}

	@Override
	public TaskPane getSelectedTaskPane() {
		return selectedTaskPane;
	}

	@Override
	public String getTitle() {
		return title;
	}
}
