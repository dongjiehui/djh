package cn.chiv.entity;

import static javax.persistence.FetchType.LAZY;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity implementation class for Entity: MemberMessages 
 * 会员寄语模块
 * -不加评论
 */
@Entity
@Table(name = "menber_messages")
public class MemberMessages extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 1L;

	/** 标题 */
	@Column(nullable = false)
	private String title;

	/** 图片 */
	@Lob
	@Basic(fetch = LAZY)
	@JsonIgnore
	private byte[] imgs;

	/** 点击数 */
	private int clickNum;

	/** 日期 */
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dates;
	
	/** 内容 */
	@Column(nullable = false)
	@Lob
	private String contents;

	/** 状态值 */
	@Column(nullable = false)
	private String status;
	
	/** 用户信息 */
	@ManyToOne(fetch = LAZY)
	private User user;
	
	/** 备选字段 */
	private String Optional1;
	private String Optional2;
	private String Optional3;

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDates() {
		return dates;
	}

	public void setDates(Date dates) {
		this.dates = dates;
	}

	public String getContents() {
		return this.contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
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

	public byte[] getImgs() {
		return imgs;
	}

	public void setImgs(byte[] imgs) {
		this.imgs = imgs;
	}

	public int getClickNum() {
		return clickNum;
	}

	public void setClickNum(int clickNum) {
		this.clickNum = clickNum;
	}

}
