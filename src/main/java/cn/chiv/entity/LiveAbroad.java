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
 * Entity implementation class for Entity: LiveAbroad
 * 国外生活模块
 * 
 */
@Entity
public class LiveAbroad extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 1L;

	/** 标题 */
	private String title;

	/** 图片 */
	@Lob
	@Basic(fetch = LAZY)
	@JsonIgnore
	private byte[] imgs;

	/** 内容 */
	@Lob
	private String contents;

	/** 日期 */
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date publishDate;

	/** 点击数 */
	private int clickNum;

	/** 状态 */
	private String status;

	/** 备选字段 */
	private String Optional1;
	private String Optional2;
	private String Optional3;

	/** 用户信息 */
	@ManyToOne(fetch = LAZY, optional = false)
	private User user;

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public byte[] getImgs() {
		return imgs;
	}

	public void setImgs(byte[] imgs) {
		this.imgs = imgs;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getContents() {
		return this.contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getClickNum() {
		return clickNum;
	}

	public void setClickNum(int clickNum) {
		this.clickNum = clickNum;
	}

}
