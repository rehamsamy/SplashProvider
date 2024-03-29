package com.openthedoorprovider;

import android.Manifest;
import android.content.ClipData;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
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
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.fourhcode.forhutils.FUtilsValidation;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import gun0912.tedbottompicker.TedBottomPicker;
import io.reactivex.disposables.Disposable;

import static android.R.*;

public class SignUp3Activity extends AppCompatActivity {

    @BindView(R.id.continue_btn)
    MaterialButton continueBtn;
    @BindView(R.id.signup3_toolbar) Toolbar toolbar;
    @BindView(R.id.back_btn) ImageView backImage;
    @BindView(R.id.upload_image_img) ImageView uploadImage;
   // @BindView(R.id.image_recycler) RecyclerView imageRecycler;String[] filePathColumn;
    List<String> imageEncodedList;
    String imageEncoded;

    @BindView(R.id.image1)
    TextView imageView1;
    @BindView(R.id.image2) TextView imageView2;
    @BindView(R.id.image3) TextView imageView3;
    @BindView(R.id.delete1) ImageView deleteImage1;
    @BindView(R.id.delete2) ImageView deleteImage2;
    @BindView(R.id.delete3) ImageView deleteImage3;

    @BindView(R.id.username_input_layout) TextInputLayout userNameInput;
    @BindView(R.id.email_input_layout) TextInputLayout emailInput;
    String phone;

     Disposable singleImageDisposable;
  public static List<Uri> selectedUriList;
    private Uri selectedUri;
    private RequestManager requestManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up3);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Intent intent=getIntent();
         phone=intent.getStringExtra("phone");

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!FUtilsValidation.isEmpty(userNameInput.getEditText(),"please enter your name!")
                        &&!FUtilsValidation.isEmpty(emailInput.getEditText(),"please enter your name!")
                        && FUtilsValidation.isValidEmail(emailInput.getEditText(),"please enter valid email!")){

                    Intent intent1=new Intent(getApplicationContext(), SignUp4Activity.class);
                    intent1.putExtra("phone",phone);
                    intent1.putExtra("email",emailInput.getEditText().getText().toString());
                    intent1.putExtra("name",userNameInput.getEditText().getText().toString());
                     startActivity(intent1);
                }
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
           PermissionListener permissionlistener = new PermissionListener() {
                    @Override
                    public void onPermissionGranted() {
                        TedBottomPicker.with(SignUp3Activity.this)
                                .setPeekHeight(1600)
                                .setTitle("choose image")
                                .setCompleteButtonText("Done")
                                .setEmptySelectionText("No Selected")
                                .setSelectedUri(selectedUri)
                                .showMultiImage(uriList -> {
                                    selectedUriList = uriList;
                                    showUriList(uriList);
                                    imageView1.setVisibility(View.VISIBLE);
                                    imageView2.setVisibility(View.VISIBLE);
                                    imageView3.setVisibility(View.VISIBLE);
                                });

                    }

                    @Override
                    public void onPermissionDenied(ArrayList<String> deniedPermissions) {

                    }
                };


                checkPermission(permissionlistener);



            }
        });

    }

    private void checkPermission(PermissionListener permissionlistener) {

        TedPermission.with(SignUp3Activity.this)
                .setPermissionListener(permissionlistener)
                .setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
                .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .check();

    }

    private void showUriList(List<Uri> uriList) {
        selectedUriList=uriList;

        if(uriList.size()>3){
            Toast.makeText(getApplicationContext(),"you select more than 3 images",Toast.LENGTH_LONG).show();
        }
        else{
           deleteImage1.setVisibility(View.VISIBLE);
            imageView1.setText(uriList.get(0).getLastPathSegment());
            deleteImage2.setVisibility(View.VISIBLE);
            imageView2.setText(uriList.get(1).getLastPathSegment());
            deleteImage3.setVisibility(View.VISIBLE);
            imageView3.setText(uriList.get(2).getLastPathSegment());


          deleteImage1.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  imageView1.setVisibility(View.INVISIBLE);
              }
          });

            deleteImage2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imageView2.setVisibility(View.INVISIBLE);
                }
            });
            deleteImage3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   Uri uri= uriList.get(2);
                   uri=null;
                    imageView3.setVisibility(View.INVISIBLE);
                }
            });

        }




    }


}