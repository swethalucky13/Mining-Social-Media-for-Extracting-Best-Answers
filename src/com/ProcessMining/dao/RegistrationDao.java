package com.ProcessMining.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ProcessMining.db.DbCon;
import com.ProcessMining.dto.Profilebean;

public class RegistrationDao extends DbCon {

	public int register(Profilebean pb) {
		int i=0;
		Connection con=null;
		
		String role=pb.getRole();
		 		
		con=getConnection();
		
		System.out.println("connection post***************"+con);
		
		try {
			PreparedStatement pstmt=con.prepareStatement("insert into USERDETAILS(user_id,PASSWORD,ROLE,USERNAME,MAIL,MOBILE,GENDER,ADDRESS,STATUS) values(?,?,?,?,?,?,?,?,?)");
			
		pstmt.setString(1, pb.getLoginid());
		pstmt.setString(2, pb.getPassword());
		pstmt.setString(3, pb.getRole());
		pstmt.setString(4, pb.getUsername());
		pstmt.setString(5, pb.getEmail());
		pstmt.setString(6, pb.getMobileno());
		pstmt.setString(7, pb.getGender());
		pstmt.setString(8, pb.getAddress());
		pstmt.setString(9, "Active");
		
		 i=pstmt.executeUpdate();
		
		System.out.println(i+"Record is Inserted successfully");
		
		con.close();
		} 
		
		catch (Exception e) {
			
			e.printStackTrace();
		}
		return i;
	}

	
public ArrayList<Profilebean> viewprofile(String userid) {
		
		Connection con=getConnection();
		ArrayList<Profilebean> list=new ArrayList<Profilebean>();
		try {
			PreparedStatement ps=con.prepareStatement("select USER_ID,USERNAME,MAIL,MOBILE,GENDER,ADDRESS from USERDETAILS where USER_ID=?");
			ps.setString(1, userid);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
			Profilebean pb=new Profilebean();
			    String loginid=rs.getString(1);
				String username=rs.getString(2);
				String mail=rs.getString(3);
				String mobile=rs.getString(4);
				String gender=rs.getString(5);
				String address=rs.getString(6);
				
				pb.setLoginid(loginid);
				pb.setUsername(username);
				pb.setEmail(mail);
				pb.setMobileno(mobile);
				pb.setGender(gender);
				pb.setAddress(address);
				
				list.add(pb);
			
			}
			con.close();
			
		} catch (SQLException e) {

			
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<Profilebean> viewadminprofile(String userid) {
		Connection con=getConnection();
		ArrayList<Profilebean> list=new ArrayList<Profilebean>();
		try {
			PreparedStatement ps=con.prepareStatement("select LOGINID,DOCTORNAME,MAIL,MOBILE,GENDER,ADDRESS from USERINFO where LOGINID=?");
			ps.setString(1, userid);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
			Profilebean pb=new Profilebean();
			    String loginid=rs.getString(1);
				String username=rs.getString(2);
				String mail=rs.getString(3);
				String mobile=rs.getString(4);
				String gender=rs.getString(5);
				String address=rs.getString(6);
				
				pb.setLoginid(loginid);
				pb.setUsername(username);
				pb.setEmail(mail);
				pb.setMobileno(mobile);
				pb.setGender(gender);
				pb.setAddress(address);
				
				list.add(pb);
}
			con.close();
		} catch (SQLException e) {

			
			e.printStackTrace();
		}
		return list;
	}
		
public int changepassword(Profilebean dto) {
	int i=0;
	Connection con=null;
	con=getConnection();
	String userid=dto.getLoginid();
	String oldpassword=dto.getPassword();
	String password=dto.getNewpassword();
	

	
	try
	{
	
	PreparedStatement ps=con.prepareStatement("select password from USERDETAILS where USER_ID='"+userid+"' and PASSWORD='"+oldpassword+"'");
	
	ResultSet rs=ps.executeQuery();
	while(rs.next())
	{
		
		if(rs.getString(1).equals(oldpassword)){
				
			try
			{
			
			PreparedStatement pstmt=con.prepareStatement("update USERDETAILS set password=? where USER_ID=? ");
			pstmt.setString(1, password);
			pstmt.setString(2, userid);
			 i=pstmt.executeUpdate();
			if(i!=0){
				return i;
			}
			
			}catch (Exception e) {
				
			e.printStackTrace();
				
			}
			
			
			
			
			
		}else{
			
			return i;
			
		}
		
	}
	con.close();
	}catch(Exception e){
		
		e.printStackTrace();
	}
	
	return i;
}

public int adminchangepassword(Profilebean dto) {


	
	int i=0;
	Connection con=null;
	con=getConnection();
	String userid=dto.getLoginid();
	String oldpassword=dto.getPassword();
	String password=dto.getNewpassword();
	try
	{
	
	PreparedStatement ps=con.prepareStatement("select password from USERDETAILS where USER_ID='"+userid+"' and PASSWORD='"+oldpassword+"'");
	
	ResultSet rs=ps.executeQuery();
	while(rs.next())
	{
		
		if(rs.getString(1).equals(dto.getPassword())){
				
			try
			{
			
			PreparedStatement pstmt=con.prepareStatement("update USERDETAILS set password=? where USER_ID=? ");
			pstmt.setString(1, dto.getNewpassword());
			pstmt.setString(2, dto.getLoginid());
			 i=pstmt.executeUpdate();
			if(i!=0){
				return i;
			}
			
			}catch (Exception e) {
				
			e.printStackTrace();
				
			}
			
		}else{
			
			return i;
			
		}
	}
	con.close();
	}catch(Exception e){
		
		e.printStackTrace();
	}
	
	return i;
}
	


public int addQuestion(Profilebean pb) {
	int i=0;
	int qid=0;
	Connection con=null;
	try{
		
		con=getConnection();
		System.out.println("connection>>>>>>>>>>>>"+con);
		PreparedStatement ps=con.prepareStatement("select max(Q_ID) from QUESTION_TABLE");
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			qid=rs.getInt(1);
			qid=qid+1;
		}
		PreparedStatement pstmt=con.prepareStatement("insert into QUESTION_TABLE(Q_ID,QUESTION,POSTED_DATE,POSTEDBY,POSTEDID) values(?,?,?,?,?)");
		
		pstmt.setInt(1, qid);
		pstmt.setString(2, pb.getQuestion());
		pstmt.setString(3, pb.getPosteddate());
		pstmt.setString(4, pb.getPostedby());
		pstmt.setString(5, pb.getPostedid());
		
						
		i=pstmt.executeUpdate();
		 con.close();
	}
	catch (Exception e) {
     e.printStackTrace();
	}
	return i;
}

