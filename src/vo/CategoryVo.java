package vo;

import java.io.Serializable;

public class CategoryVo implements Serializable{
private int categoryId;
private String categoryName;
private String categoryDes;

public int getCategoryId() {
	return categoryId;
}
public void setCategoryId(int categoryId) {
	this.categoryId = categoryId;
}
public String getCategoryName() {
	return categoryName;
}
public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}
public String getCategoryDes() {
	return categoryDes;
}  
public void setCategoryDes(String categoryDes) {
	this.categoryDes = categoryDes;
}
}
