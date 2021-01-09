package com.example.customadapterlistview_nc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FruitAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Fruit> fruits;

    public FruitAdapter(Context context, int layout, List<Fruit> fruits) {
        this.context = context;
        this.layout = layout;
        this.fruits = fruits;
    }

    @Override
    public int getCount() { // tra ve so dong hien thi trong listview
        return fruits.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder{
        ImageView imgImg;
        TextView txtName, txtDes;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) { // tra ve moi dong tren item khi goi Adapter
        ViewHolder holder;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder = new ViewHolder();

            // anh xa convertView
            holder.txtName = (TextView) convertView.findViewById(R.id.textview_name);
            holder.txtDes = (TextView) convertView.findViewById(R.id.textview_des);
            holder.imgImg = (ImageView) convertView.findViewById(R.id.imageview_image);

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        // gan gia tri
        Fruit fruit = fruits.get(position);
        holder.txtName.setText(fruit.getName());
        holder.txtDes.setText(fruit.getDescription());
        holder.imgImg.setImageResource(fruit.getImage());

        return convertView;
    }
}
