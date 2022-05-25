package com.android.gymtogether.UserListActivity;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.android.gymtogether.FireBaseDatabase.DatabaseManager;
import com.android.gymtogether.R;
import com.android.gymtogether.model.User;
import com.android.gymtogether.model.UserInfo;
import com.android.gymtogether.tool.ImageConverter;
import de.hdodenhof.circleimageview.CircleImageView;

import java.util.List;

public class UserListAdapter extends ArrayAdapter<User> {

    private Activity activity;
    private List<User> user;
    private List<UserInfo> infoText;

    public UserListAdapter(Activity activity, List<User> user, List<UserInfo> userInfos){
        super(activity, R.layout.user_item,user);

        this.user = user;
        this.activity = activity;
        this.infoText = userInfos;
    }



    private String attachTheUserInfoToUser(User user, UserInfo userInfo){
        if(userInfo == null){
            return String.format("%s",user.getName());
        }
        if (user.getEmail().equals(userInfo.getUserEmail())){
            return String.format("%s -> %s",user.getName(),userInfo.getUserInfo());
        }
        return String.format("%s",user.getName());
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.user_item, parent, false);
        attachTheUserInfoToUser(user.get(position)
                       ,infoText.get(position));
        TextView userName =  (TextView) rowView.findViewById(R.id.displayName);
        CircleImageView imageView = (CircleImageView) rowView.findViewById(R.id.userAvatar);
        userName.setText(attachTheUserInfoToUser(user.get(position)
                ,infoText.get(position)));
        imageView.setImageBitmap(ImageConverter.convertFromUrlToBmp(user.get(position).getPhotoUrl()));
        return rowView;

    }
}
