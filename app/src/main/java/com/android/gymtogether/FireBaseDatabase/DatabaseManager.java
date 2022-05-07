package com.android.gymtogether.FireBaseDatabase;

import android.os.Debug;
import android.util.Log;
import androidx.annotation.NonNull;
import com.android.gymtogether.LoginGoogleActivity.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class DatabaseManager {

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    public DatabaseManager(){
        firebaseDatabase = FirebaseDatabase.getInstance();
    }

    public void addUser(User user){
        Query query= firebaseDatabase.getReference().child("users").orderByChild("email").equalTo(user.getEmail());
       query.addListenerForSingleValueEvent(new ValueEventListener(){
           @Override
           public void onDataChange(@NonNull DataSnapshot snapshot) {
               if(!snapshot.exists()){
                   databaseReference = firebaseDatabase.getReference().child("users").push();
                   databaseReference.setValue(user);
               }
           }

           @Override
           public void onCancelled(@NonNull DatabaseError error) {

           }
       });
    }

    public void getUsersFromDatabase(MyCallback myCallback){
        List<User> listUser = new ArrayList<>();
        firebaseDatabase
                .getReference()
                .child("users")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for (DataSnapshot dataSnap : dataSnapshot.getChildren()) {
                            User user = dataSnap.getValue(User.class);
                            listUser.add(user);
                        }
                        myCallback.onCallback(listUser);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
    }


    public interface MyCallback {
        void onCallback(List<User> value);
    }

}
