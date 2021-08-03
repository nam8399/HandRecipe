package recipeinhand.com.sidemenu.sample;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class VideoData {
    private int imageResId;


    public VideoData(int a_resId) {
        imageResId = a_resId;
    }

    public int getImageResId() {
        return imageResId;
    }

}