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
    private int image;
    private int imageid;

    public VideoData(int imageid, int image){
        this.imageid = imageid;
        this.image = image;
    }

    public int getImage()
    {
        return this.image;
    }
    public int getImageid() { return this.imageid; }
}