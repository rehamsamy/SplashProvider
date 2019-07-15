package com.openthedoorprovider.pojo;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class NotificationResponse{

	@SerializedName("Providernotfication")
	private List<ProvidernotficationItem> providernotfication;

	@SerializedName("status")
	private boolean status;

	public void setProvidernotfication(List<ProvidernotficationItem> providernotfication){
		this.providernotfication = providernotfication;
	}

	public List<ProvidernotficationItem> getProvidernotfication(){
		return providernotfication;
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
			"NotificationResponse{" + 
			"providernotfication = '" + providernotfication + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}