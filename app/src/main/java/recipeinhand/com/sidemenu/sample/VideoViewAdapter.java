package recipeinhand.com.sidemenu.sample;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class VideoViewAdapter extends RecyclerView.Adapter<VideoViewHolder> {

    private List<VideoData> mItemList;

    public VideoViewAdapter(List<VideoData> a_list) {
        mItemList = a_list;
    }

    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup a_viewGroup, int a_position) {
        View view = LayoutInflater.from(a_viewGroup.getContext()).inflate(R.layout.listview_video, a_viewGroup, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder a_viewHolder, int a_position) {
        final VideoData item = mItemList.get(a_position);

        a_viewHolder.ivIcon.setImageResource(item.getImageResId());

    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }
}