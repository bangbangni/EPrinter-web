package ustc.sse.eprint.domain;

import java.sql.Timestamp;

/**
 * Files entity. @author MyEclipse Persistence Tools
 */
public class Files extends AbstractFiles implements java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = -6976370023319459919L;

	/** default constructor */
	public Files() {
	}

	/** full constructor */
	public Files(Printer printer, Employee employee, String fileName,
			String fileType, Timestamp uploadTime, Double fileSize,
			String filePath, Integer fileMark, Integer filePages,
			Integer fileState) {
		super(printer, employee, fileName, fileType, uploadTime, fileSize,
				filePath, fileMark, filePages, fileState);
	}

}
