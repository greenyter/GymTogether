package com.android.gymtogether.UserListActivity;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import com.android.gymtogether.R;
import com.android.gymtogether.UserListActivity.presenter.UserListPresenterImpl;
import com.android.gymtogether.UserListActivity.view.UserListView;
import com.android.gymtogether.model.User;

import java.util.List;

public class UserListActivity extends AppCompatActivity implements UserListView {

    private ListView usersListView;
    private UserListPresenterImpl userListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        init();

        userListPresenter = new UserListPresenterImpl(this);
        userListPresenter.getUsers();
    }

    private void init(){
        usersListView = findViewById(R.id.users);
    }

    @Override
    public void setUser(List<User> users) {
        final UserListAdapter arrayAdapter = new UserListAdapter
                (this, users);
        usersListView.setAdapter(arrayAdapter);
    }
}