package ustc.sse.eprint.domain;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * AbstractEmployee entity provides the base persistence definition of the
 * Employee entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractEmployee implements java.io.Serializable {

	// Fields

	@Override
	public String toString() {
		return "AbstractEmployee [id=" + id + ", emNumber=" + emNumber
				+ ", emName=" + emName + ", password=" + password + ", email="
				+ email + ", role=" + role + ", teleNumber=" + teleNumber
				+ ", creteTime=" + creteTime + ", isBlock=" + isBlock
				+ ", usedRoom=" + usedRoom + ", emRoom=" + emRoom
				+ ", fileses=" + fileses + ", employeeLogs=" + employeeLogs
				+ "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -6717637435767271827L;
	private Integer id;
	private String emNumber;
	private String emName;
	private String password;
	private String email;
	private Integer role;
	private String teleNumber;
	private Timestamp creteTime;
	private Integer isBlock;
	private Double usedRoom;
	private Double emRoom;
	private Set fileses = new HashSet(0);
	private Set employeeLogs = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractEmployee() {
	}

	/** minimal constructor */
	public AbstractEmployee(String emNumber, String emName, String password,
			Integer role, Integer isBlock, Double usedRoom, Double emRoom) {
		this.emNumber = emNumber;
		this.emName = emName;
		this.password = password;
		this.role = role;
		this.isBlock = isBlock;
		this.usedRoom = usedRoom;
		this.emRoom = emRoom;
	}

	/** full constructor */
	public AbstractEmployee(String emNumber, String emName, String password,
			String email, Integer role, String teleNumber, Timestamp creteTime,
			Integer isBlock, Double usedRoom, Double emRoom, Set fileses,
			Set employeeLogs) {
		this.emNumber = emNumber;
		this.emName = emName;
		this.password = password;
		this.email = email;
		this.role = role;
		this.teleNumber = teleNumber;
		this.creteTime = creteTime;
		this.isBlock = isBlock;
		this.usedRoom = usedRoom;
		this.emRoom = emRoom;
		this.fileses = fileses;
		this.employeeLogs = employeeLogs;
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

	public String getEmName() {
		return this.emName;
	}

	public void setEmName(String emName) {
		this.emName = emName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getRole() {
		return this.role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public String getTeleNumber() {
		return this.teleNumber;
	}

	public void setTeleNumber(String teleNumber) {
		this.teleNumber = teleNumber;
	}

	public Timestamp getCreteTime() {
		return this.creteTime;
	}

	public void setCreteTime(Timestamp creteTime) {
		this.creteTime = creteTime;
	}

	public Integer getIsBlock() {
		return this.isBlock;
	}

	public void setIsBlock(Integer isBlock) {
		this.isBlock = isBlock;
	}

	public Double getUsedRoom() {
		return this.usedRoom;
	}

	public void setUsedRoom(Double usedRoom) {
		this.usedRoom = usedRoom;
	}

	public Double getEmRoom() {
		return this.emRoom;
	}

	public void setEmRoom(Double emRoom) {
		this.emRoom = emRoom;
	}

	public Set getFileses() {
		return this.fileses;
	}

	public void setFileses(Set fileses) {
		this.fileses = fileses;
	}

	public Set getEmployeeLogs() {
		return this.employeeLogs;
	}

	public void setEmployeeLogs(Set employeeLogs) {
		this.employeeLogs = employeeLogs;
	}

}