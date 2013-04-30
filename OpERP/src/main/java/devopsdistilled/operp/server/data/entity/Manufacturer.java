package devopsdistilled.operp.server.data.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Manufacturer implements Serializable {
	@Id
	private Long manufacturerId;
	private String manufacturerName;
}
