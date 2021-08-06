package recipeinhand.com.sidemenu.sample;

import android.app.Person;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

public class VideoViewHolder extends RecyclerView.ViewHolder {

    public ImageView ivIcon;

    public VideoViewHolder(View a_itemView, final OnPersonItemClickListener listener) {
        super(a_itemView);

        ivIcon = a_itemView.findViewById(R.id.list_video);

        a_itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = getAdapterPosition();
                if (listener != null) {
                    listener.onItemClick(VideoViewHolder.this, view, position);
                }
            }
        });

    }
    public void setItem(VideoData item){
        ivIcon.setImageResource(item.getImageResId());
    }

}
