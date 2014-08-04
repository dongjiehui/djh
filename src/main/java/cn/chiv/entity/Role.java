package cn.chiv.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * Entity implementation class for Entity: Role
 * 
 */
@Entity
@Table(name = "sec_role")
public class Role extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 848557594123152934L;

	private String name;
	private boolean enabled;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
