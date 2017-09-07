package ustc.sse.eprint.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractAdmin entity provides the base persistence definition of the Admin
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractAdmin implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 3164541112374559030L;
	private Integer id;
	private String emNumber;
	private String name;
	private String password;
	private Set adminLogs = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractAdmin() {
	}

	/** minimal constructor */
	public AbstractAdmin(String emNumber, String name, String password) {
		this.emNumber = emNumber;
		this.name = name;
		this.password = password;
	}

	/** full constructor */
	public AbstractAdmin(String emNumber, String name, String password,
			Set adminLogs) {
		this.emNumber = emNumber;
		this.name = name;
		this.password = password;
		this.adminLogs = adminLogs;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmNumber() {
		return this.emNumber;
	}

	public void setEmNumber(String emNumber) {
		this.emNumber = emNumber;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set getAdminLogs() {
		return this.adminLogs;
	}

	public void setAdminLogs(Set adminLogs) {
		this.adminLogs = adminLogs;
	}

}