package ustc.sse.eprint.domain;

import java.util.Set;

/**
 * Admin entity. @author MyEclipse Persistence Tools
 */
public class Admin extends AbstractAdmin implements java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = -783348473518120492L;

	/** default constructor */
	public Admin() {
	}

	/** minimal constructor */
	public Admin(String emNumber, String name, String password) {
		super(emNumber, name, password);
	}

	/** full constructor */
	public Admin(String emNumber, String name, String password, Set adminLogs) {
		super(emNumber, name, password, adminLogs);
	}

}
