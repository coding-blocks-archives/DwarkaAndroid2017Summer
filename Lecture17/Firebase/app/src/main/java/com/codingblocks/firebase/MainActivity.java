package com.codingblocks.firebase;

import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> arrayList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        final EditText taskName = (EditText) findViewById(R.id.taskName);
        final EditText taskId = (EditText) findViewById(R.id.taskId);


        arrayList.add("Hello");

        FirebaseAuth fbAuth = FirebaseAuth.getInstance();

        if (fbAuth.getCurrentUser() == null) {
            //sign in /sign up
            Intent signInIntent = AuthUI
                    .getInstance()
                    .createSignInIntentBuilder()
                    .setIsSmartLockEnabled(false)
                    .setAvailableProviders(
                            Arrays.asList(new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build(),
                                    new AuthUI.IdpConfig.Builder(AuthUI.PHONE_VERIFICATION_PROVIDER).build(),
                                    new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build()))
                    .build();

            startActivityForResult(signInIntent, 111);

        }

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Todo currentTodo = new Todo(taskId.getText().toString(),
                        taskName.getText().toString(),
                        "Pending");

                FirebaseDatabase fb = FirebaseDatabase.getInstance();
                DatabaseReference dbRef = fb.getReference();

                dbRef.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onChildRemoved(DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

                dbRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        DataSnapshot todoSnapshot = dataSnapshot.child("todo");

                        Iterable<DataSnapshot> snapshotIterable = todoSnapshot.getChildren();

                        for (DataSnapshot ds : snapshotIterable) {

                            Todo currentTodo = ds.getValue(Todo.class);

                            Log.d("TAG", "onDataChange: " + currentTodo.getId());

                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

                dbRef.child("todo").child(currentTodo.getId()).setValue(currentTodo)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(MainActivity.this, "Task was Added", Toast.LENGTH_SHORT).show();
                            }
                        });

            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 111) {
            Toast.makeText(this, "Welcome user " + FirebaseAuth.getInstance().getCurrentUser().getDisplayName(), Toast.LENGTH_SHORT).show();
        }
    }

}
