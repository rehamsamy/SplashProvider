package com.openthedoorprovider;

import android.content.Intent;
import android.support.design.button.MaterialButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.fourhcode.forhutils.FUtilsValidation;
import com.openthedoorprovider.pojo.LoginResponse;
import com.openthedoorprovider.pojo.UpdateProfileResponse;
import com.openthedoorprovider.utils.RetrofitClientInstance;
import com.openthedoorprovider.utils.RetrofitInterface;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Callback;
import retrofit2.Response;

public class EditProfileDataActivity extends AppCompatActivity {

    private static final String TAG ="EditProfileDataActivity" ;
    @BindView(R.id.back_btn) ImageView backImage;
    @BindView(R.id.edit_name) TextInputLayout editNameInput;
    @BindView(R.id.edit_email) TextInputLayout editEmailInput;
    @BindView(R.id.edit_phone) TextInputLayout editPhoneInput;
    @BindView(R.id.save_btn)
    MaterialButton saveBtn;
    RetrofitInterface retrofitInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile_data);

        ButterKnife.bind(this);

        retrofitInterface= RetrofitClientInstance.getRetrofitInstance();
        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
            }
        });


        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!FUtilsValidation.isEmpty(editEmailInput.getEditText(),"please enter your email!")
                && !FUtilsValidation.isEmpty(editNameInput.getEditText(),"please enter your name!")
                &&!FUtilsValidation.isEmpty(editPhoneInput.getEditText(),"please enter your phone!")
                        && FUtilsValidation.isValidEmail(editEmailInput.getEditText(),"please enter  valid email!")){

                    updateProfile();
                }
            }
        });

    }

    private void updateProfile() {
        Map<String,Object> map=new HashMap<>();
        map.put("name",editNameInput.getEditText().getText().toString());
        map.put("email",editEmailInput.getEditText().getText().toString());
        map.put("phone",editPhoneInput.getEditText().getText().toString());
        map.put("user_id", SignInActivity.loginResponse.getProviderinfo().getId());
        map.put("gender","male");
        map.put("citizen","citizen");
        map.put("employee","employee");
        map.put("residentnumberorstatuscard","residentnumberorstatuscard");
        map.put("placeofemployment","placeofemployment");
        map.put("api_token",SignInActivity.loginResponse.getToken());
        map.put("birthdate","2019-07-02");

       retrofit2.Call<UpdateProfileResponse> call= retrofitInterface.updateProfile(map);
       call.enqueue(new Callback<UpdateProfileResponse>() {
           @Override
           public void onResponse(retrofit2.Call<UpdateProfileResponse> call, Response<UpdateProfileResponse> response) {
               Log.v(TAG,response.body().toString());
               Toast.makeText(getApplicationContext(),"data is changed",Toast.LENGTH_LONG).show();
               editEmailInput.getEditText().setText("");
               editNameInput.getEditText().setText(" ");
               editPhoneInput.getEditText().setText("");

           }

           @Override
           public void onFailure(retrofit2.Call<UpdateProfileResponse> call, Throwable t) {
               Log.v(TAG,t.getMessage().toString());
           }
       });

    }
}
