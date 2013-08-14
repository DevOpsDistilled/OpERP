package devopsdistilled.operp.server.data.entity.commons;

import javax.persistence.Id;

import devopsdistilled.operp.server.data.entity.Entiti;

public class Phone extends Entiti<String> {

	private static final long serialVersionUID = -7129477071581748259L;

	@Id
	private String phoneNumber;

	private PhoneType type;

	@Override
	public String id() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
