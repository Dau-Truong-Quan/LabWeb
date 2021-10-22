package ptithcm.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="`staffs`")
public class Staff {
	
	@Id
	@Column(name = "id")
	private int id;
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "departId")
	private Depart depart;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date birthday;
	private boolean gender;
	private String photo;
	private String email;
	private float salary;
	private String notes;
	
	@OneToMany(mappedBy = "staff", fetch = FetchType.EAGER)
	private Collection<Record> lists;

	public Staff(int id, String name, Depart depart, Date birthday, boolean gender, String photo, String email,
			float salary, String notes, Collection<Record> lists) {
		super();
		this.id = id;
		this.name = name;
		this.depart = depart;
		this.birthday = birthday;
		this.gender = gender;
		this.photo = photo;
		this.email = email;
		this.salary = salary;
		this.notes = notes;
		this.lists = lists;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
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

	public Depart getDepart() {
		return depart;
	}

	public void setDepart(Depart depart) {
		this.depart = depart;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Collection<Record> getLists() {
		return lists;
	}

	public void setLists(Collection<Record> lists) {
		this.lists = lists;
	}

	public Staff(int id, String name, Depart depart, Date birthday, String photo, String email, float salary,
			String notes, Collection<Record> lists) {
		super();
		this.id = id;
		this.name = name;
		this.depart = depart;
		this.birthday = birthday;
		this.photo = photo;
		this.email = email;
		this.salary = salary;
		this.notes = notes;
		this.lists = lists;
	}

	public Staff() {
		super();
	}
	
	
	
}
