package com.openthedoorprovider.pojo;


import com.google.gson.annotations.SerializedName;

public class ProvidernotficationItem{

	@SerializedName("provider_notf_en")
	private String providerNotfEn;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("provider_id")
	private int providerId;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("provider_notf_ar")
	private String providerNotfAr;

	@SerializedName("id")
	private int id;

	@SerializedName("provider_notf_link")
	private String providerNotfLink;

	public void setProviderNotfEn(String providerNotfEn){
		this.providerNotfEn = providerNotfEn;
	}

	public String getProviderNotfEn(){
		return providerNotfEn;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setProviderId(int providerId){
		this.providerId = providerId;
	}

	public int getProviderId(){
		return providerId;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setProviderNotfAr(String providerNotfAr){
		this.providerNotfAr = providerNotfAr;
	}

	public String getProviderNotfAr(){
		return providerNotfAr;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setProviderNotfLink(String providerNotfLink){
		this.providerNotfLink = providerNotfLink;
	}

	public String getProviderNotfLink(){
		return providerNotfLink;
	}

	@Override
 	public String toString(){
		return 
			"ProvidernotficationItem{" + 
			"provider_notf_en = '" + providerNotfEn + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",provider_id = '" + providerId + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",provider_notf_ar = '" + providerNotfAr + '\'' + 
			",id = '" + id + '\'' + 
			",provider_notf_link = '" + providerNotfLink + '\'' + 
			"}";
		}
}