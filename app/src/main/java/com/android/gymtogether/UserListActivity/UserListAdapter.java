package com.android.gymtogether.UserListActivity;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.android.gymtogether.LoginGoogleActivity.model.User;
import com.android.gymtogether.R;
import com.android.gymtogether.tool.ImageConverter;
import de.hdodenhof.circleimageview.CircleImageView;

import java.util.List;

public class UserListAdapter extends ArrayAdapter<User> {

    private Activity activity;
    private List<User> user;

    public UserListAdapter(Activity activity, List<User> user){
        super(activity, R.layout.user_item,user);

        this.user = user;
        this.activity = activity;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.user_item, parent, false);

        TextView userName =  (TextView) rowView.findViewById(R.id.displayName);
        CircleImageView imageView = (CircleImageView) rowView.findViewById(R.id.userAvatar);

        userName.setText(user.get(position).getName());
        imageView.setImageBitmap(ImageConverter.convertFromUrlToBmp(user.get(position).getPhotoUrl()));
        return rowView;

    }
}
