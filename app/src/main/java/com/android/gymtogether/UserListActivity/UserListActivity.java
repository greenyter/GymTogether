package com.android.gymtogether.UserListActivity;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import com.android.gymtogether.FireBaseDatabase.DatabaseManager;
import com.android.gymtogether.R;
import com.android.gymtogether.UserListActivity.presenter.UserListPresenterImpl;
import com.android.gymtogether.UserListActivity.view.UserListView;
import com.android.gymtogether.model.User;
import com.android.gymtogether.model.UserInfo;

import java.util.ArrayList;
import java.util.List;

public class UserListActivity extends AppCompatActivity implements UserListView {

    private ListView usersListView;
    private UserListPresenterImpl userListPresenter;
    private DatabaseManager databaseManager;
    private List<UserInfo> userInfos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        init();
        databaseManager = new DatabaseManager(this);

        userListPresenter = new UserListPresenterImpl(this);
        userListPresenter.getUsers();
    }

    private void init(){
        usersListView = findViewById(R.id.users);
    }



    @Override
    public void setUser(List<User> users, List<UserInfo> userInfoList) {
        final UserListAdapter arrayAdapter = new UserListAdapter
                (this, users, userInfoList);
        usersListView.setAdapter(arrayAdapter);
    }


}