package helloworld.example.com.douyin.recommend.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import helloworld.example.com.douyin.R;
import helloworld.example.com.douyin.recommend.RecomBean;

/**
 * Created by 李天祥 on 2018/2/22.
 */

public class RecomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<RecomBean.CategoryListBean> list;
    private Context context;

    public RecomAdapter(List<RecomBean.CategoryListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recom_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        RecomBean.CategoryListBean.ChallengeInfoBean challenge_info = list.get(position).getChallenge_info();
        List<RecomBean.CategoryListBean.AwemeListBean> aweme_list = list.get(position).getAweme_list();
        myViewHolder.nick.setText(challenge_info.getCha_name());
        myViewHolder.qianming.setText(list.get(position).getDesc());
        myViewHolder.gz.setText(challenge_info.getUser_count()+"");

        //获取视频
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < aweme_list.size(); i++) {
            String s = aweme_list.get(i).getVideo().getCover().getUrl_list().get(0);
            list.add(s);
        }

        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 1);
        gridLayoutManager.setOrientation(gridLayoutManager.HORIZONTAL);
        ((MyViewHolder) holder).video.setLayoutManager(gridLayoutManager);
        ImageAdapter imageAdapter = new ImageAdapter(list,context);
        ((MyViewHolder) holder).video.setAdapter(imageAdapter);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        SimpleDraweeView msdv;
        TextView nick,qianming,gz;
        LinearLayout ll,sim_ll;
        RecyclerView video;

        public MyViewHolder(View itemView) {
            super(itemView);
            msdv= itemView.findViewById(R.id.tubiao);
            nick=itemView.findViewById(R.id.nick);
            qianming=itemView.findViewById(R.id.qianming);
            gz = itemView.findViewById(R.id.usercount);
            ll=itemView.findViewById(R.id.ll_sel);
            sim_ll = itemView.findViewById(R.id.sim_ll);
            video = itemView.findViewById(R.id.video);
        }
    }

}
