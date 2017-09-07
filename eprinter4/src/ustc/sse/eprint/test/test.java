package ustc.sse.eprint.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import ustc.sse.eprint.domain.Admin;



public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext ctx=new FileSystemXmlApplicationContext("/WebRoot/WEB-INF/applicationContext.xml");
		
		SessionFactory sessionFactory = (SessionFactory) ctx.getBean("sessionFactory");
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Admin admin = new Admin("111", "111", "111");
		session.save(admin);
		
		transaction.commit();
		session.close();
	}

}
