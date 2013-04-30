package devopsdistilled.operp.server.data.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Warehouse implements Serializable {
	@Id
	private Long warehouseID;
	private String location;
}