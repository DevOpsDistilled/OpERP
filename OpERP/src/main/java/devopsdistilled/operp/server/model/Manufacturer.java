package devopsdistilled.operp.server.model;

import java.io.Serializable;

public class Manufacturer implements Serializable {

    private static final long serialVersionUID = -4719489594527646620L;
    private int id;
    private String name;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

}
