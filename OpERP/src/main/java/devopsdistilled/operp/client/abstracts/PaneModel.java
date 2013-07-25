package devopsdistilled.operp.client.abstracts;

public interface PaneModel<O extends PaneModelObserver> extends Model<O> {

	public void setTitle(String title);

	public String getTitle();

	// public void update();
}
