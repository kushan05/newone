package com.bithunters.notification;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bithunters.R;

import java.util.List;

/**
 * Created by DELL on 1/29/2018.
 * All Rights Reserved by MLPJ©
 */

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder>{

    List<LeaveItem> leaveItems;

    public NotificationAdapter(List<LeaveItem> leaveItems) {
        this.leaveItems = leaveItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.leave_card_view,parent,false);
        return new NotificationAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        LeaveItem leaveItem = leaveItems.get(position);
        holder.tvLeaveStartDate.setText(leaveItem.getLeaveStartDate());
        if(leaveItem.getAcceptReject() != null){
            holder.tvAcceptOrRejected.setText(leaveItem.getAcceptReject());
        }else{
            holder.tvAcceptOrRejected.setText("Pending");
        }
    }

    @Override
    public int getItemCount() {
        return leaveItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvLeaveStartDate, tvAcceptOrRejected;
        public ViewHolder(View itemView) {
            super(itemView);
            tvLeaveStartDate = (TextView) itemView.findViewById(R.id.tvLeaveStartDate);
            tvAcceptOrRejected = (TextView) itemView.findViewById(R.id.tvAcceptOrRejected);
        }
    }
}
