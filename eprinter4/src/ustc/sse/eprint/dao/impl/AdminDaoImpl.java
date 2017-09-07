package ustc.sse.eprint.dao.impl;

import java.io.Serializable;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import ustc.sse.eprint.basicdao.BasicDao;
import ustc.sse.eprint.dao.AdminDao;
import ustc.sse.eprint.domain.Admin;

@Repository
public class AdminDaoImpl extends BasicDao implements AdminDao {
	

	@Override
	public Admin getAdminById(Serializable id) {
		return null;

	}

	@Override
	public Admin getAdminByNamePw(String id, String password) {
		String hql="from Admin where emNumber=? and password=?";
		String[] parameters={id,password};
		Admin admin = (Admin)  this.executeQueryUnique(hql, parameters);
		return admin;
	}

	@Override
	public void modifyAdmin(Admin admin) {
		// TODO Auto-generated method stub
		this.update(admin);
	}

}
