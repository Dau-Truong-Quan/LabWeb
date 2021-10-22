package ptithcm.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class UserModel {

	
	@NotNull(message = "vui long nhap username")
	private String id;

	
	@Size(min=2, max=30)
	@NotNull
	private String password;
	
	
	
	public String getUsername() {
		return id;
	}



	public void setUsername(String username) {
		this.id = username;
	}





	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public UserModel() {
		super();
	}
	
	


	
	
	
}