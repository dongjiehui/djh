package cn.chiv.entity;


import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * Abstract base class for entities. Allows parameterization of id type, chooses auto-generation and implements
 * {@link #equals(Object)} and {@link #hashCode()} based on that id.
 * 
 * @author Oliver Gierke
 * @param <PK> the the of the entity
 */
@MappedSuperclass
public abstract class AbstractPersistable2 <PK extends Serializable> implements Persistable<PK> {

	private static final long serialVersionUID = -5554308939380869754L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private PK u_id;

 

	public PK getU_id() {
		return u_id;
	}

	public void setU_id(PK u_id) {
		this.u_id = u_id;
	}

}