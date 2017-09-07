package ustc.sse.eprint.domain;

import java.sql.Timestamp;

/**
 * AbstractPrinterLog entity provides the base persistence definition of the
 * PrinterLog entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractPrinterLog implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -7248641710251471900L;
	private Integer id;
	private Printer printer;
	private Timestamp logTime;
	private Integer errFlag;
	private Integer printPages;

	// Constructors

	/** default constructor */
	public AbstractPrinterLog() {
	}

	/** full constructor */
	public AbstractPrinterLog(Printer printer, Timestamp logTime,
			Integer errFlag, Integer printPages) {
		this.printer = printer;
		this.logTime = logTime;
		this.errFlag = errFlag;
		this.printPages = printPages;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Printer getPrinter() {
		return this.printer;
	}

	public void setPrinter(Printer printer) {
		this.printer = printer;
	}

	public Timestamp getLogTime() {
		return this.logTime;
	}

	public void setLogTime(Timestamp logTime) {
		this.logTime = logTime;
	}

	public Integer getErrFlag() {
		return this.errFlag;
	}

	public void setErrFlag(Integer errFlag) {
		this.errFlag = errFlag;
	}

	public Integer getPrintPages() {
		return this.printPages;
	}

	public void setPrintPages(Integer printPages) {
		this.printPages = printPages;
	}

}