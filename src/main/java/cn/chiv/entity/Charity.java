package cn.chiv.entity;

import javax.persistence.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * Entity implementation class for Entity: Charity 慈善参与，主办
 * 
 */
@Entity
public class Charity extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 1L;

	/** 慈善标题 */
	private String title;
	/** 内容 */
	private String content;
	/** 慈善图片 */
	private String img;

	/** 慈善主办 */
	private String organizer;

	/** 慈善合作方 */
	private String partner;

	/** 慈善点击数 */
	private String clickNum;

	/** 项目地址 */
	private String address;


	/**	评论	*/
	private String comments;
	
	/**	-----------------------我要捐款-------------------	*/
	/** 捐款目标		*/
	private String aims;
	
	/**	已捐款金额	*/
	private Double	moneys;
	/** 捐款人数		*/
	
	/**	是否公开	*/
	private Boolean enabled;
	
	/** 周期 结束时间 */
	private String projektdauer;
	
	
	/**---------------放捐款人信息----------------------------------------------*/
	/** 姓名 */
	private String name;
	/** 电话 */
	private String telePhone;
	/** 邮箱 */
	private String mail;
	/** 企业名称 */
	private String firmName;
	
	/** 状态 */
	private Integer status;
	/** 备选字段 */
	private String option1;

	private String option2;

	private String option3;

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImg() {
		return this.img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getOrganizer() {
		return this.organizer;
	}

	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}

	public String getClickNum() {
		return this.clickNum;
	}

	public void setClickNum(String clickNum) {
		this.clickNum = clickNum;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProjektdauer() {
		return this.projektdauer;
	}

	public void setProjektdauer(String projektdauer) {
		this.projektdauer = projektdauer;
	}
 
	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getAims() {
		return aims;
	}

	public void setAims(String aims) {
		this.aims = aims;
	}


	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelePhone() {
		return telePhone;
	}

	public void setTelePhone(String telePhone) {
		this.telePhone = telePhone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getFirmName() {
		return firmName;
	}

	public void setFirmName(String firmName) {
		this.firmName = firmName;
	}

}
