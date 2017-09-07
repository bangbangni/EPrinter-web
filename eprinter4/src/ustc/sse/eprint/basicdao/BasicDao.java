package ustc.sse.eprint.basicdao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public  class BasicDao implements BasicDaoInter {
	

	static SessionFactory sessionFactory;
	public  void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public  Object findById(Class clazz, Serializable id) {
		return this.sessionFactory.getCurrentSession().get(clazz, id);
	}
	
	@Override
	public List executeQueryList(String hql, Object[] parameters) {
		Query query =sessionFactory.getCurrentSession().createQuery(hql);
		//先判断是否有参数要绑定
		if(parameters!=null&&parameters.length>0){
			for(int i=0;i<parameters.length;++i){
				query.setParameter(i, parameters[i]);
			}	
		}
	if(query.list().size()==0)
		return null;
	return query.list();
	}
	
	@Override
	public Object executeQueryUnique(String hql, Object[] parameters) {
		Query query =sessionFactory.getCurrentSession().createQuery(hql);
		//先判断是否有参数要绑定
		if(parameters!=null&&parameters.length>0){
			for(int i=0;i<parameters.length;++i){
				query.setParameter(i, parameters[i]);
			}	
		}
		return query.uniqueResult();
	}
	
	@Override
	public List executeQueryByPage(String hql, Object[] parameters,
			int pageSize, int pageNow) {
		Query query =sessionFactory.getCurrentSession().createQuery(hql);
		//先判断是否有参数要绑定
				if(parameters!=null&&parameters.length>0){
					for(int i=0;i<parameters.length;++i){
						query.setParameter(i, parameters[i]);
					}	
				}
				//体现分页
				query.setFirstResult((pageNow-1)*pageSize).setMaxResults(pageSize);
				return query.list();
	}
	
	@Override
	public void add(Object obj) {

		this.sessionFactory.getCurrentSession().save(obj);
	}
	
	@Override
	public void executeQueryUpdate(String hql, Object[] parameters) {
		Query query =sessionFactory.getCurrentSession().createQuery(hql);
		//先判断是否有参数要绑定
		if(parameters!=null&&parameters.length>0){
			for(int i=0;i<parameters.length;++i){
				query.setParameter(i, parameters[i]);
			}	
		}
		query.executeUpdate();
	 }

	@Override
	public int queryPageCount(String hql, Object[] parameters, int pageSize) {
		// TODO Auto-generated method stub
		Object obj=this.executeQueryUnique(hql, parameters);
		int rowCount=Integer.parseInt(obj.toString());
		return (rowCount-1)/pageSize+1;
	}

	@Override
	public void deleteById(Class clazz, Serializable id) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().delete(findById(clazz, id));
		
	}
	@Override
	public void update(Object object) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().update(object);
	}


}
