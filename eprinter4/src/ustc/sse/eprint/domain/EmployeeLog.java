package ustc.sse.eprint.domain;

import java.sql.Timestamp;

/**
 * EmployeeLog entity. @author MyEclipse Persistence Tools
 */
public class EmployeeLog extends AbstractEmployeeLog implements 
		java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = -8644242979059318773L;

	/** default constructor */
	public EmployeeLog() {
	}

	/** minimal constructor */
	public EmployeeLog(Employee employee) {
		super(employee);
	}

	/** full constructor */
	public EmployeeLog(Employee employee, String ip, Timestamp longinTime) {
		super(employee, ip, longinTime);
	}





}
