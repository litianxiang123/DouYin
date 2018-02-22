package helloworld.example.com.douyin.recommend.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import helloworld.example.com.douyin.R;

/**
 * Created by 李天祥 on 2018/2/22.
 */

public class ImageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<String> list;
    private Context context;

    public ImageAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.video_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.video_image.setImageURI(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        SimpleDraweeView video_image;

        public MyViewHolder(View itemView) {
            super(itemView);
            video_image = itemView.findViewById(R.id.video_image);
        }
    }


}
