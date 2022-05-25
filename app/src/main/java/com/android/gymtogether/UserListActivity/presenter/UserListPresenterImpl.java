package com.android.gymtogether.UserListActivity.presenter;

import android.content.Context;
import com.android.gymtogether.FireBaseDatabase.DatabaseManager;
import com.android.gymtogether.UserListActivity.view.UserListView;
import com.android.gymtogether.model.Training;
import com.android.gymtogether.model.User;
import com.android.gymtogether.model.UserInfo;

import java.time.LocalDate;
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
        final List<UserInfo>[] _userInfos = new List[]{new ArrayList<>()};
    databaseManager.getUserInfo(new DatabaseManager.UserInfoCallback() {
        @Override
        public void onCallback(List<UserInfo> userInfo) {
            _userInfos[0] = userInfo;
        }
    });
        databaseManager.getUsersFromDatabase(new DatabaseManager.ListUserCallback() {
            @Override
            public void onCallback(List<User> value) {
                userListView.setUser(value, _userInfos[0]);
            }
        });
    }

}
