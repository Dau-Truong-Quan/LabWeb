package ptithcm.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="`departs`")
public class Depart {
	@Id
	@Column(name = "id")
	private int id;

	
	private String name;


	@OneToMany(mappedBy = "depart", fetch = FetchType.EAGER)
	private Collection<Staff> lists;
	
	


	public Depart() {
		super();
	}

	public Depart(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

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
