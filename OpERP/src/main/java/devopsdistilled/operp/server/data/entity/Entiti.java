package devopsdistilled.operp.server.data.entity;

import java.io.Serializable;

public abstract class Entiti implements Serializable, Comparable<Entiti> {

	private static final long serialVersionUID = 1511849548001171832L;

	public abstract Long id();

	@Override
	public int compareTo(Entiti anotherEntity) {
		return (this.id() < anotherEntity.id()) ? -1
				: (this.id() > anotherEntity.id()) ? 1 : 0;
	}

}
