package com.android.gymtogether.UserListActivity.presenter;

import android.util.Log;
import com.android.gymtogether.FireBaseDatabase.DatabaseManager;
import com.android.gymtogether.LoginGoogleActivity.model.User;
import com.android.gymtogether.UserListActivity.view.UserListView;

import java.util.ArrayList;
import java.util.List;

public class UserListPresenterImpl implements UserListPresenter{

    private UserListView userListView;
    private DatabaseManager databaseManager;

    public UserListPresenterImpl(UserListView userListView){
        this.userListView = userListView;
        databaseManager = new DatabaseManager();
    }

    @Override
    public void getUsers() {

        databaseManager.getUsersFromDatabase(new DatabaseManager.MyCallback() {
            @Override
            public void onCallback(List<User> value) {
                userListView.setUser(value);
            }
        });


    }
}
