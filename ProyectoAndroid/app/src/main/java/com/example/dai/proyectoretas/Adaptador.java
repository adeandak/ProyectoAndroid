package com.example.dai.proyectoretas;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

import java.util.ArrayList;
import java.util.Date;

public class Adaptador extends BaseAdapter {
    private Context con;
    private ArrayList<String> hora;

    public Adaptador(Context con, ArrayList<String> hora) {
        this.con=con;
        this.hora=hora;
    }

    @Override
    public int getViewTypeCount() {
        return super.getViewTypeCount();
    }

    @Override
    public int getCount() {
        return hora.size();
    }

    @Override
    public Object getItem(int position) {
        return hora.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
