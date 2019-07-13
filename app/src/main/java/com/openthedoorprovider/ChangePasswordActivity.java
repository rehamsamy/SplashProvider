package com.openthedoorprovider;

import android.content.Intent;
import android.support.design.button.MaterialButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.fourhcode.forhutils.FUtilsValidation;
import com.openthedoorprovider.pojo.ChangePasswordResponse;
import com.openthedoorprovider.utils.RetrofitClientInstance;
import com.openthedoorprovider.utils.RetrofitInterface;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChangePasswordActivity extends AppCompatActivity {

    private static final String TAG ="ChangePasswordActivity" ;
    @BindView(R.id.back_btn) ImageView backImage;
    @BindView(R.id.old_password) TextInputLayout oldPasswordInput;
    @BindView(R.id.new_password) TextInputLayout newPasswordInput;
    @BindView(R.id.confirm_new_password) TextInputLayout confirmPasswordInput;

    @BindView(R.id.change_password_btn) MaterialButton changePasswordBtn;
    RetrofitInterface retrofitInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        ButterKnife.bind(this);
        retrofitInterface= RetrofitClientInstance.getRetrofitInstance();

        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
            }
        });


        changePasswordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!FUtilsValidation.isEmpty(oldPasswordInput.getEditText(),"please enter your password!")
                        &&!FUtilsValidation.isEmpty(newPasswordInput.getEditText(),"please enter your new password!")
                        && !FUtilsValidation.isEmpty(confirmPasswordInput.getEditText(),"please enter your confirm password!")
                        && FUtilsValidation.isPasswordEqual(newPasswordInput.getEditText(),confirmPasswordInput.getEditText(),"your password not matched !")) {

                    changePassword();

                }
            }
        });



    }

    private void changePassword() {
        Map<String,Object> map=new HashMap<>();
        map.put("user_id", SignInActivity.loginResponse.getProviderinfo().getId());
        map.put("current_password",oldPasswordInput.getEditText().getText().toString());
        map.put("password",newPasswordInput.getEditText().getText().toString());
        map.put("password_confirmation",confirmPasswordInput.getEditText().getText().toString());
        map.put("api_token",SignInActivity.loginResponse.getToken());

      Call<ChangePasswordResponse> call= retrofitInterface.changePassword(map);
      call.enqueue(new Callback<ChangePasswordResponse>() {
          @Override
          public void onResponse(Call<ChangePasswordResponse> call, Response<ChangePasswordResponse> response) {
              Toast.makeText(getApplicationContext(),response.body().getMessages(),Toast.LENGTH_LONG).show();
              Log.v(TAG,response.body().toString());
          }

          @Override
          public void onFailure(Call<ChangePasswordResponse> call, Throwable t) {
              Log.v(TAG,t.getMessage().toString());
          }
      });
    }
}
