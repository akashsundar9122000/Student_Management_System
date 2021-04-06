package com.studentmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.studentmanagement.Models.Extra_curricular;

import java.util.HashMap;

public class NewExtraCurricularActivity extends AppCompatActivity {

    private TextInputEditText activity,organisation,url;

    private FloatingActionButton save;

    private FirebaseUser mFirebaseUser;
    private String mCurrentUserId;
    private Uri mImageUri;
    private StorageTask mUploadTask;
    private StorageReference mProfileImageStorage;
    private DatabaseReference mExtraCurricularDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_extra_curricular);

        mFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        mCurrentUserId = mFirebaseUser.getUid();

        mExtraCurricularDatabase = FirebaseDatabase.getInstance().getReference("Extra_Curricular").child(mCurrentUserId);
        mExtraCurricularDatabase.keepSynced(true);

        activity=findViewById(R.id.activity);
        organisation=findViewById(R.id.organisation);
        url=findViewById(R.id.url);
        save=findViewById(R.id.done);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String act = activity.getText().toString();
                String org=organisation.getText().toString();
                String ur=url.getText().toString();

                if(isEmpty(act,org,ur)){
                    String key=mExtraCurricularDatabase.push().getKey();
                    HashMap<String, Object> map = new HashMap<>();
                    map.put("activity",act);
                    map.put("organisation",org);
                    map.put("url",ur);
                    map.put("extra_curricular_id",key);
                    mExtraCurricularDatabase.child(key).setValue(map);

                    Toast.makeText(NewExtraCurricularActivity.this, "Successfully Saved!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(NewExtraCurricularActivity.this,ExtraCurricularActivity.class));
                    finish();
                }
            }
        });
    }

    private boolean isEmpty(String act,String org,String ur) {
        if (act.isEmpty() || org.isEmpty() || ur.isEmpty()) {
            Toast.makeText(NewExtraCurricularActivity.this, "PLEASE ENTER EVERY DETAILS", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}