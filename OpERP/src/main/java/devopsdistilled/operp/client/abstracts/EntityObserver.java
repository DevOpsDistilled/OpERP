package devopsdistilled.operp.client.abstracts;

import java.util.List;

import devopsdistilled.operp.server.data.entity.Entiti;

public interface EntityObserver<E extends Entiti> extends Observer {

	public void update(List<E> entities);

}
