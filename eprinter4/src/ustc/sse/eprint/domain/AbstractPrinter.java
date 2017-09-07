package ustc.sse.eprint.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractPrinter entity provides the base persistence definition of the
 * Printer entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractPrinter implements java.io.Serializable {

	// Fields

	private Integer id;
	private String priNumber;
	private String priLocal;
	private Integer priState;
	private String priIp;
	private String priName;
	private Set fileses = new HashSet(0);
	private Set printerLogs = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractPrinter() {
	}
	
	public AbstractPrinter(String priNumber, String priLocal, Integer priState,
			String priIp, String priName) {
		this.priNumber = priNumber;
		this.priLocal = priLocal;
		this.priState = priState;
		this.priIp = priIp;
		this.priName = priName;
	}

	/** full constructor */
	public AbstractPrinter(String priNumber, String priLocal, Integer priState,
			String priIp, String priName, Set fileses, Set printerLogs) {
		this.priNumber = priNumber;
		this.priLocal = priLocal;
		this.priState = priState;
		this.priIp = priIp;
		this.priName = priName;
		this.fileses = fileses;
		this.printerLogs = printerLogs;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPriNumber() {
		return this.priNumber;
	}

	public void setPriNumber(String priNumber) {
		this.priNumber = priNumber;
	}

	public String getPriLocal() {
		return this.priLocal;
	}

	public void setPriLocal(String priLocal) {
		this.priLocal = priLocal;
	}

	public Integer getPriState() {
		return this.priState;
	}

	public void setPriState(Integer priState) {
		this.priState = priState;
	}

	public String getPriIp() {
		return this.priIp;
	}

	public void setPriIp(String priIp) {
		this.priIp = priIp;
	}

	public String getPriName() {
		return this.priName;
	}

	public void setPriName(String priName) {
		this.priName = priName;
	}

	public Set getFileses() {
		return this.fileses;
	}

	public void setFileses(Set fileses) {
		this.fileses = fileses;
	}

	public Set getPrinterLogs() {
		return this.printerLogs;
	}

	public void setPrinterLogs(Set printerLogs) {
		this.printerLogs = printerLogs;
	}

}