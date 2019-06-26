package com.project.belajajrretrofit.adapter;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.project.belajajrretrofit.R;
import com.project.belajajrretrofit.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.OrderListViewHolder>{

    private List<Order> orders = new ArrayList<>();
    @NonNull
    @Override
    public OrderListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        OrderListViewHolder viewHolder = new OrderListViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_order, viewGroup, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderListViewHolder holder, int position) {
        Order order = orders.get(position);
        holder.tvOrderId.setText(order.getId());
        holder.tvVendor.setText(order.getVendor());
        holder.tvSubcategory.setText(order.getSubcategory());
        holder.tvOrderStatus.setText(order.getOrderStatus());
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public class OrderListViewHolder extends RecyclerView.ViewHolder{
        TextView tvOrderId, tvVendor, tvSubcategory, tvOrderStatus;
        public OrderListViewHolder(View v){
            super(v);
            tvOrderId = v.findViewById(R.id.tv_orderid);
            tvVendor = v.findViewById(R.id.tv_vendor);
            tvSubcategory = v.findViewById(R.id.tv_subcategory);
            tvOrderStatus = v.findViewById(R.id.tv_order_status);
        }
    }

    public void setOrders(List<Order> orders) {
        this.orders.clear();
        this.orders.addAll(orders);
        notifyDataSetChanged();
    }
}
