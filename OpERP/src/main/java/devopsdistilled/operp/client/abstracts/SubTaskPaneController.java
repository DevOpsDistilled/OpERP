package devopsdistilled.operp.client.abstracts;


public interface SubTaskPaneController<M extends Model> {

	M getModel();

	void loadData();
}
