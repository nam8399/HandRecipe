package recipeinhand.com.sidemenu.sample;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import recipeinhand.com.sidemenu.sample.fragment.ContentFragment;

public class VideoViewAdapter extends RecyclerView.Adapter<VideoViewHolder> {




    private List<VideoData> mItemList;
    private Context context;
    private View.OnClickListener onClickItem;


    public VideoViewAdapter(Context context, List<VideoData> a_list, View.OnClickListener onClickItem)
    {
        this.context = context;
        this.mItemList = a_list;
        this.onClickItem = onClickItem;
    }

    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup a_viewGroup, int a_position) {
        View view = LayoutInflater.from(a_viewGroup.getContext()).inflate(R.layout.listview_video, a_viewGroup, false);
        VideoViewHolder viewHolder = new VideoViewHolder(view);
        context = a_viewGroup.getContext();

        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder a_viewHolder, int a_position) {
        final VideoData item = mItemList.get(a_position);

        a_viewHolder.ivIcon.setTag(item.getIdx());
        a_viewHolder.ivIcon.setImageResource(item.getImageResId());
        a_viewHolder.ivIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("위치확인", "" + mItemList.get(a_position).getImageResId());
                Intent intent = new Intent(context, WebviewActivity.class);
                int key = mItemList.get(a_position).getImageResId();
                intent.putExtra("Key", key);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }


}
