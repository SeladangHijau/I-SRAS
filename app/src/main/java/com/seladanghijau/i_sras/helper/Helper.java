package com.seladanghijau.i_sras.helper;


import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class Helper {
    public static void getListViewSize(ListView listView , int typeSize){
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null){
            return;
        }

        //0 - normal
        //1 - bigger

        //setting listadapter in loop for getting final size
        int totalHeight = 0;
        int extraHeight = 0;

        if (typeSize == 1){
            extraHeight = 45;
        }else if (typeSize == 2){
            extraHeight = 25;
        }

        for (int size=0; size<listAdapter.getCount(); size++){
            View listItem = listAdapter.getView(size, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight() + extraHeight;
        }

        //setting listview item in adapter
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount()-1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }
}
