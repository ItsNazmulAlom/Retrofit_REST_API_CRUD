package com.nazmul.retrofit;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nazmul.rectrofit.R;
import com.nazmul.retrofit.model.Contacts;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Contacts> contacts;
    Context context;

    public Adapter(Context context,List<Contacts> contacts) {
        this.context = context;
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(contacts.get(position).getName());
        holder.email.setText(contacts.get(position).getEmail());

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView name,email;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
            itemView.setOnClickListener(this);

        }
        @Override
        public void onClick(View v) {

            Intent intent = new Intent(context,EditorActivity.class);
            intent.putExtra("id",contacts.get(getAdapterPosition()).getId());
            intent.putExtra("name",contacts.get(getAdapterPosition()).getName());
            intent.putExtra("email",contacts.get(getAdapterPosition()).getEmail());
            context.startActivity(intent);
        }
    }


}
