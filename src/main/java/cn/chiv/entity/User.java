package cn.chiv.entity;

import static javax.persistence.FetchType.LAZY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity implementation class for Entity: User 用户模块
 * 
 */
@Entity
@Table(name = "sec_user")
public class User extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 5374970514016239427L;
	
	/** 姓名 */
	@Column(name = "UName", nullable = false)
	private String username;
	/** 密码 */
	@Column(name = "UPassword", nullable = false)
	@JsonIgnore
	private String password;

	/** 邮箱 */
	@Column(name = "UEmail")
	private String email;

	/** 年龄 */
	private int age;

	/** 生日 */
	@Temporal(TemporalType.DATE)
	private Date birthday;

	/** 图片 */
	@Lob
	@Basic(fetch = LAZY)
	@JsonIgnore
	private byte[] imgs;

	/** 头像路径 */
	@Column(name = "UImg")
	@Basic(fetch = LAZY)
	@JsonIgnore
	private String imges;

	/** 等级 */
	@Column(name = "UIntergral")
	private String intergral;

	/** 用户类别 */
	@Column(name = "UGrade")
	private String grades;

	/** 性别 */
	@Column(name = "USex")
	private String sex;

	/** 删除标志位 正常用户是1，删除是2 */
	@Column(name = "UStatus")
	private String status;

	/** 手机号 */
	@Column(name = "UPhoneNum", nullable = false)
	private String phoneNum;

	/** 所在地址 */
	@Column(name = "UAddress")
	private String address;

	/** 公司 */
	@Column(name = "UCompany")
	private String company;

	/** 行业 */
	@Column(name = "UIndustry")
	private String industry;

	/** 部门 */
	@Column(name = "UDemp")
	private String demp;

	/** 职位 */
	@Column(name = "UDempPost")
	private String dempPost;

	/** 公司地址 */
	@Column(name = "UCompanyArea")
	private String companyArea;

	/** 公司所在市 */
	@Column(name = "UCompanyCity")
	private String companyCity;

	/** 电话（固号） */
	@Column(name = "UFixedPhone")
	private String teltPhone;

	/** 推荐人 */
	@Column(name = "URecommend")
	private String recommend;

	/** 好友数 */
	@Column(name = "UFriendsNum")
	private int friendsNum;

	/** 个人资料公开 */
	@Column(name = "UProfilePublish")
	private String profilePublish;

	/** 个人资料描述 */
	@Column(name = "UPersonalInformation")
	private String personalInformation;

	/**		*/
	private boolean enabled;

	/** 注册的时间 */
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dates;

	/** 备选字段 */
	private String Optional1;
	private String Optional2;
	private String Optional3;

	/** 用户组 */
	@ManyToOne(optional = false, fetch = LAZY)
	private Group group;

	/** 角色表 */
	@ManyToMany
	@JoinTable(name = "sec_user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public byte[] getImgs() {
		return imgs;
	}

	public void setImgs(byte[] imgs) {
		this.imgs = imgs;
	}

	public String getImges() {
		return imges;
	}

	public void setImges(String imges) {
		this.imges = imges;
	}

	public String getIntergral() {
		return intergral;
	}

	public void setIntergral(String intergral) {
		this.intergral = intergral;
	}

	public String getGrades() {
		return grades;
	}

	public void setGrades(String grades) {
		this.grades = grades;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getDemp() {
		return demp;
	}

	public void setDemp(String demp) {
		this.demp = demp;
	}

	public String getDempPost() {
		return dempPost;
	}

	public void setDempPost(String dempPost) {
		this.dempPost = dempPost;
	}

	public String getCompanyArea() {
		return companyArea;
	}

	public void setCompanyArea(String companyArea) {
		this.companyArea = companyArea;
	}

	public String getCompanyCity() {
		return companyCity;
	}

	public void setCompanyCity(String companyCity) {
		this.companyCity = companyCity;
	}

	public String getTeltPhone() {
		return teltPhone;
	}

	public void setTeltPhone(String teltPhone) {
		this.teltPhone = teltPhone;
	}

	public String getRecommend() {
		return recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

	public int getFriendsNum() {
		return friendsNum;
	}

	public void setFriendsNum(int friendsNum) {
		this.friendsNum = friendsNum;
	}

	public String getProfilePublish() {
		return profilePublish;
	}

	public void setProfilePublish(String profilePublish) {
		this.profilePublish = profilePublish;
	}

	public String getPersonalInformation() {
		return personalInformation;
	}

	public void setPersonalInformation(String personalInformation) {
		this.personalInformation = personalInformation;
	}

	public Date getDates() {
		return dates;
	}

	public void setDates(Date dates) {
		this.dates = dates;
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
