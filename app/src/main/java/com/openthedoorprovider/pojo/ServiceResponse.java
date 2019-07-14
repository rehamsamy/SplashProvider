package com.openthedoorprovider.pojo;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class ServiceResponse{

	@SerializedName("services")
	private List<ServicesItem> services;

	@SerializedName("status")
	private boolean status;

	public void setServices(List<ServicesItem> services){
		this.services = services;
	}

	public List<ServicesItem> getServices(){
		return services;
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
			"ServiceResponse{" + 
			"services = '" + services + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}