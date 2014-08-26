package cn.chiv.entity;

import static javax.persistence.FetchType.LAZY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity implementation class for Entity: User 用户模块
 * 
 */
@Entity
@Table(name = "d_user")
@Audited
public class User extends AbstractPersistable2<Long> {

	private static final long serialVersionUID = 5374970514016239427L;
	/** 姓名 */
	@Column(name = "U_Name", nullable = false)
	private String username;
	/** 等级 */
	@Column(name = "U_Intergral")
	private String intergral;
	/** 用户类别 */
	@Column(name = "U_Grade")
	private String grades;
	
	/** 性别 */
	@Column(name = "U_Sex")
	private String sex;
	
	@Transient//不持久化
	@Enumerated(EnumType.STRING)
	@Column(length=5, nullable=false)
	private Gender gender = Gender.MAN;
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/** 手机号 */
	@Column(name = "U_Phone_Num", nullable = false)
	private String phoneNum;
	/** 密码 */
	@Column(name = "U_Password", nullable = false)
	@JsonIgnore
	private String password;

	/** 邮箱 */
	@Column(name = "U_Email")
	private String email;
	/** 所在地址 */
	@Column(name = "U_Address")
	private String address;
	/** 公司 */
	@Column(name = "U_Company")
	private String company;
	/** 行业 */
	@Column(name = "U_Industry")
	private String industry;
	
	/** 部门 */
	@Column(name = "U_Demp")
	private String demp;
	
	/** 职位 */
	@Column(name = "U_Demp_Post")
	private String dempPost;
	
	/** 公司地址 */
	@Column(name = "U_Company_Area")
	private String companyArea;


	/** 电话（固号） */
	@Column(name = "U_Fixed_Phone")
	private String teltPhone;

	/** 推荐人 */
	@Column(name = "U_Recommend")
	private String recommend;
	/** 好友数 */
	@Column(name = "U_Friends_Num")
	private Integer friendsNum;
	
	/** 个人资料公开 */
	@Column(name = "U_Profile_Publish")
	private String profilePublish;
	
	/** 个人资料描述 */
	@Column(name = "U_Personal_Information")
	private String personalInformation;
	/** 公司所在市 */
	@Column(name = "U_Company_City")
	private String companyCity;

	/** 删除标志位 正常用户是1，删除是2 */
	@Column(name = "U_Status")
	private String status;
	/** 头像路径 */
	@Column(name = "U_Img")
	@Basic(fetch = LAZY)
	@JsonIgnore
	private String imges;
	
	/** 图片 */
	@Lob
	@Basic(fetch = LAZY)
	@JsonIgnore
	private byte[] imgs;

	/** 注册的时间 */
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dates;

	/** 年龄 */
	private int age;
	
	/** 生日 */
	@Temporal(TemporalType.DATE)
	private Date birthday;
	/**		*/
	private boolean enabled;
	
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
	
	public User() {
		
	}
	
	public User(Long id) {
		setU_id(id);
	}

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

	public Integer getFriendsNum() {
		return friendsNum;
	}

	public void setFriendsNum(Integer friendsNum) {
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

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return false;
	}

}
