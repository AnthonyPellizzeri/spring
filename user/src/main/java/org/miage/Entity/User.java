package org.miage.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(	name = "users",
		uniqueConstraints = {
			@UniqueConstraint(columnNames = "email")
		})
public class User {

	@NotBlank
	@Size(max = 20)
	private String username;

	private boolean admin;

	@NotBlank
	@Size(max = 20)
	private String userlastname;

	@Id
	@Size(max = 50)
	@Email
	private String email;

	@NotBlank
	@Size(max = 120)
	private String password;

	/*@OneToMany
	private Set<coursAssign> idCours= new HashSet<coursAssign>();
*/
	public User() {
	}

	public User(String username,String userlastname, String email, String password, boolean admin) {
		this.username = username;
		this.userlastname = userlastname;
		this.email = email;
		this.password = password;
		this.admin = admin;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getUserlastname() {
		return userlastname;
	}


	public void setUserlastname(String userlastname) {
		this.userlastname = userlastname;
	}
}
