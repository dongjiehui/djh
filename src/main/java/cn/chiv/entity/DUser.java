package cn.chiv.entity;

/**
 * 用户表
 * DUser entity. @author MyEclipse Persistence Tools
 */

public class DUser implements java.io.Serializable {

	// Fields

	private Integer UId;		//用户id
	private String UImg;		//头像路径
	private String UName;		//姓名
	private String UIntergral;	//等级
	private String UGrade;		//用户类别
	private String USex = "";		//性别
	private String UStatus;		//删除标志位 正常用户是1，删除是2
	private String UPhoneNum;	//手机号
	private String UPassword;	//密码
	private String UEmail = "";		//邮箱
	private String UAddress = "";	//所在地址
	private String UCompany = "";	//公司
	private String UIndustry = "";	//行业
	private String UDemp = "";		//部门
	private String UDempPost = "";	//职位
	private String UCompanyArea = "";//公司地址
	private String UCompanyCity = "";//公司所在市
	private String UFixedPhone = "";	//电话（固号）
	private String URecommend = "";	//推荐人
	private Integer UFriendsNum;//好友数
	private String UProfilePublish = "";//个人资料公开
	private String UPersonalInformation = ""; //个人资料描述
}