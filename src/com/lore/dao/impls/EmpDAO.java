package com.lore.dao.impls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lore.dao.IEmpDAO;
import com.lore.db.DBUtil;
import com.lore.model.Emp;

public class EmpDAO implements IEmpDAO{
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	public void close() {
		try{
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(conn!=null && !conn.isClosed()) conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean insert(Emp bean) {
		String sql ="insert into emp(name,sex,birthday,phone,addr,job) values(?,?,?,?,?,?)";
		try {		
			this.conn=DBUtil.getConnection();
			this.ps=this.conn.prepareStatement(sql);
			this.ps.setString(1,bean.getName());
			this.ps.setString(2, bean.getSex());
			this.ps.setString(3, bean.getBirthday());
			this.ps.setString(4, bean.getPhone());
			this.ps.setString(5, bean.getAddr());
			this.ps.setString(6, bean.getJob());
			if(this.ps.executeUpdate()>0) {
				return true;
			}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				this.close();
			}
			return false;
	}

	@Override
	public boolean update(Emp bean) {
		String sql ="update emp set name=?,sex=?,birthday=?,phone=?,addr=?,job=? where id=?";
		try {		
			this.conn=DBUtil.getConnection();
			this.ps=this.conn.prepareStatement(sql);
			this.ps.setString(1,bean.getName());
			this.ps.setString(2, bean.getSex());
			this.ps.setString(3, bean.getBirthday());
			this.ps.setString(4, bean.getPhone());
			this.ps.setString(5, bean.getAddr());
			this.ps.setString(6, bean.getJob());
			this.ps.setInt(7, bean.getId());
			if(this.ps.executeUpdate()>0) {
				return true;
			}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				this.close();
			}
		return false;
	}

	@Override
	public boolean delete(int id) {
		String sql ="update emp set status=-1 where id=?";
		try {		
			this.conn=DBUtil.getConnection();
			this.ps=this.conn.prepareStatement(sql);
			this.ps.setInt(1,id);
			if(this.ps.executeUpdate()>0) {
				return true;
			}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				this.close();
			}
		return false;
	}

	@Override
	public List<Emp> select() {
		String sql ="select * from emp where status!=-1 order by id desc";
		List<Emp> beans = new ArrayList<Emp>();
		try {		
			this.conn=DBUtil.getConnection();
			this.ps=this.conn.prepareStatement(sql);
			this.rs=this.ps.executeQuery();
			while(this.rs.next()) {
				Emp bean =new Emp();
				bean.setId(rs.getInt("id"));
				bean.setName(rs.getString("name"));
				bean.setSex(rs.getString("sex"));
				bean.setAddr(rs.getString("addr"));
				bean.setPhone(rs.getString("phone"));
				bean.setBirthday(rs.getString("birthday"));
				bean.setJob(rs.getString("job"));
				bean.setStatus(rs.getInt("status"));
				beans.add(bean);
			}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				this.close();
			}
		return beans;
	}

	@Override
	public Emp selectOne(int id) {
		String sql ="select * from emp where id=?";
		Emp bean =null;
		try {		
			this.conn=DBUtil.getConnection();
			this.ps=this.conn.prepareStatement(sql);
			this.ps.setInt(1,id);
			this.rs=this.ps.executeQuery();
			if(this.rs.next()) {
				bean =new Emp();
				bean.setId(rs.getInt("id"));
				bean.setName(rs.getString("name"));
				bean.setSex(rs.getString("sex"));
				bean.setAddr(rs.getString("addr"));
				bean.setBirthday(rs.getString("birthday"));
				bean.setJob(rs.getString("job"));
				bean.setStatus(rs.getInt("status"));
			}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				this.close();
			}
		return null;
	}
	
}
