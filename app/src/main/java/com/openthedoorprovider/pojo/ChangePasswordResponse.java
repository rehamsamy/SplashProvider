package com.openthedoorprovider.pojo;


import com.google.gson.annotations.SerializedName;


public class ChangePasswordResponse{

	@SerializedName("messages")
	private String messages;

	@SerializedName("status")
	private boolean status;

	public void setMessages(String messages){
		this.messages = messages;
	}

	public String getMessages(){
		return messages;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"ChangePasswordResponse{" + 
			"messages = '" + messages + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}