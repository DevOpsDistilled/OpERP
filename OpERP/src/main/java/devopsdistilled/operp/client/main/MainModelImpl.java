package devopsdistilled.operp.client.main;

import devopsdistilled.operp.client.abstracts.AbstractModel;
import devopsdistilled.operp.client.abstracts.TaskPane;

public class MainModelImpl extends AbstractModel<MainModelObserver> implements
		MainModel {

	private TaskPane selectedTaskPane;
	private String title;

	public MainModelImpl() {
		this.selectedTaskPane = new DefaultTaskPane();
		this.title = new String("OpERP");
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

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
