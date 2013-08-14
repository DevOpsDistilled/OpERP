package devopsdistilled.operp.server.data.entity.commons;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import devopsdistilled.operp.server.data.entity.Entiti;

public class ContactInfo extends Entiti<Long> {

	private static final long serialVersionUID = 2729474004283929872L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long contactId;

	private Address address;

	private String email;

	private List<Phone> phoneNumbers;

	@Override
	public Long id() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
