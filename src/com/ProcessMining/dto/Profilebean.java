package com.ProcessMining.dto;
import java.io.File;
import java.io.Serializable;

public class Profilebean implements Serializable {
	private String loginid;
	private String password;
	private String newpassword;
	private String username;
	private String email;
	private String mobileno;
	private String gender;
	private String address;
	private String role;
	private String status;
	private String fromid;
	private String fromname;
	private int req_id;
	private int t_id;
	private int f_id;
	private int q_id;
	private int cid;
	private String question;	
	private String answer;
	private String comments;
	private int count;
	private String commentby;
	private String commentdate;
	private int likes;
	private String postedby;
	private String posteddate;
	private String postedid;
	
	
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFromid() {
		return fromid;
	}
	public void setFromid(String fromid) {
		this.fromid = fromid;
	}
	public String getFromname() {
		return fromname;
	}
	public void setFromname(String fromname) {
		this.fromname = fromname;
	}
	public int getReq_id() {
		return req_id;
	}
	public void setReq_id(int reqId) {
		req_id = reqId;
	}
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int tId) {
		t_id = tId;
	}
	public int getF_id() {
		return f_id;
	}
	public void setF_id(int fId) {
		f_id = fId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getQ_id() {
		return q_id;
	}
	public void setQ_id(int qId) {
		q_id = qId;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCommentby() {
		return commentby;
	}
	public void setCommentby(String commentby) {
		this.commentby = commentby;
	}
	public String getCommentdate() {
		return commentdate;
	}
	public void setCommentdate(String commentdate) {
		this.commentdate = commentdate;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public String getPostedby() {
		return postedby;
	}
	public void setPostedby(String postedby) {
		this.postedby = postedby;
	}
	public String getPosteddate() {
		return posteddate;
	}
	public void setPosteddate(String posteddate) {
		this.posteddate = posteddate;
	}
	public String getPostedid() {
		return postedid;
	}
	public void setPostedid(String postedid) {
		this.postedid = postedid;
	}
	
	
	}
	

