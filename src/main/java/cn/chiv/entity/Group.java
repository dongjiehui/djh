package cn.chiv.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * Entity implementation class for Entity: Group
 * 所在组模块
 * 
 */
@Entity
@Table(name = "sec_group")
@Audited
public class Group extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 7088119885136369695L;

	private String name;

	private String description;

	private boolean enabled;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Group parent;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
