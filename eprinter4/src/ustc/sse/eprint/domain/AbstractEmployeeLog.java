package ustc.sse.eprint.domain;

import java.sql.Timestamp;

/**
 * AbstractEmployeeLog entity provides the base persistence definition of the
 * EmployeeLog entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractEmployeeLog implements Comparable, java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 4557434828319257254L;
	private Integer id;
	private Employee employee;
	private String ip;
	private Timestamp longinTime;

	// Constructors

	/** default constructor */
	public AbstractEmployeeLog() {
	}

	/** minimal constructor */
	public AbstractEmployeeLog(Employee employee) {
		this.employee = employee;
	}

	/** full constructor */
	public AbstractEmployeeLog(Employee employee, String ip,
			Timestamp longinTime) {
		this.employee = employee;
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

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
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
	
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		String time = ((AbstractEmployeeLog)o).longinTime.toString();
		return this.longinTime.toString().compareTo(time);
	}

}