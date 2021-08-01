package recipeinhand.com.sidemenu.sample;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends BaseAdapter {

    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    private ArrayList<SampleData> sample = new ArrayList<SampleData>();


    public MyAdapter(Context context, ArrayList<SampleData> data) {
        mContext = context;
        sample = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return sample.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public SampleData getItem(int position) {
        return sample.get(position);
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        View view = mLayoutInflater.inflate(R.layout.listview_item, null);

        ImageView imageView = (ImageView) view.findViewById(R.id.listitem_image);
        TextView title = (TextView) view.findViewById(R.id.listitem_name);
        TextView gredient = (TextView) view.findViewById(R.id.listitem_ingredient);

        imageView.setImageResource(sample.get(position).getImage());
        title.setText(sample.get(position).getTitle());
        gredient.setText(sample.get(position).getIngredient());

        return view;
    }


}
