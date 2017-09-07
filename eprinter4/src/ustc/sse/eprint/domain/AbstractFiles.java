package ustc.sse.eprint.domain;

import java.sql.Timestamp;

/**
 * AbstractFiles entity provides the base persistence definition of the Files
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractFiles implements java.io.Serializable {

	// Fields

	private Integer id;
	private Printer printer;
	private Employee employee;
	private String fileName;
	private String fileType;
	private Timestamp uploadTime;
	private Double fileSize;
	private String filePath;
	private Integer fileMark;
	private Integer filePages;
	private Integer fileState;

	// Constructors

	/** default constructor */
	public AbstractFiles() {
	}

	/** full constructor */
	public AbstractFiles(Printer printer, Employee employee, String fileName,
			String fileType, Timestamp uploadTime, Double fileSize,
			String filePath, Integer fileMark, Integer filePages,
			Integer fileState) {
		this.printer = printer;
		this.employee = employee;
		this.fileName = fileName;
		this.fileType = fileType;
		this.uploadTime = uploadTime;
		this.fileSize = fileSize;
		this.filePath = filePath;
		this.fileMark = fileMark;
		this.filePages = filePages;
		this.fileState = fileState;
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

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return this.fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public Timestamp getUploadTime() {
		return this.uploadTime;
	}

	public void setUploadTime(Timestamp uploadTime) {
		this.uploadTime = uploadTime;
	}

	public Double getFileSize() {
		return this.fileSize;
	}

	public void setFileSize(Double fileSize) {
		this.fileSize = fileSize;
	}

	public String getFilePath() {
		return this.filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Integer getFileMark() {
		return this.fileMark;
	}

	public void setFileMark(Integer fileMark) {
		this.fileMark = fileMark;
	}

	public Integer getFilePages() {
		return this.filePages;
	}

	public void setFilePages(Integer filePages) {
		this.filePages = filePages;
	}

	public Integer getFileState() {
		return this.fileState;
	}

	public void setFileState(Integer fileState) {
		this.fileState = fileState;
	}

}