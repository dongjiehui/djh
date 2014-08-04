package cn.chiv.entity;

import javax.persistence.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * Entity implementation class for Entity: CharityIntroduction 慈善组织介绍
 */
@Entity
public class CharityIntroduction extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 1L;

	/** 章程 */
	private String constitution;

	/** 名称 */
	private String name;

	/** 组织类型 */
	private String orgatype;
	/** 组织登记证号 */
	private String registrationNum;
	/** 组织机构代码 */
	private String companyCode;
	/** 地址 */
	private String address;
	/** 邮编 */
	private String pose;
	/** 电话 */
	private String postcode;
	/** 邮箱 */
	private String mail;
	/** 法人 */
	private String legalPerson;
	/** 成立时间 */
	private String establishTime;
	/** 宗旨 */
	private String purpose;

	/** 业务范围 */
	private String operationScope;
	/** 状态 */
	private Integer status;
	/** 备选字段 */
	private String intro1;

	private String intro2;

	private String intro3;

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

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPose() {
		return pose;
	}

	public void setPose(String pose) {
		this.pose = pose;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	public String getEstablishTime() {
		return establishTime;
	}

	public void setEstablishTime(String establishTime) {
		this.establishTime = establishTime;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getOperationScope() {
		return operationScope;
	}

	public void setOperationScope(String operationScope) {
		this.operationScope = operationScope;
	}

	public String getIntro1() {
		return intro1;
	}

	public void setIntro1(String intro1) {
		this.intro1 = intro1;
	}

	public String getIntro2() {
		return intro2;
	}

	public void setIntro2(String intro2) {
		this.intro2 = intro2;
	}

	public String getIntro3() {
		return intro3;
	}

	public void setIntro3(String intro3) {
		this.intro3 = intro3;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
