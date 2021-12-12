package com.example.TaashKheloApp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;

public class MySpinner extends androidx.appcompat.widget.AppCompatSpinner {
    OnItemSelectedListener listener;
    View last_view;
    long last_id;
    AdapterView<?> lastParent;

    public MySpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
        initInternalListener();
    }

    public MySpinner(Context context, AttributeSet attrs, int defstyle) {
        super(context, attrs,defstyle);
        initInternalListener();
    }



    public void initInternalListener() {
        super.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                lastParent=parent;
                last_view=view;
                last_id=id;
                if(listener!=null)
                {
                    listener.onItemSelected(parent,view,position,id);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                if(listener!=null)
                {
                    listener.onNothingSelected(parent);
                }

            }
        });

    }

    @Override
    public void setSelection(int position) {
        super.setSelection(position);
        if(position==getSelectedItemPosition())
        {
            listener.onItemSelected(lastParent,last_view,position,last_id);
        }
        else
        {
            super.setSelection(position);
        }
    }

    @Override
    public void setOnItemSelectedListener( OnItemSelectedListener listener) {
        this.listener=listener;
    }
}