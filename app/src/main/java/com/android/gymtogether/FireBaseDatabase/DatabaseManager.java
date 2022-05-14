package com.android.gymtogether.FireBaseDatabase;

import androidx.annotation.NonNull;
import com.android.gymtogether.model.User;
import com.google.firebase.database.*;


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

}
