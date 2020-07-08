package com.noida.authority.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.noida.authority.R;
import com.noida.authority.body_model.PropertyResponse;
import com.noida.authority.databinding.ActivityKyaDocumentUploadBinding;
import com.noida.authority.pojo.KyaCommunication;
import com.noida.authority.response_model.SaveResponse;
import com.noida.authority.retrofit.ApiManager;
import com.noida.authority.retrofit.ApiResponseInterface;
import com.noida.authority.utils.BaseActivity;
import com.noida.authority.utils.Constants;
import com.noida.authority.utils.GetPermission;
import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.util.FileUtils;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import static com.noida.authority.activity.LoginActivity.token;


public class KyaDocumentUpload extends BaseActivity implements ApiResponseInterface {

    Dialog dialogLayout;
    ApiManager apiManager;

    ActivityKyaDocumentUploadBinding binding;
    PropertyResponse propertyResponse;
    KyaCommunication kyaCommunication;
    private static final int PICK_IMAGE_GALLERY_REQUEST_CODE = 609;
    int maxWidth = 250, maxHeight = 250;
    File file;
    public static final int CAMERA_STORAGE_REQUEST_CODE = 611;
    public static final int ONLY_CAMERA_REQUEST_CODE = 612;
    public static final int ONLY_STORAGE_REQUEST_CODE = 613;
    private static final int CAMERA_ACTION_PICK_REQUEST_CODE = 610;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_kya_document_upload);
        binding.setClickHandler(new EventHandler(this));
        /*KyaDocument kyaDocument = new KyaDocument();
        kyaDocument.setIdType("15");
        binding.setKyaDocument(kyaDocument);*/

        dialogLayout = new Dialog(this, android.R.style.Theme_DeviceDefault_Light_NoActionBar);
        dialogLayout.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        apiManager = new ApiManager(this, this);

        if (getIntent().getExtras() != null) {

            if (getIntent().hasExtra("Type")) {

                if (getIntent().getExtras().getString("Type").equalsIgnoreCase("PropertyResponse")) {

                    propertyResponse = (PropertyResponse) getIntent().getSerializableExtra("data");
                    kyaCommunication = (KyaCommunication) getIntent().getSerializableExtra("dataCommunication");
                    if (propertyResponse != null) {

                        binding.setKyaInfo(propertyResponse);
                        binding.setKyaCommunication(kyaCommunication);

                    }
                }
            }
        }

        binding.attachIdProof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && new GetPermission().checkSelfPermissions(KyaDocumentUpload.this)) {
                    binding.txtIdProof.setText("");
                    callDialogForDoc();

                }
            }
        });
        binding.attachLetter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && new GetPermission().checkSelfPermissions(KyaDocumentUpload.this)) {
                    binding.txtLetter.setText("");

                    callDialogForDoc();

                }
            }
        });
        binding.attachOtherProof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && new GetPermission().checkSelfPermissions(KyaDocumentUpload.this)) {
                    binding.txtOtherProof.setText("");

                    callDialogForDoc();

                }
            }
        });
    }

    private void callDialogForDoc() {
        dialogLayout = new Dialog(KyaDocumentUpload.this, android.R.style.Theme_DeviceDefault_Light_NoActionBar);
        dialogLayout.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
        dialogLayout.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogLayout.setContentView(R.layout.activity_choose_pic);

        TextView txtHeadLine = dialogLayout.findViewById(R.id.txtHeadLine);
        txtHeadLine.setText("Choose file");
        ImageView imgCross = dialogLayout.findViewById(R.id.imgCross);
        LinearLayout llCamera = dialogLayout.findViewById(R.id.llCamera);
        llCamera.setVisibility(View.GONE);
        ImageView imgGallery = dialogLayout.findViewById(R.id.imgGallery);


        imgGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImagesDocument();
                dialogLayout.dismiss();
            }
        });

        imgCross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogLayout.dismiss();

            }
        });
        dialogLayout.show();

    }


    private void openImagesDocument() {
        Intent pictureIntent = new Intent(Intent.ACTION_GET_CONTENT);
        pictureIntent.setType("image/*");
        pictureIntent.addCategory(Intent.CATEGORY_OPENABLE);
        String[] mimeTypes = new String[]{"image/jpeg", "image/png"};
        pictureIntent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes);

        startActivityForResult(Intent.createChooser(pictureIntent, "Select Picture"), PICK_IMAGE_GALLERY_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_GALLERY_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            try {
                Uri sourceUri = data.getData();
                File file = getImageFile();
                Uri destinationUri = Uri.fromFile(file);

                showImage(sourceUri);
                // openCropActivity(sourceUri, destinationUri);
            } catch (Exception e) {
                Log.d("Exception :",e.getLocalizedMessage());
                Toast.makeText(this, "Please select another image", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void openCropActivity(Uri sourceUri, Uri destinationUri) {
        UCrop.of(sourceUri, destinationUri)
                .withMaxResultSize(maxWidth, maxHeight)
                .withAspectRatio(5f, 5f)
                .start(this);
    }


    private void showImage(Uri imageUri) {
        try {
            file = new File(FileUtils.getPath(this, imageUri));
            if (binding.txtIdProof.getText().toString().equalsIgnoreCase("")) {
                binding.txtIdProof.setText(file.getName());

            } else if (binding.txtLetter.getText().toString().equalsIgnoreCase("")) {
                binding.txtLetter.setText(file.getName());

            } else if (binding.txtOtherProof.getText().toString().equalsIgnoreCase("")) {
                binding.txtOtherProof.setText(file.getName());

            }
            // uploadPicture(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    String currentPhotoPath = "";

    private File getImageFile() {
        String imageFileName = "JPEG_" + System.currentTimeMillis() + "_";
        File storageDir = new File(
                Environment.getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_DCIM
                ), "Camera"
        );
        File file = null;
        try {
            file = File.createTempFile(
                    imageFileName, ".jpg", storageDir
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        currentPhotoPath = "file:" + file.getAbsolutePath();
        return file;
    }

    private void callDialog() {
        final Dialog dialogLayout = new Dialog(this);
        dialogLayout.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialogLayout.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        dialogLayout.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogLayout.setContentView(R.layout.otp_dialog);
        dialogLayout.show();

        Button performKya = dialogLayout.findViewById(R.id.submit_otp);
        performKya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KyaDocumentUpload.this, KyaDetails.class);
                startActivity(intent);

                dialogLayout.dismiss();
            }
        });
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CAMERA_STORAGE_REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED)
                //  uiHelper.showImagePickerDialog(this, this);
                Toast.makeText(this, "PERMISSION GRANTED", Toast.LENGTH_SHORT).show();
            else if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_DENIED) {
                Toast.makeText(this, "Need Storage access in order to update your profile picture.", Toast.LENGTH_SHORT).show();
            } else if (grantResults[0] == PackageManager.PERMISSION_DENIED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Need Camera access in order to update your profile picture.", Toast.LENGTH_SHORT).show();
            } else if (grantResults[0] == PackageManager.PERMISSION_DENIED && grantResults[1] == PackageManager.PERMISSION_DENIED) {
                Toast.makeText(this, "Need Camera access in order to update your profile picture.", Toast.LENGTH_SHORT).show();
            }

        } else if (requestCode == ONLY_CAMERA_REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
                //  uiHelper.showImagePickerDialog(this, this);
                Toast.makeText(this, "PERMISSION GRANTED", Toast.LENGTH_SHORT).show();
            else {
                Toast.makeText(this, "Need Camera access in order to update your profile picture.", Toast.LENGTH_SHORT).show();
            }
        } else if (requestCode == ONLY_STORAGE_REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
                Toast.makeText(this, "PERMISSION GRANTED", Toast.LENGTH_SHORT).show();
                //  uiHelper.showImagePickerDialog(this, this);
            else {
                Toast.makeText(this, "Need Storage access in order to update your profile picture.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void isError(String errorCode) {
        Toast.makeText(this, errorCode, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void isSuccess(Object response, int ServiceCode) {
        if (ServiceCode == Constants.SAVE_KYA_PROPERTY) {
            SaveResponse saveBean = (SaveResponse) response;
            if (saveBean.getMessage() != null) {
                Toast.makeText(this, saveBean.getMessage(), Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        }
    }


    private void callSaveAPi(File file) {

        if (file != null) {
            RequestBody requestBody = RequestBody.create(MediaType.parse("*/*"), file);
            MultipartBody.Part fileToUpload = MultipartBody.Part.createFormData("idfile", /*file.getName()*/"ID Proof", requestBody);
            MultipartBody.Part fileToUpload1 = MultipartBody.Part.createFormData("letterfile", /*file.getName()*/"Ownership Letter", requestBody);
            MultipartBody.Part fileToUpload2 = MultipartBody.Part.createFormData("letterfile", /*file.getName()*/"Other Proof", requestBody);

            apiManager.saveAllDoc("Bearer " + token, fileToUpload, fileToUpload1, fileToUpload2,
                    propertyResponse.getSectorName(),
                    propertyResponse.getBlockName(), propertyResponse.getPlotNo(), propertyResponse.getRegistrationId(),
                    propertyResponse.getApplicant(), propertyResponse.getApplicantAddress(),
                    propertyResponse.getGender(), propertyResponse.getDepartment(),
                    propertyResponse.getMobileNo(), propertyResponse.getEmailId(), propertyResponse.getPanNumber());

        }
    }

    public class EventHandler {
        Activity mContext;

        public EventHandler(Activity mContext) {
            this.mContext = mContext;
        }

        public void kyaDocumentUpload() {

            if (binding.checkbox.isChecked()) {
                callSaveAPi(file);

            } else {
                Toast.makeText(KyaDocumentUpload.this, "Accept Declaration Before Submit", Toast.LENGTH_LONG).show();
            }
        }
    }
}

/*          Letter to SDM head quater delhi 9643150027 = helpline*/