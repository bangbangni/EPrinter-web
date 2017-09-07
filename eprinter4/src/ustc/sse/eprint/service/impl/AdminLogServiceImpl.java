package ustc.sse.eprint.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ustc.sse.eprint.basicdao.BasicDaoInter;
import ustc.sse.eprint.domain.AdminLog;
import ustc.sse.eprint.service.AdminLogService;

@Service
public class AdminLogServiceImpl implements AdminLogService {

	@Autowired
	BasicDaoInter basicDao;
	@Override
	public void addAdminLog(AdminLog adminLog) {
		// TODO Auto-generated method stub
		basicDao.add(adminLog);
	}

}
