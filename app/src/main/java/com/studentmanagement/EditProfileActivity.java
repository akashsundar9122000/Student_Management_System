package com.studentmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import de.hdodenhof.circleimageview.CircleImageView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.studentmanagement.Models.Student;
import com.theartofdev.edmodo.cropper.CropImage;

import java.util.HashMap;

public class EditProfileActivity extends AppCompatActivity {

    private TextView email_id,register_number,cgpa,gender, qualification,year_of_passing,current_year
            ,institution,standing_arrear,history_of_arrear;

    private TextInputEditText  first_name,last_name,phone_number,father_name,mother_name,date_of_birth,address,
    city,state,pincode;

    private FloatingActionButton save;
    private ImageButton change_profile_image;

    private CircleImageView profile_image;

    private FirebaseUser mFirebaseUser;
    private String mCurrentUserId;
    private Uri mImageUri;
    private StorageTask mUploadTask;
    private StorageReference mProfileImageStorage;
    private DatabaseReference mUsersDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        mFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        mCurrentUserId = mFirebaseUser.getUid();
        mProfileImageStorage = FirebaseStorage.getInstance().getReference("profile_images");

        mUsersDatabase = FirebaseDatabase.getInstance().getReference("Student").child(mCurrentUserId);
        mUsersDatabase.keepSynced(true);


        first_name=findViewById(R.id.first_name);
        last_name=findViewById(R.id.last_name);

        phone_number=findViewById(R.id.phone);
        father_name=findViewById(R.id.father);
        mother_name=findViewById(R.id.mother);
        date_of_birth=findViewById(R.id.dob);
        cgpa=findViewById(R.id.cgpa);
        gender=findViewById(R.id.gender);
        address=findViewById(R.id.address);
        city=findViewById(R.id.city);
        state=findViewById(R.id.state);
        pincode=findViewById(R.id.pincode);
        qualification=findViewById(R.id.qualification);
        year_of_passing=findViewById(R.id.year_of_passing);
        current_year=findViewById(R.id.current_year);
        institution=findViewById(R.id.institution);
        standing_arrear=findViewById(R.id.standing_arrear);
        history_of_arrear=findViewById(R.id.history_of_arrear);
        profile_image=findViewById(R.id.profile_image);
        change_profile_image=findViewById(R.id.change_profile_image);
        save=findViewById(R.id.done);

        mUsersDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Student student = dataSnapshot.getValue(Student.class);
                first_name.setText(student.getFirst_name());
                last_name.setText(student.getLast_name());
                phone_number.setText(student.getPhone());
                father_name.setText(student.getFather_name());
                mother_name.setText(student.getMother_name());
                date_of_birth.setText(student.getDate_of_birth());
                address.setText(student.getAddress());
                city.setText(student.getCity());
                state.setText(student.getState());
                pincode.setText(student.getPincode());

                if (student.getProfile_pic().isEmpty())
                    Glide.with(getApplicationContext()).load(R.drawable.about_me).into(profile_image);
                else
                    Glide.with(getApplicationContext()).load(student.getProfile_pic()).placeholder(R.drawable.about_me).into(profile_image);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        change_profile_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CropImage.activity()
                        .setAspectRatio(1, 1)
                        .start(EditProfileActivity.this);

            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String first = first_name.getText().toString();
                String last = last_name.getText().toString();
                String phone = phone_number.getText().toString();
                String father = father_name.getText().toString();
                String mother = mother_name.getText().toString();
                String dob = date_of_birth.getText().toString();
                String add = address.getText().toString();
                String ci = city.getText().toString();
                String sta = state.getText().toString();
                String pin = pincode.getText().toString();

                if(isEmpty(first,last,phone,father,mother,dob,add,ci,sta,pin)){
                    HashMap<String, Object> map = new HashMap<>();
                    map.put("first_name", first);
                    map.put("last_name", last);
                    map.put("phone", phone);
                    map.put("father_name", father);
                    map.put("mother_name", mother);
                    map.put("date_of_birth", dob);
                    map.put("address", add);
                    map.put("city", ci);

                    map.put("state", sta);
                    map.put("pincode", pin);

                    mUsersDatabase.updateChildren(map);

                    Toast.makeText(EditProfileActivity.this, "Successfully Updated!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(EditProfileActivity.this,ProfileActivity.class));
                    finish();
                }

            }
        });
    }

    private boolean isEmpty(String first, String last,String phone,String father,String mother,String dob,String add,String ci,String sta,String pin) {
        if (first.isEmpty() || last.isEmpty() || phone.isEmpty() || father.isEmpty() || mother.isEmpty() || dob.isEmpty() || add.isEmpty() || ci.isEmpty() || sta.isEmpty() || pin.isEmpty()) {
            Toast.makeText(EditProfileActivity.this, "PLEASE ENTER EVERY DETAILS", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void UploadImage() {
        final ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("Uploading");
        pd.show();
        if (mImageUri != null) {
            final StorageReference fileReference = mProfileImageStorage.child(System.currentTimeMillis()
                    + ".jpg");

            mUploadTask = fileReference.putFile(mImageUri);
            mUploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                @Override
                public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                    if (!task.isSuccessful()) {
                        throw task.getException();
                    }
                    return fileReference.getDownloadUrl();
                }
            }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                @Override
                public void onComplete(@NonNull Task<Uri> task) {
                    if (task.isSuccessful()) {
                        Uri downloadUri = task.getResult();
                        String miUrlOk = downloadUri.toString();

                        HashMap<String, Object> map1 = new HashMap<>();
                        map1.put("profile_pic", "" + miUrlOk);
                        mUsersDatabase.updateChildren(map1);

                        pd.dismiss();

                    } else {
                        Toast.makeText(EditProfileActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(EditProfileActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

        } else {
            Toast.makeText(EditProfileActivity.this, "No image selected", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {


            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            mImageUri = result.getUri();

            UploadImage();

        } else {
            Toast.makeText(this, "Something gone wrong!", Toast.LENGTH_SHORT).show();
        }
    }
}