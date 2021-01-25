package org.miage.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(	name = "cours")
public class cours {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Size(max = 20)
	private String name;

	private String description;

	private boolean free;
	private long price;

	public cours() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isFree() {
		return free;
	}

	public void setFree(boolean free) {
		this.free = free;
	}

	public long getPrice() {
		return price;
	}

	public cours(@Size(max = 20) String name, String description, boolean free, long price) {
		this.name = name;
		this.description = description;
		this.free = free;
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(long price) {
		this.price = price;
	}
}
