package com.openthedoorprovider;

import android.content.ClipData;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.button.MaterialButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.fourhcode.forhutils.FUtilsValidation;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.R.*;

public class SignUp3Activity extends AppCompatActivity {

    @BindView(R.id.continue_btn)
    MaterialButton continueBtn;
    @BindView(R.id.signup3_toolbar) Toolbar toolbar;
    @BindView(R.id.back_btn) ImageView backImage;
    @BindView(R.id.upload_image_img) ImageView uploadImage;
    @BindView(R.id.image_recycler) RecyclerView imageRecycler;String[] filePathColumn;
    List<String> imageEncodedList;
    String imageEncoded;

    @BindView(R.id.username_input_layout) TextInputLayout userNameInput;
    @BindView(R.id.email_input_layout) TextInputLayout emailInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up3);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!FUtilsValidation.isEmpty(userNameInput.getEditText(),"please enter your name!")
                        &&!FUtilsValidation.isEmpty(emailInput.getEditText(),"please enter your name!")
                        && FUtilsValidation.isValidEmail(emailInput.getEditText(),"please enter valid email!")){

                startActivity(new Intent(getApplicationContext(), SignUp4Activity.class)); }
            }
        });

        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SignUp2Activity.class));
            }
        });


        uploadImage.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1);

            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == 1 && resultCode == RESULT_OK
                && null != data) {
            Uri imageUri = data.getData();
            filePathColumn = new String[]{MediaStore.Images.Media.DATA};
            imageEncodedList = new ArrayList<>();
            Cursor cursor = getContentResolver().query(imageUri, filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            imageEncoded = cursor.getString(columnIndex);

           // ArrayAdapter<String> adapter=new ArrayAdapter<String>(android.);

            cursor.close();


        } else if (data.getClipData() != null) {
            ClipData mClipData = data.getClipData();
            ArrayList<Uri> mArrayUri = new ArrayList<Uri>();
            for (int i = 0; i < mClipData.getItemCount(); i++) {

                ClipData.Item item = mClipData.getItemAt(i);
                Uri uri = item.getUri();
                mArrayUri.add(uri);
                // Get the cursor
                Cursor cursor = getContentResolver().query(uri, filePathColumn, null, null, null);
                // Move to first row
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                imageEncoded = cursor.getString(columnIndex);
                imageEncodedList.add(imageEncoded);
                cursor.close();

            }
            Log.v("LOG_TAG", "Selected Images" + mArrayUri.size());
        } else

        {
            Toast.makeText(this, "You haven't picked Image",
                    Toast.LENGTH_LONG).show();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }


}