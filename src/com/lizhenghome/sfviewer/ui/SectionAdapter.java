package com.lizhenghome.sfviewer.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Adapter;
import android.widget.TextView;
import com.lizhenghome.sfviewer.util.Util;

import java.util.ArrayList;
import java.util.List;


public abstract class SectionAdapter extends BaseAdapter {

    class Section {
        String caption;
        Adapter adapter;

        Section(String caption, Adapter adapter) {
            this.caption = caption;
            this.adapter = adapter;
        }
    }

    public static final int ITEM_TYPE_HEADER = 0;

    private List<Section> sections = new ArrayList<Section>();

    public SectionAdapter() {
        super();
    }

    public void addSection(String caption, BaseAdapter adaptor) {
        Section section = new Section(caption, adaptor);
        sections.add(section);
    }

    public Object getItem(int position) {
        for (Section section : sections) {
            if(position == 0) {
                return section;
            }

            int size = section.adapter.getCount() + 1;
            if(position < size) {
                return section.adapter.getItem(position - 1);
            } else {
                position -= size;
            }
        }

        return null;
    }

    public int getCount() {
       int count = 0;
       for (Section section: sections) {
           count += section.adapter.getCount() + 1;
       }

       return count;
    }

    public int getItemViewType(int position) {
        for( Section section : sections) {
            if(position == 0) {
                return ITEM_TYPE_HEADER;
            }

            int count = section.adapter.getCount() + 1;
            if(position < count) {
                return section.adapter.getItemViewType(position - 1);
            } else {
                position -= count;
            }

        }
        return ITEM_TYPE_HEADER;
    }

    public int getViewTypeCount() {
        int count = 1; // one for the header, plus those from sections

        for (Section section : this.sections) {
           count += section.adapter.getViewTypeCount();
        }

        return count;
    }

    public boolean areAllItemsEnabled() {
        return false;
    }

    public boolean isEnabled(int position) {
        return (getItemViewType(position) != ITEM_TYPE_HEADER);
    }

    public View getView (int position, View convertView, ViewGroup parent) {
        int sectionIndex = 0;

        for (Section section : this.sections) {
            if (position == 0) {
                return (getHeaderView(section.caption, sectionIndex, convertView, parent));
            }


            int size = section.adapter.getCount() + 1;
            if (position < size) {
                return (section.adapter.getView(position - 1, convertView, parent));
            }

            position -= size;
            sectionIndex++;
        }
        return null;
    }

    public long getItemId(int position) {
        return position;
    }

    abstract protected View getHeaderView(String caption, int index, View convertView, ViewGroup parent);
}
