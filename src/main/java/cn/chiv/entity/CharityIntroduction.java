package cn.chiv.entity;

import static javax.persistence.FetchType.LAZY;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity implementation class for Entity: CharityIntroduction 
 * 慈善组织介绍模块
 */
@Entity
public class CharityIntroduction extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 1L;

	/** 章程 */
	@Lob
	private String constitution;

	/** 名称 */
	private String name;
	/** 慈善图片 */
	@Lob
	@Basic(fetch = LAZY)
	@JsonIgnore
	private byte[] img;
	
	/** 组织类型 */
	private String orgatype;
	/** 组织登记证号 */
	private String registrationNum;
	/** 法人 */
	private String legalPerson;
	/** 成立时间 */
	private Date establishTime = new Date();

	/** 业务范围 */
	private String operationScope;
	/** 状态 */
	private Integer status;
	/** 用户信息 */
	@ManyToOne(fetch = LAZY)
	private User user;
	/** 备选字段 */
	private String Optional1;
	private String Optional2;
	private String Optional3;

	public String getConstitution() {
		return constitution;
	}

	public void setConstitution(String constitution) {
		this.constitution = constitution;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrgatype() {
		return orgatype;
	}

	public void setOrgatype(String orgatype) {
		this.orgatype = orgatype;
	}

	public String getRegistrationNum() {
		return registrationNum;
	}

	public void setRegistrationNum(String registrationNum) {
		this.registrationNum = registrationNum;
	}

	public String getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	 

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	public Date getEstablishTime() {
		return establishTime;
	}

	public void setEstablishTime(Date establishTime) {
		this.establishTime = establishTime;
	}

	public String getOperationScope() {
		return operationScope;
	}

	public void setOperationScope(String operationScope) {
		this.operationScope = operationScope;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getOptional1() {
		return Optional1;
	}

	public void setOptional1(String optional1) {
		Optional1 = optional1;
	}

	public String getOptional2() {
		return Optional2;
	}

	public void setOptional2(String optional2) {
		Optional2 = optional2;
	}

	public String getOptional3() {
		return Optional3;
	}

	public void setOptional3(String optional3) {
		Optional3 = optional3;
	}

}
