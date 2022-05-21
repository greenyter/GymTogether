package com.android.gymtogether.FireBaseDatabase;

import android.util.Log;
import androidx.annotation.NonNull;
import com.android.gymtogether.model.Training;
import com.android.gymtogether.model.User;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.*;

import java.util.*;


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

    public void addTraining(Training training,User user){
        Query query= firebaseDatabase.getReference().ch.orderByChild("email").equalTo(user.getEmail());
        query.addListenerForSingleValueEvent(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Map<String,Object> values = new HashMap<String,Object>();
                values.put("a", training.getDate());
                values.put("n", training.getExercises().get(0).getExerciseName());
                databaseReference.child("users").child("training").updateChildren(values);

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
