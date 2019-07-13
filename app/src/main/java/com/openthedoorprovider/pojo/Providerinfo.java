package com.openthedoorprovider.pojo;


import com.google.gson.annotations.SerializedName;


public class Providerinfo{

	@SerializedName("file_requier")
	private Object fileRequier;

	@SerializedName("phone")
	private String phone;

	@SerializedName("user_image")
	private Object userImage;

	@SerializedName("name")
	private String name;

	@SerializedName("active")
	private String active;

	@SerializedName("id")
	private int id;

	@SerializedName("email")
	private String email;

	public void setFileRequier(Object fileRequier){
		this.fileRequier = fileRequier;
	}

	public Object getFileRequier(){
		return fileRequier;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return phone;
	}

	public void setUserImage(Object userImage){
		this.userImage = userImage;
	}

	public Object getUserImage(){
		return userImage;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setActive(String active){
		this.active = active;
	}

	public String getActive(){
		return active;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"Providerinfo{" + 
			"file_requier = '" + fileRequier + '\'' + 
			",phone = '" + phone + '\'' + 
			",user_image = '" + userImage + '\'' + 
			",name = '" + name + '\'' + 
			",active = '" + active + '\'' + 
			",id = '" + id + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}