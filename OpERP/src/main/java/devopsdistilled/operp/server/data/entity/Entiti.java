package devopsdistilled.operp.server.data.entity;

import java.io.Serializable;

public abstract class Entiti<ID extends Serializable & Comparable<ID>>
		implements Serializable, Comparable<Entiti<ID>> {

	private static final long serialVersionUID = 1511849548001171832L;

	public abstract ID id();

	@Override
	public int compareTo(Entiti<ID> aEntity) {
		return this.id().compareTo(aEntity.id());
	}

}
