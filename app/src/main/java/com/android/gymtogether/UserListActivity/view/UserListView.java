package com.android.gymtogether.UserListActivity.view;


import com.android.gymtogether.model.User;
import com.android.gymtogether.model.UserInfo;

import java.util.List;

public interface UserListView {

    void setUser(List<User> users, List<UserInfo> userInfoList);
}
