package com.jp.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.ufma.lsdi.digitalphenotyping.processormanager.services.database.active.ActiveDataProcessor;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ActiveDataProcessorViewHolder> {
    private Context context;
    private List<ActiveDataProcessor> activeDataProcessorList = new ArrayList();

    public RecyclerViewAdapter(Context context, List<ActiveDataProcessor> activeDataProcessors){
        this.context = context;
        this.activeDataProcessorList = activeDataProcessors;
    }

    @NonNull
    @Override
    public ActiveDataProcessorViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_main_list_item, viewGroup, false);
        ActiveDataProcessorViewHolder adpvh = new ActiveDataProcessorViewHolder(v);
        return adpvh;
    }

    @Override
    public void onBindViewHolder(ActiveDataProcessorViewHolder activeDataProcessorViewHolder, int position) {
        if(activeDataProcessorList == null){
            activeDataProcessorViewHolder.dataProcessorName.setText("No data processors enabled!");
        }
        else {
            activeDataProcessorViewHolder.dataProcessorName.setText(activeDataProcessorList.get(position).getDataProcessorName());
        }
    }

    @Override
    public int getItemCount() {
        return activeDataProcessorList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class ActiveDataProcessorViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView dataProcessorName;

        public ActiveDataProcessorViewHolder(View itemView){
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cardview_list_item);
            dataProcessorName = (TextView) itemView.findViewById(R.id.item_name);
        }
    }
}