package helloworld.example.com.douyin.search.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import helloworld.example.com.douyin.R;
import helloworld.example.com.douyin.search.SearchBean;

/**
 * Created by 李天祥 on 2018/2/22.
 */

public class SearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<SearchBean.DataBean> list;
    private Context context;

    public SearchAdapter(List<SearchBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rs_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;

       // SearchBean.DataBean.ChallengeBean challenge = list.get(position).getChallenge();
        //SearchBean.DataBean.MusicBean music = list.get(position).getMusic();
        if (position!=1){
            SearchBean.DataBean.ChallengeBean challenge = list.get(position).getChallenge();
            myViewHolder.tv_resou.setText(challenge.getCha_name());
        }else if (position == 1){
            SearchBean.DataBean.MusicBean music = list.get(position).getMusic();
            myViewHolder.tv_resou.setText(music.getTitle());
        }

    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_resou;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv_resou = itemView.findViewById(R.id.tv_resou);
        }
    }
}
