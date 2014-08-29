package cn.chiv.entity;

import static javax.persistence.FetchType.LAZY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * Entity implementation class for Entity: Comments
 * 评论模块
 * 
 */
@Entity
@Table(name = "sec_comments")
public class Comments extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 1L;

	/** 时间			*/
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date comTimes = new Date();
	
	/** 信息内容		*/
	@Column(nullable = false)
	@Lob
	private String comContent;
	
	/**	信息类型		*/
	@Column(nullable = false)
	private String comType;

	/** 慈善公益多条评论 */
	@ManyToOne(fetch = LAZY)
	private Charity charity;

	 /** 故乡风情多条评论 */
	 @ManyToOne(fetch = LAZY)
	 private HometownFlirtatious flirtatious;
	 
	 /** 国外生活多条评论 */
	 @ManyToOne(fetch = LAZY)
	 private LiveAbroad abroad;
	 
	/** 用户信息 */
	@ManyToOne(fetch = LAZY)
	private User user;
	/** 备选字段 */
	private String Optional1;
	private String Optional2;
	private String Optional3;

	public String getComContent() {
		return this.comContent;
	}

	public void setComContent(String comContent) {
		this.comContent = comContent;
	}

	public String getComType() {
		return this.comType;
	}

	public void setComType(String comType) {
		this.comType = comType;
	}

	public Charity getCharity() {
		return charity;
	}

	public void setCharity(Charity charity) {
		this.charity = charity;
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

	public Date getComTimes() {
		return comTimes;
	}

	public void setComTimes(Date comTimes) {
		this.comTimes = comTimes;
	}

}
