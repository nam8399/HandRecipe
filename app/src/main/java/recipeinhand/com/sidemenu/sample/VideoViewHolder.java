package recipeinhand.com.sidemenu.sample;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

public class VideoViewHolder extends RecyclerView.ViewHolder {

    ImageView ivIcon;

    public VideoViewHolder(View a_itemView) {
        super(a_itemView);

        ivIcon = a_itemView.findViewById(R.id.list_video);
    }

}
