package com.example.livelist;
import com.example.livelist.AddItem;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.livelist.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>
{

    ArrayList<String> data;
    Context context;

    int position;

    public MyAdapter(Context ct, ArrayList<String> d)
    {
        data = d;
        context = ct;
    }

    public void addItem(String str)
    {
        data.add(str);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position)
    {
        holder.button1.setText(data.get(position));

//        holder.mainLayout.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                Intent intent = new Intent(context, AddItem.class);
//                intent.putExtra("data1", data.get(position));
//                context.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount()
    {
        return data.size();
    }

        public class MyViewHolder extends RecyclerView.ViewHolder
        {
            CheckBox button1;
            ConstraintLayout mainLayout;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                button1 = itemView.findViewById(R.id.checkBox2);
                mainLayout = itemView.findViewById(R.id.mainLayout);

                //this makes the text farther from the checkBox
                button1.setPadding(14, 0, 0, 0);
            }
        }
}
