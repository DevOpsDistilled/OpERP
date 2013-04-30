package devopsdistilled.operp.server.data.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category implements Serializable{
	@Id
	private Long categoryId;
	private String categoryName;
	
}
