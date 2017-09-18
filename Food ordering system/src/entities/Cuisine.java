package entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cuisine {

	@Id
	@GeneratedValue
	private long id;
	private String name;

	@OneToMany(mappedBy = "cuisine")
	private List<Foods> foods;

	public Cuisine() {

	}

	public Cuisine(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public long getId() {
		return id;
	}

}
