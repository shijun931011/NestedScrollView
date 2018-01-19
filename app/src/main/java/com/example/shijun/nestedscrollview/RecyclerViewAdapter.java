package com.example.shijun.nestedscrollview;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by shijun on 2018/1/19.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter {
    private boolean mWithHeader;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    public RecyclerViewAdapter(){
        mWithHeader=false;
    }

    public RecyclerViewAdapter(boolean withHeader){
        mWithHeader=withHeader;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_item,parent,false);
            return new HeaderViewHolder(view);
        }else if (viewType == TYPE_ITEM){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
            return new ItemViewHolder(view);
        }
        throw new RuntimeException("there is no type that matches the type " + viewType + " + make sure your using types correctly");
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position))
            return TYPE_HEADER;
        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {
        return this.mWithHeader && position == 0;
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class HeaderViewHolder extends RecyclerView.ViewHolder{
        public CardView cardView;
        public HeaderViewHolder(View itemView){
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cardview_header);
        }
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder{
        public CardView cardView;
        public ItemViewHolder(View itemView){
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cardview);
        }
    }
}
