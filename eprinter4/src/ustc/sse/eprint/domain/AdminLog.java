package ustc.sse.eprint.domain;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

/**
 * AdminLog entity. @author MyEclipse Persistence Tools
 */
@Component
public class AdminLog extends AbstractAdminLog implements java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = 8349863285628171771L;

	/** default constructor */
	public AdminLog() {
	}

	/** full constructor */
	public AdminLog(Admin admin, String ip, Timestamp longinTime) {
		super(admin, ip, longinTime);
	}

}
