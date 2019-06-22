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

public class EditProfileDataActivity extends AppCompatActivity {

    @BindView(R.id.back_btn) ImageView backImage;
    @BindView(R.id.edit_name) TextInputLayout editNameInput;
    @BindView(R.id.edit_email) TextInputLayout editEmailInput;
    @BindView(R.id.edit_phone) TextInputLayout editPhoneInput;
    @BindView(R.id.save_btn) TextInputLayout saveBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile_data);

        ButterKnife.bind(this);

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
                && FUtilsValidation.isPhone(editPhoneInput.getEditText().toString())
                        && FUtilsValidation.isValidEmail(editEmailInput.getEditText(),"please enter  valid email!")){

                }
            }
        });

    }
}
