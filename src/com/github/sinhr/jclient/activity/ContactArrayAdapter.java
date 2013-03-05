package com.github.sinhr.jclient.activity;

import java.util.List;

import com.github.sinhr.jclient.Contact;
import com.github.sinhr.jclient.R;
import com.github.sinhr.jclient.R.id;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ContactArrayAdapter extends ArrayAdapter<Contact> {
    
    private int resource;

    public ContactArrayAdapter(Context context, int textViewResourceId,
                    List<Contact> objects) {
            super(context, textViewResourceId, objects);
            this.resource = textViewResourceId;
    }
   
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            LinearLayout backupView;
            Contact obj = getItem(position);
            if(convertView == null) {
                    backupView = new LinearLayout(getContext());
                    String inflater = Context.LAYOUT_INFLATER_SERVICE;
                    LayoutInflater li = (LayoutInflater)getContext().getSystemService(inflater);
                    li.inflate(resource, backupView, true);
            }
            else {
                    backupView = (LinearLayout)convertView;
            }
            TextView txtView1 = (TextView)backupView.findViewById(R.id.txtName);
            TextView txtView2 = (TextView)backupView.findViewById(R.id.txtStatus);
            ImageView appicon = (ImageView)backupView.findViewById(R.id.imgContact);
           
            txtView1.setText(obj.getName());
            txtView2.setText(obj.getStatus());
            appicon.setImageDrawable(obj.getImage());
           
            return backupView;
    }

}
