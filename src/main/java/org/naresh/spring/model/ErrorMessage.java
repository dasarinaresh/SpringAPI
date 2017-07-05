package org.naresh.spring.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="ProductsError",description="Service Error")
public class ErrorMessage {

	@ApiModelProperty(value="HTTP Status Code",required=true)
	private int statusCode;
	
	@ApiModelProperty(value="HTTP Status Message",required=true)
	private String statusMsg;
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusMsg() {
		return statusMsg;
	}
	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
	}
}
