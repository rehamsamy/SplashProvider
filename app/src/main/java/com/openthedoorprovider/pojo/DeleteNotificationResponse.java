package com.openthedoorprovider.pojo;

import com.google.gson.annotations.SerializedName;

public class DeleteNotificationResponse {
    @SerializedName("SuccessMsg")
    private String successMsg;

    public void setSuccessMsg(String successMsg){
        this.successMsg = successMsg;
    }

    public String getSuccessMsg(){
        return successMsg;
    }

    @Override
    public String toString(){
        return
                "DeleteNotificatioResponse{" +
                        "successMsg = '" + successMsg + '\'' +
                        "}";
    }

}
