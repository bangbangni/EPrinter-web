package ustc.sse.eprint.basicdao;

import java.util.List;

public interface BasicDaoInter {

	//常用的方法
	//1、id获取获取对象    
	public  Object findById(Class clazz,java.io.Serializable id);
	//2、查询方法hql，一系列
	public  List executeQueryList(String hql,Object []parameters);
	//3、查询方法hql，单个
	public Object executeQueryUnique(String hql,Object []parameters);
	//4、查询方法带分页
	public  List executeQueryByPage(String hql,Object []parameters,int pageSize,int pageNow);
	//5、添加一个用户
	public void add(Object obj);
	//6、统一的执行hql的删除与修改
	public void executeQueryUpdate(String hql,Object []parameters);
	//7、返回总页数
	public int queryPageCount(String hql, Object[] parameters, int pageSize);
	//8、删除一个用户
	public void deleteById(Class clazz,java.io.Serializable id);
	//9、根据对象更新数据
	public void update(Object object);
}
