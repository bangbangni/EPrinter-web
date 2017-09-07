package ustc.sse.eprint.domain;

import java.sql.Timestamp;

/**
 * AbstractAdminLog entity provides the base persistence definition of the
 * AdminLog entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractAdminLog implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -2011038014650635576L;
	private Integer id;
	private Admin admin;
	private String ip;
	private Timestamp longinTime;

	// Constructors

	/** default constructor */
	public AbstractAdminLog() {
	}

	/** full constructor */
	public AbstractAdminLog(Admin admin, String ip, Timestamp longinTime) {
		this.admin = admin;
		this.ip = ip;
		this.longinTime = longinTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Admin getAdmin() {
		return this.admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Timestamp getLonginTime() {
		return this.longinTime;
	}

	public void setLonginTime(Timestamp longinTime) {
		this.longinTime = longinTime;
	}

}