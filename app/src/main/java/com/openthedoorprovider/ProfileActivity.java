package com.openthedoorprovider;

import android.content.Intent;
import android.support.design.button.MaterialButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.openthedoorprovider.pojo.LoginResponse;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileActivity extends AppCompatActivity {

    @BindView(R.id.profile_toolbar) Toolbar toolbar;
    @BindView(R.id.change_password_btn) MaterialButton changePasswordBtn;
    @BindView(R.id.edit_profile_btn) MaterialButton editProfileBtn;
    @BindView(R.id.service_setting_btn) MaterialButton serviceSettingBtn;
    @BindView(R.id.back_btn) ImageView backImage;
    @BindView(R.id.user_name) TextView userName;
    @BindView(R.id.user_email) TextView userEmail;
    @BindView(R.id.user_phone) TextView userPhone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ButterKnife.bind(this);

        LoginResponse response = SignInActivity.loginResponse;
        userName.setText(response.getProviderinfo().getName());
        userEmail.setText(response.getProviderinfo().getEmail());
        userPhone.setText(response.getProviderinfo().getPhone());

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        changePasswordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ChangePasswordActivity.class));
            }
        });


        editProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),EditProfileDataActivity.class));
            }
        });

        serviceSettingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ServiceSettingActivity.class));
            }
        });


        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),HomeActivity.class));
            }
        });

    }
}
