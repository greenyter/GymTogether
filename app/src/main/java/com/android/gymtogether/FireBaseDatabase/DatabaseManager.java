package com.android.gymtogether.FireBaseDatabase;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.android.gymtogether.model.Training;
import com.android.gymtogether.model.User;
import com.android.gymtogether.model.UserInfo;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.*;

import java.time.LocalDate;
import java.util.*;


public class DatabaseManager {

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private GoogleSignInAccount googleSignInAccount;

    public DatabaseManager(Context context) {
        firebaseDatabase = FirebaseDatabase.getInstance();
        googleSignInAccount = GoogleSignIn.getLastSignedInAccount(context);
    }

    public DatabaseManager() {
        firebaseDatabase = FirebaseDatabase.getInstance();
    }

    public void addUser(User user) {
        Query query = firebaseDatabase.getReference().child("users").orderByChild("email").equalTo(user.getEmail());
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (!snapshot.exists()) {
                    databaseReference = firebaseDatabase.getReference().child("users").push();
                    databaseReference.setValue(user);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void addTraining(Training training, Context context) {

        Query query = firebaseDatabase.getReference().child("training");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                databaseReference = firebaseDatabase.getReference().child("training").push();
                training.setEmailUser(googleSignInAccount.getEmail());
                databaseReference.setValue(training);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void addUserInfo(UserInfo info){
        Query query = firebaseDatabase.getReference().child("info");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                databaseReference = firebaseDatabase.getReference().child("info").push();
                info.setUserEmail(googleSignInAccount.getEmail());
                databaseReference.setValue(info);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void getUserInfo(UserInfoCallback myCallback){
        List<UserInfo> userInfos = new ArrayList<>();
        firebaseDatabase
                .getReference()
                .child("info")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for (DataSnapshot dataSnap : dataSnapshot.getChildren()) {
                            UserInfo userInfo = dataSnap.getValue(UserInfo.class);
                            userInfos.add(userInfo);
                            Log.d("userInfor",userInfo.getUserInfo());
                        }
                        myCallback.onCallback(userInfos);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
    }

    public void getTraining(TrainingCallback myCallback, LocalDate localDate){
        Query query = firebaseDatabase.getReference().child("training").orderByChild("emailUser").equalTo(googleSignInAccount.getEmail());
        final Training[] getTrainingRes = {new Training()};
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnap : dataSnapshot.getChildren()) {
                    Training training = dataSnap.getValue(Training.class);
                    if(training.getDate().equals(localDate.toString())) {
                        getTrainingRes[0] = training;
                        myCallback.onCallback(getTrainingRes[0]);
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public void getUsersFromDatabase(ListUserCallback myCallback) {
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


    public interface ListUserCallback {
        void onCallback(List<User> value);
    }

    public interface TrainingCallback{
        void onCallback(Training training);
    }

    public interface UserInfoCallback{
        void onCallback(List<UserInfo> userInfo);
    }

}
