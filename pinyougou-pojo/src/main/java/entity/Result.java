package entity;

import java.io.Serializable;

public class Result implements Serializable {

	private String message;//返回信息
	
	private boolean success;//是否成功

	public Result(String message, boolean success) {
		super();
		this.message = message;
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	
	
}
