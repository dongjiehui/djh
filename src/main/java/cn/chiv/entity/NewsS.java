package cn.chiv.entity;

import java.util.Date;

import javax.persistence.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * Entity implementation class for Entity: NewsS 侨联新闻
 */
@Entity
public class NewsS extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 1L;

	/** 标题 */
	private String Title;

	/** 关键字 */
	private String KeyWord;
	/** 发布时间 */
	private Date times;
	/** 发布人 */
	private Integer pubMan;
	/** 内容 */
	private String content;
	/** 图片路径 */
	private String Img;
	/** 作者 */
	private String author;
	/** 分类 */
	private String classes;
	/** 信息等级 */
	private String infoLevel;
	/** 点击数 */
	private Integer clickNum;
	/** 会员账号 */
	private String acounts;
	/** 来源 */
	private String resource;
	/** 状态 */
	private Integer status;

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

	public Integer getPubMan() {
		return pubMan;
	}

	public void setPubMan(Integer pubMan) {
		this.pubMan = pubMan;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImg() {
		return Img;
	}

	public void setImg(String img) {
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

	public Integer getClickNum() {
		return clickNum;
	}

	public void setClickNum(Integer clickNum) {
		this.clickNum = clickNum;
	}

	public String getAcounts() {
		return acounts;
	}

	public void setAcounts(String acounts) {
		this.acounts = acounts;
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

}
