package com.lore.dao;
import java.util.List;
import com.lore.model.Emp;
public interface IEmpDAO {
	public void close();
	public boolean insert(Emp bean);
	public boolean update(Emp bean);
	public boolean delete(int id);
	public  List<Emp> select();
	public Emp selectOne(int id);
	
}
