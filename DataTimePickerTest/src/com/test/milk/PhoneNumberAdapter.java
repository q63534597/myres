package com.test.milk;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class PhoneNumberAdapter extends ArrayAdapter<PhoneNumber>{

	private int resourceId;
	private List<PhoneNumber> mItemList; 
	private LayoutInflater mInflater;
	private Context mContext;
	 
	public PhoneNumberAdapter(Context context, int textViewResourceId,List<PhoneNumber> objects) 
	{
		super(context, textViewResourceId, objects);
		resourceId = textViewResourceId;
	}
	public void setItemList(List list) {
	        mItemList = list;
	}
	
			@Override
	public View getView(int position, View convertView, ViewGroup parent) {
				
		PhoneNumber pn = getItem(position); // ��ȡ��ǰ���Fruitʵ��
		View view;
		ViewHolder viewHolder;
		if(convertView==null){
			view = LayoutInflater.from(getContext()).inflate(resourceId, null);
			viewHolder = new ViewHolder();
			viewHolder.number = (TextView) view.findViewById(R.id.phonenumber);
			
			view.setTag(viewHolder); // ��ViewHolder�洢��View��
		}
		else
		{
			view = convertView;
			viewHolder = (ViewHolder) view.getTag(); // ���»�ȡViewHolder
		}
		viewHolder.number.setText(pn.getn());
		
		return view;
	}
	class ViewHolder {
		TextView number;
	}

}
