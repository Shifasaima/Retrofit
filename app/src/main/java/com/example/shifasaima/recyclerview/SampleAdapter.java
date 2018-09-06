 package com.example.shifasaima.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.zip.Inflater;

public class SampleAdapter extends RecyclerView.Adapter<Sample>
{
        private LayoutInflater mInflator;
    private List<Hero> heroList;
    private onClickItem  onClickItem;
    SampleAdapter(List<Hero>heroList, Context context, onClickItem  onClickItem){
        this.heroList= heroList;
        mInflator = LayoutInflater.from(context);
        this.onClickItem = onClickItem;
    }
        @Override
    public Sample onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= mInflator.inflate(R.layout.viewholder,parent,false);
        final Sample sample = new Sample(view);
       /* view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItem.onClickView(heroList.(sample.getAdapterPosition()).id);
            }
        });*/
        return  sample;
    }

    @Override
    public void onBindViewHolder(Sample holder, int position) {
        holder.text.setText(heroList.get(position).getName());
        Picasso.get().load(heroList.get(position).getImageurl()).into(holder.img);

        holder.text2.setText(""+heroList.get(position).getTeam());
    }


    @Override
    public int getItemCount() {
        return heroList.size();
    }
    interface onClickItem{
        void onClickView(int position);
    }
}
class Sample extends RecyclerView.ViewHolder
{ TextView text;
ImageView img;
TextView text2;
    public Sample(View itemView){
        super(itemView);
        img = itemView.findViewById(R.id.im1);
        text=itemView.findViewById(R.id.t1);
        text2=itemView.findViewById(R.id.t2);
    }


}