public ArrayList<Profilebean> viewquestion() {
	Connection con=getConnection();
	ArrayList<Profilebean> list=new ArrayList<Profilebean>();
	try {
		PreparedStatement ps=con.prepareStatement("select Q_ID,QUESTION from QUESTION_TABLE");
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			Profilebean pb=new Profilebean();
			pb.setQ_id(rs.getInt(1));
			pb.setQuestion(rs.getString(2));
			//pb.setAnswer(rs.getString(3));
			list.add(pb);
			
			
		}
		con.close();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return list;
}

public ArrayList<Profilebean> viewAllQuestion() {
	Connection con=getConnection();
	ArrayList<Profilebean> list=new ArrayList<Profilebean>();
	try {
		PreparedStatement ps=con.prepareStatement("select Q_ID,QUESTION from QUESTION_TABLE");
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			Profilebean pb=new Profilebean();
			pb.setQ_id(rs.getInt(1));
			pb.setQuestion(rs.getString(2));
			//pb.setAnswer(rs.getString(3));
			list.add(pb);
			
			
		}
		con.close();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return list;
}
public ArrayList<Profilebean> getdetails(String uid) {
	
	Connection con=getConnection();
	ArrayList<Profilebean> list=new ArrayList<Profilebean>();
	try {
		PreparedStatement ps=con.prepareStatement("select USER_ID,USERNAME,MAIL,MOBILE,GENDER,ADDRESS from USERDETAILS where USER_ID=?");
		ps.setString(1, uid);
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			Profilebean pb=new Profilebean();
			pb.setLoginid(rs.getString(1));
			pb.setUsername(rs.getString(2));
			pb.setEmail(rs.getString(3));
			pb.setMobileno(rs.getString(4));
			pb.setGender(rs.getString(5));
			pb.setAddress(rs.getString(6));
			
			list.add(pb);
		
		}
		con.close();
	} catch (SQLException e) {

		
		e.printStackTrace();
	}
	return list;
	
}

public ArrayList<Profilebean> getanswer(Profilebean pb) {
	
	Connection con=getConnection();
	ArrayList<Profilebean> list=new ArrayList<Profilebean>();
	try {
		PreparedStatement ps=con.prepareStatement("select q.Q_ID,q.QUESTION,c.COMMENTS,c.COMMENTBY from QUESTION_TABLE q,COMMENT_TABLE c where q.Q_ID=c.QID and q.Q_ID=?");
		ps.setInt(1, pb.getQ_id());
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			Profilebean pb1=new Profilebean();
			pb1.setQ_id(rs.getInt(1));
			pb1.setQuestion(rs.getString(2));
			//pb1.setAnswer(rs.getString(3));
			pb1.setComments(rs.getString(3));
			pb1.setLoginid(rs.getString(4));
			
			list.add(pb1);
		
		}
		con.close();
	} catch (SQLException e) {

		
		e.printStackTrace();
	}
	return list;
	
}

