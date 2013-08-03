package devopsdistilled.operp.server.data.entity;

import java.io.Serializable;

public abstract class Entiti implements Serializable, Comparable<Entiti> {

	private static final long serialVersionUID = 1511849548001171832L;

	public abstract Long getId();

	@Override
	public int compareTo(Entiti anotherEntity) {
		return (this.getId() < anotherEntity.getId()) ? -1
				: (this.getId() > anotherEntity.getId()) ? 1 : 0;
	}

}
