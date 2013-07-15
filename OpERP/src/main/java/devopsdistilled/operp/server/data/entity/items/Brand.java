package devopsdistilled.operp.server.data.entity.items;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Brand implements Serializable {

	private static final long serialVersionUID = -8725499929433349001L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long brandID;

	@ManyToOne
	private Manufacturer manufacturer;

}
