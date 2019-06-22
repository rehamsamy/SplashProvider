package com.openthedoorprovider;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.fourhcode.forhutils.FUtilsValidation;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChangePasswordActivity extends AppCompatActivity {

    @BindView(R.id.back_btn) ImageView backImage;
    @BindView(R.id.old_password) TextInputLayout oldPasswordInput;
    @BindView(R.id.new_password) TextInputLayout newPasswordInput;
    @BindView(R.id.confirm_new_password) TextInputLayout confirmPasswordInput;

    @BindView(R.id.change_password_btn) TextInputLayout changePasswordBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        ButterKnife.bind(this);

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

                }
            }
        });



    }
}
