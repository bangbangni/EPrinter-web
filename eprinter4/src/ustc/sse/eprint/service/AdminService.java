package ustc.sse.eprint.service;

import java.io.Serializable;

import ustc.sse.eprint.domain.Admin;
import ustc.sse.eprint.domain.Employee;

public interface AdminService {
	
	public Admin getAdmin(String id, String password);

}
