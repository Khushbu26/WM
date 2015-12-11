package vo;

import java.io.Serializable;

/*import vo.C_Reg_VO;*/
import vo.WasteInfoVo;

public class UFileUploadVo implements Serializable{

	private int fileUploadId;
	private String fileName;
	private String filePath;	
	private WasteInfoVo wasteInfoRef;
	public int getFileUploadId() {
		return fileUploadId;
	}
	public void setFileUploadId(int fileUploadId) {
		this.fileUploadId = fileUploadId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public WasteInfoVo getWasteInfoRef() {
		return wasteInfoRef;
	}
	public void setWasteInfoRef(WasteInfoVo wasteInfoRef) {
		this.wasteInfoRef = wasteInfoRef;
	}
	
	
	
}
