package com.android.gymtogether.MenuActivity.view;

import android.graphics.Bitmap;
import android.net.Uri;

public interface MenuView {

    void setImageView(Bitmap photoBitmap);
    void getImageFailed();
    void getConnectionFailed();
    void setText(String userDetails);
    void goToAddTrainingActivity();
}