public ArrayList<Profilebean> viewQuestion() {
	Connection con=getConnection();
	ArrayList<Profilebean> list=new ArrayList<Profilebean>();
	try {
		//select q.QUESTION,q.POSTED_DATE,POSTEDBY,q.Q_ID from QUESTION_TABLE q,COMMENT_TABLE c where q.Q_ID = c.QID group by q.question ,q.POSTED_DATE,q.Q_ID
		PreparedStatement ps=con.prepareStatement("select Q_ID,QUESTION,POSTED_DATE,POSTEDBY,POSTEDID from QUESTION_TABLE");
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			Profilebean pb=new Profilebean();
			
			pb.setQ_id(rs.getInt(1));
			pb.setQuestion(rs.getString(2));
			pb.setPosteddate(rs.getString(3));
			pb.setPostedby(rs.getString(4));
			pb.setPostedid(rs.getString(5));
			
			list.add(pb);
			
			
		}
		con.close();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return list;
}
public ArrayList<Profilebean> getans(int qid){

Connection con=getConnection();
ArrayList<Profilebean> list=new ArrayList<Profilebean>();
try {
	//select CID,COMMENTS,COMMENTBY,COMMENTDATE,LIKES from COMMENT_TABLE  where QID=? order by likes desc
	
	PreparedStatement ps=con.prepareStatement("select CID,COMMENTS,COMMENTBY,COMMENTDATE,LIKES from COMMENT_TABLE  where QID=? order by likes desc");
	ps.setInt(1, qid);
	ResultSet rs=ps.executeQuery();
	while (rs.next()) {
		Profilebean pb=new Profilebean();
		pb.setCid(rs.getInt(1));
		pb.setComments(rs.getString(2));
		//pb.setAnswer(rs.getString(3));
		pb.setCommentby(rs.getString(3));
		pb.setCommentdate(rs.getString(4));
		pb.setLikes(rs.getInt(5));
		pb.setQ_id(qid);
		
		list.add(pb);
	
	}
	con.close();
} catch (SQLException e) {

	
	e.printStackTrace();
}
return list;

}

public int comments(Profilebean pb) {
	int i=0;
	int cid=0;
	Connection con=null;
	try{
		
		con=getConnection();
		System.out.println("connection>>>>>>>>>>>>"+con);
		PreparedStatement ps=con.prepareStatement("select max(CID) from COMMENT_TABLE");
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			cid=rs.getInt(1);
			cid=cid+1;
		}
		PreparedStatement pstmt=con.prepareStatement("insert into COMMENT_TABLE(CID,QID,COMMENTS,COMMENTBY,COMMENTDATE,USERID,LIKES) values(?,?,?,?,?,?,?)");
		
		pstmt.setInt(1, cid);
		pstmt.setInt(2, pb.getQ_id());
		pstmt.setString(3, pb.getComments());
		pstmt.setString(4, pb.getUsername());
		pstmt.setString(5, pb.getCommentdate());
		pstmt.setString(6, pb.getLoginid());
		pstmt.setInt(7, 0);
						
		i=pstmt.executeUpdate();
		 con.close();
	}
	catch (Exception e) {
     e.printStackTrace();
	}
	return i;
}
public ArrayList<Profilebean> getlikes(int qid1){

	Connection con=getConnection();
	ArrayList<Profilebean> list=new ArrayList<Profilebean>();
	try {
		PreparedStatement ps=con.prepareStatement("select count(QID),sum(LIKES) from COMMENT_TABLE  where QID=?");
		ps.setInt(1, qid1);
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			Profilebean pb=new Profilebean();
			pb.setCount(rs.getInt(1));
			pb.setLikes(rs.getInt(2));
			
			list.add(pb);
		
		}
		con.close();
	} catch (SQLException e) {

		
		e.printStackTrace();
	}
	return list;

	}

public int addLikess(int aid) {
	int i=0;
	int likes=0;
	Connection con=null;
	try{
		
		con=getConnection();
		System.out.println("connection>>>>>>>>>>>>"+con);
		PreparedStatement ps=con.prepareStatement("select max(LIKES) from COMMENT_TABLE where CID=?");
		ps.setInt(1, aid);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			likes=rs.getInt(1);
			likes=likes+1;
		}
		PreparedStatement pstmt=con.prepareStatement("update COMMENT_TABLE set LIKES=? where CID=?");
		
		pstmt.setInt(1, likes);
		pstmt.setInt(2, aid);
		i=pstmt.executeUpdate();
		 con.close();
	}
	catch (Exception e) {
     e.printStackTrace();
	}
	return i;
}
}
