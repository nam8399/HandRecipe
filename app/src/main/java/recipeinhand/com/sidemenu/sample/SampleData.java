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

public class SampleData {
    private int image;
    private String title;
    private String ingredient;

    public SampleData(int image, String title, String ingredient){
        this.image = image;
        this.title = title;
        this.ingredient = ingredient;
    }

    public int getImage()
    {
        return this.image;
    }

    public String getTitle()
    {
        return this.title;
    }

    public String getIngredient()
    {
        return this.ingredient;
    }
}