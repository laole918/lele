package com.lele.dialog;

import java.util.List;

import com.lele.R;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewDialog extends Dialog {

	private ArrayAdapter<String> adapter;
	private ListView listView;
	private OnItemClickListener mOnItemClickListener;
	
	public ListViewDialog(Context context) {
		super(context, android.R.style.Theme_Translucent_NoTitleBar);
		adapter = new ArrayAdapter<String>(getContext(), R.layout.dialog_list_choose_item);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_list_choose);
		listView = (ListView) findViewById(R.id.listView);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				if(mOnItemClickListener != null) {
					mOnItemClickListener.onItemClick(position);
				}
			}
		});
		
    }
	
    public void setCanceledOnTouchOutside(boolean cancel) {
        super.setCanceledOnTouchOutside(cancel);
		if (!cancel) {
			return;
		}
        View content = findViewById(android.R.id.content);
        content.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ListViewDialog.this.dismiss();
			}
		});
    }
	
	public void addAllItems(List<String> items) {
		if(items != null && !items.isEmpty()) {
			int size = items.size();
			for(int i = 0; i < size; i++) {
				adapter.add(items.get(i));
			}
			adapter.notifyDataSetChanged();
		}
	}
	
	public void addAllItems(String... items) {
		if(items != null && items.length > 0) {
			int size = items.length;
			for(int i = 0; i < size; i++) {
				adapter.add(items[i]);
			}
			adapter.notifyDataSetChanged();
		}
	}
	
	public void clear() {
		adapter.clear();
	}
	
	public void setOnItemClickListener(OnItemClickListener listener) {
		mOnItemClickListener = listener;
	}
	
	public interface OnItemClickListener {
		public void onItemClick(int position);
	}
	
}
