package ustc.sse.eprint.domain;

import java.sql.Timestamp;

/**
 * PrinterLog entity. @author MyEclipse Persistence Tools
 */
public class PrinterLog extends AbstractPrinterLog implements
		java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = -4409459368648443851L;

	/** default constructor */
	public PrinterLog() {
	}

	/** full constructor */
	public PrinterLog(Printer printer, Timestamp logTime, Integer errFlag,
			Integer printPages) {
		super(printer, logTime, errFlag, printPages);
	}

}
