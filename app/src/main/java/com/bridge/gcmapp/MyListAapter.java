package com.bridge.gcmapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sec on 2016-10-25.
 */
public class MyListAapter extends BaseAdapter {

    ArrayList<DataVo> lst = new ArrayList<DataVo>();
    //ArrayList<DataVo> lst;
    Context context;
    LayoutInflater infalter;

    public MyListAapter(Context context) {
        this.context = context;
        infalter = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

    }

    public MyListAapter() {

    }

    public int getCount() {
        return lst.size();
    }

    public Object getItem(int position) {
        //return null;
        return lst.get(position);
    }

    public long getItemId(int position) {
        //return 0;
        return position;
        //return (lst != null && (0 <= position && position < lst.size()) ? position : 0);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        final int pos = position;



        //View view = convertView;
        if (convertView == null) {
            view = infalter.inflate(R.layout.row, parent, false);
            infalter = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);


        } else {
            view = convertView;
        }
        TextView txt_title = (TextView) view.findViewById(R.id.txt_title);
        TextView txt_contents = (TextView) view.findViewById(R.id.txt_contents);
        Log.d("!!!!!!!", String.valueOf(txt_title));
        DataVo dataVo = lst.get(position);
        txt_title.setText(dataVo.getTitle());
        txt_contents.setText(dataVo.getContents());

        return view;
    }
}
   /*
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        CustomViewHolder holder;
        if (convertView == null) {
            convertView = infalter.inflate(R.layout.row, parent, false);
            holder = new CustomViewHolder();
            holder.title = (TextView) convertView.findViewById(R.id.txt_title);
            holder.content = (TextView) convertView.findViewById(R.id.txt_contents);
            convertView.setTag(holder);
        }else {
            holder = (CustomViewHolder) convertView.getTag();
        }
        DataVo dataVo =lst.get(position);
        holder.title.setText(dataVo.getTitle());
        holder.content.setText(dataVo.getContents());
        RecyclerView.ViewHolder vh = new RecyclerView.ViewHolder() {
        vh.
        }
        return  convertView;
        }


    class CustomViewHolder{
         TextView title;
        TextView content;
    }
}*/
