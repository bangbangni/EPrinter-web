package ustc.sse.eprint.basicdao;

import java.util.List;

public interface BasicDaoInter {

	//���õķ���
	//1��id��ȡ��ȡ����    
	public  Object findById(Class clazz,java.io.Serializable id);
	//2����ѯ����hql��һϵ��
	public  List executeQueryList(String hql,Object []parameters);
	//3����ѯ����hql������
	public Object executeQueryUnique(String hql,Object []parameters);
	//4����ѯ��������ҳ
	public  List executeQueryByPage(String hql,Object []parameters,int pageSize,int pageNow);
	//5�����һ���û�
	public void add(Object obj);
	//6��ͳһ��ִ��hql��ɾ�����޸�
	public void executeQueryUpdate(String hql,Object []parameters);
	//7��������ҳ��
	public int queryPageCount(String hql, Object[] parameters, int pageSize);
	//8��ɾ��һ���û�
	public void deleteById(Class clazz,java.io.Serializable id);
	//9�����ݶ����������
	public void update(Object object);
}
