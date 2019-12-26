package com.hand.frame.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Map;

public class ServiceData {
RetCode code = RetCode.Success;		// 操作结果
	
	Object bo = null; //返回的数据对象,在返回异常编码时,这个对象可设置详细的异常信息
	
	Map<String, Object> other = null;  //附加数据
	
	public static ServiceData success(Object bo){
		ServiceData serviceData = new ServiceData();
		serviceData.setCode(RetCode.Success);
		serviceData.setBo(bo);
		return serviceData;
	}
	
	/**
	 * 分页返回使用
	 * @param bo
	 * @param other
	 * @return
	 */
	public static ServiceData success(Object bo, Map<String, Object> other){
		ServiceData serviceData = new ServiceData();
		serviceData.setCode(RetCode.Success);
		serviceData.setBo(bo);
		serviceData.setOther(other);
		return serviceData;
	}
	
	public RetCode getCode() {
		return code;
	}


	public void setCode(RetCode code) 
	{
		this.code = code;
	}


	public Object getBo() {
		return bo;
	}


	public void setBo(Object bo) {
		this.bo = bo;
	}


	public Map<String, Object> getOther() {
		return other;
	}


	public void setOther(Map<String, Object> other) {
		this.other = other;
	}

	//返回编码
	@JsonFormat(shape = JsonFormat.Shape.OBJECT)
	public enum RetCode {
		Success("0000","Success"),
		ServerError("0001","Server Errror"),
		BusinessError("0002","Business Error");
		
		private final String code;
		private String msg;
		 
		public String getCode() {
			return code;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}
		
		//返回本地化的提示消息
		public String getMsg() {
			return msg;
		}

		//枚举类构造函数
		private RetCode(String code, String msg) {
		     this.code = code;
		     this.setMsg(this.msg);
		} 
	}
}
