package recipeinhand.com.sidemenu.sample;

import android.app.Person;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

import recipeinhand.com.sidemenu.sample.fragment.ContentFragment;

public class VideoViewAdapter extends RecyclerView.Adapter<VideoViewHolder> implements OnPersonItemClickListener {

    OnPersonItemClickListener listener;
    ArrayList<VideoData> items = new ArrayList<VideoData>();


    @Override
    public void onItemClick(VideoViewHolder holder, View view, int position) {
        if(listener != null){
            listener.onItemClick(holder,view,position);
        }
    }



    private Context context;





    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup a_viewGroup, int a_position) {
        View view = LayoutInflater.from(a_viewGroup.getContext()).inflate(R.layout.listview_video, a_viewGroup, false);

        return new VideoViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder a_viewHolder, int a_position) {
        VideoData item = items.get(a_position);

        //a_viewHolder.ivIcon.setTag(item.getIdx());
        a_viewHolder.ivIcon.setImageResource(item.getImageResId());


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setOnItemClicklistener(OnPersonItemClickListener listener) {
        this.listener = listener;
    }

    public void addItem(VideoData item) {
        items.add(item);
    }

    public void setItems(ArrayList<VideoData> items) {
        this.items = items;
    }

    public VideoData getitem(int position) {
        return items.get(position);
    }

    public void setItem(int position, VideoData item) {
        items.set(position, item);
    }

}
