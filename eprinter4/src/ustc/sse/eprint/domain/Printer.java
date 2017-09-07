package ustc.sse.eprint.domain;

import java.util.Set;

/**
 * Printer entity. @author MyEclipse Persistence Tools
 */
public class Printer extends AbstractPrinter implements java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = -3118483981382795271L;

	/** default constructor */
	public Printer() {
	}

	/** minimal constructor */
	public Printer(String priNumber, String priLocal, Integer priState,
			String priIp,String priName) {
		super(priNumber, priLocal, priState, priIp,priName);
	}

	/** full constructor */
	public Printer(String priNumber, String priLocal, Integer priState,
			Set fileses, String priIp,String priName, Set printerLogs) {
		super(priNumber, priLocal, priState, priIp,priName, fileses, printerLogs);
	}

}
