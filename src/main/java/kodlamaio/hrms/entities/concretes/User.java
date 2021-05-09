package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email_verified")
	private boolean emailVerfied;
	
	public User() {
		
	}

	/**
	 * @param id
	 * @param email
	 * @param password
	 * @param emailVerfied
	 */
	public User(int id, String email, String password, boolean emailVerfied) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.emailVerfied = emailVerfied;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEmailVerfied() {
		return emailVerfied;
	}

	public void setEmailVerfied(boolean emailVerfied) {
		this.emailVerfied = emailVerfied;
	}

}
