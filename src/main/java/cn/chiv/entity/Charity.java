package cn.chiv.entity;

import static javax.persistence.FetchType.LAZY;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity implementation class for Entity: Charity 
 * 慈善公益模块
 * 参与，主办-加评论
 * 
 */
@Entity
public class Charity extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 1L;

	/** 慈善标题 */
	private String title;
	/** 慈善图片 */
	@Lob
	@Basic(fetch = LAZY)
	@JsonIgnore
	private byte[] img;
	/** 慈善主办 */
	private String organizer;
	/** 慈善点击数 */
	private int clickNum;
	/** 内容 */
	@Column(nullable = false)
	@Lob
	private String content;

	/** 慈善主办logo */
	private byte[] organizerLogo;
	/** 慈善合作方 logo */
	private byte[] partnerLogo;

	/** 日期 */
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dates;

	/** 用户信息 */
	@ManyToOne(fetch = LAZY)
	private User user;

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

	public String getOrganizer() {
		return this.organizer;
	}

	public void setOrganizer(String organizer) {
		this.organizer = organizer;
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

	public Date getDates() {
		return dates;
	}

	public void setDates(Date dates) {
		this.dates = dates;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	public int getClickNum() {
		return clickNum;
	}

	public void setClickNum(int clickNum) {
		this.clickNum = clickNum;
	}

	public byte[] getOrganizerLogo() {
		return organizerLogo;
	}

	public void setOrganizerLogo(byte[] organizerLogo) {
		this.organizerLogo = organizerLogo;
	}

	public byte[] getPartnerLogo() {
		return partnerLogo;
	}

	public void setPartnerLogo(byte[] partnerLogo) {
		this.partnerLogo = partnerLogo;
	}

}
