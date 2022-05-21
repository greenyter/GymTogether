package com.android.gymtogether.UserListActivity.presenter;

import com.android.gymtogether.FireBaseDatabase.DatabaseManager;
import com.android.gymtogether.UserListActivity.view.UserListView;
import com.android.gymtogether.model.User;

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
