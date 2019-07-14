package com.openthedoorprovider.pojo;


import com.google.gson.annotations.SerializedName;


public class ServicesItem{

	@SerializedName("service_name_en")
	private String serviceNameEn;

	@SerializedName("service_name_ar")
	private String serviceNameAr;

	@SerializedName("id")
	private int id;

	public void setServiceNameEn(String serviceNameEn){
		this.serviceNameEn = serviceNameEn;
	}

	public String getServiceNameEn(){
		return serviceNameEn;
	}

	public void setServiceNameAr(String serviceNameAr){
		this.serviceNameAr = serviceNameAr;
	}

	public String getServiceNameAr(){
		return serviceNameAr;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"ServicesItem{" + 
			"service_name_en = '" + serviceNameEn + '\'' + 
			",service_name_ar = '" + serviceNameAr + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}