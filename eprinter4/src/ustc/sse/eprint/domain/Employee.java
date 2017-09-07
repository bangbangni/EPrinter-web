package ustc.sse.eprint.domain;

import java.sql.Timestamp;
import java.util.Set;

/**
 * Employee entity. @author MyEclipse Persistence Tools
 */
public class Employee extends AbstractEmployee implements java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = 3572105841056547573L;

	/** default constructor */
	public Employee() {
	}

	/** minimal constructor */
	public Employee(String emNumber, String emName, String password,
			Integer role, Integer isBlock, Double usedRoom, Double emRoom) {
		super(emNumber, emName, password, role, isBlock, usedRoom, emRoom);
	}

	/** full constructor */
	public Employee(String emNumber, String emName, String password,
			String email, Integer role, String teleNumber, Timestamp creteTime,
			Integer isBlock, Double usedRoom, Double emRoom, Set fileses,
			Set employeeLogs) {
		super(emNumber, emName, password, email, role, teleNumber, creteTime,
				isBlock, usedRoom, emRoom, fileses, employeeLogs);
	}

}
