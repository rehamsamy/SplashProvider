package com.openthedoorprovider.pojo;


import com.google.gson.annotations.SerializedName;


public class RegisterProviderResponse{

	@SerializedName("providerinfo")
	private Providerinfo providerinfo;

	@SerializedName("status")
	private boolean status;

	@SerializedName("token")
	private String token;

	public void setProviderinfo(Providerinfo providerinfo){
		this.providerinfo = providerinfo;
	}

	public Providerinfo getProviderinfo(){
		return providerinfo;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	public void setToken(String token){
		this.token = token;
	}

	public String getToken(){
		return token;
	}

	@Override
 	public String toString(){
		return 
			"RegisterProviderResponse{" + 
			"providerinfo = '" + providerinfo + '\'' + 
			",status = '" + status + '\'' + 
			",token = '" + token + '\'' + 
			"}";
		}
}