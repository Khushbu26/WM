package vo;

import java.io.Serializable;

public class SubcategoryVo implements Serializable {
	private int SubcategoryId;
	private String subcategoryName;
	private String subcategoryDes;
	private CategoryVo catRef;
	public int getSubcategoryId() {
		return SubcategoryId;
	}
	public void setSubcategoryId(int subcategoryId) {
		SubcategoryId = subcategoryId;
	}
	public String getSubcategoryName() {
		return subcategoryName;
	}
	public void setSubcategoryName(String subcategoryName) {
		this.subcategoryName = subcategoryName;
	}
	public String getSubcategoryDes() {
		return subcategoryDes;
	}
	public void setSubcategoryDes(String subcategoryDes) {
		this.subcategoryDes = subcategoryDes;
	}
	public CategoryVo getCatRef() {
		return catRef;
	}
	public void setCatRef(CategoryVo catRef) {
		this.catRef = catRef;
	}
	
}
