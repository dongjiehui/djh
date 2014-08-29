package cn.chiv.entity;

import static javax.persistence.FetchType.LAZY;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity implementation class for Entity: NewsS 
 * 侨联新闻模块
 */
@Entity
public class NewsS extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 1L;

	/** 标题 */
	private String Title;

	/** 关键字 */
	private String KeyWord;
	
	/** 发布时间 */
	@Temporal(TemporalType.DATE)
	private Date times = new Date();
	
	/** 内容 */
	@Lob
	private String content;
	
	/** 图片路径 */
	@Lob
	@Basic(fetch = LAZY)
	@JsonIgnore
	private byte[] Img;
	
	/** 作者 */
	private String author;
	
	/** 分类 */
	private String classes;
	
	/** 信息等级 */
	private String infoLevel;
	
	/** 点击数 */
	private int clickNum;
	
	/** 来源 */
	private String resource;
	
	/** 状态 */
	private Integer status;

	/** 用户信息 */
	@ManyToOne(fetch = LAZY)
	private User user;
	
	/** 备选字段 */
	private String Optional1;
	private String Optional2;
	private String Optional3;

	
	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getKeyWord() {
		return KeyWord;
	}

	public void setKeyWord(String keyWord) {
		KeyWord = keyWord;
	}

	public Date getTimes() {
		return times;
	}

	public void setTimes(Date times) {
		this.times = times;
	}


	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
 

	public byte[] getImg() {
		return Img;
	}

	public void setImg(byte[] img) {
		Img = img;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	public String getInfoLevel() {
		return infoLevel;
	}

	public void setInfoLevel(String infoLevel) {
		this.infoLevel = infoLevel;
	}

 

	public int getClickNum() {
		return clickNum;
	}

	public void setClickNum(int clickNum) {
		this.clickNum = clickNum;
	}


	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
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
