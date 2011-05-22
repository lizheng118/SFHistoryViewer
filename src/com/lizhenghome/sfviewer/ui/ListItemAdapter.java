package com.lizhenghome.sfviewer.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import com.lizhenghome.sfviewer.R;
import com.lizhenghome.sfviewer.bean.UsageHistory;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: lizheng
 * Date: 11/05/22
 * Time: 16:58
 * To change this template use File | Settings | File Templates.
 */
public class ListItemAdapter extends ArrayAdapter<UsageHistory>{

    private LayoutInflater inflater;

    private int textViewResourceId;

    private List<UsageHistory> items;

    public ListItemAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public ListItemAdapter(Context context, int textViewResourceId,
                List<UsageHistory> items) {
            super(context, textViewResourceId, items);

            this.textViewResourceId = textViewResourceId;
            this.items = items;
            this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = null;
		if(convertView != null) {
			view = convertView;
		} else {
			view = inflater.inflate(textViewResourceId, null);
		}

		UsageHistory item = items.get(position);

		ImageView imageView = (ImageView)view.findViewWithTag("icon");
		imageView.setImageResource(R.drawable.train_icon);

		return view;
	}
}
