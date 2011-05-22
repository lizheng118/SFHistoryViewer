package com.lizhenghome.sfviewer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.lizhenghome.sfviewer.R;
import com.lizhenghome.sfviewer.bean.UsageHistory;
import com.lizhenghome.sfviewer.ui.ListItemAdapter;
import com.lizhenghome.sfviewer.ui.SectionAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: lizheng
 * Date: 11/05/21
 * Time: 0:34
 * To change this template use File | Settings | File Templates.
 */
public class HistoryViewActivity extends Activity{

    ListView historyList = null;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        historyList = (ListView)findViewById(R.id.history_list);

        SectionAdapter adapter = new SectionAdapter() {
            @Override
            protected View getHeaderView(String caption, int index, View convertView, ViewGroup parent) {
                TextView result = (TextView) convertView;
                if (convertView == null) {
                    result = (TextView) getLayoutInflater().inflate(R.layout.section_header, null);
                    result.setText(caption);
                }

                return result;
            }
        };

        List<UsageHistory> itemList = new ArrayList<UsageHistory>();
        itemList.add(new UsageHistory());
        itemList.add(new UsageHistory());
        ListItemAdapter itemAdapter = new ListItemAdapter(HistoryViewActivity.this, R.layout.list_item, itemList);

        adapter.addSection("2010/10/10", itemAdapter);
        historyList.setAdapter(adapter);

    }
}
