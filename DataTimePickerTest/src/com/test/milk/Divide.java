package com.test.milk;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment; 
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;





import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;


 public class Divide extends FragmentActivity {
	 	
	 	String id;
	 	TextView saveid;
		//����FragmentTabHost����
		private FragmentTabHost mTabHost;
		
		//����һ������
		private LayoutInflater layoutInflater;
			
		//�������������Fragment����
		private Class fragmentArray[] = {FregIndex.class,FregCall.class,FregMess.class,FregApp.class,FregShare.class};
		
		//������������Ű�ťͼƬ
		private int mImageViewArray[] = {R.drawable.tab_index,R.drawable.tab_call,R.drawable.tab_mess,
										 R.drawable.tab_app,R.drawable.tab_share};
		
		//Tabѡ�������
		private String mTextviewArray[] = {"��ҳ", "�绰", "����", "Ӧ��", "����"};
		
		public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	        setContentView(R.layout.divide);
	        
	        Intent intent = getIntent();
	        id = intent.getStringExtra("ID");
	        //Check if permission enabled
	        if (Build.VERSION.SDK_INT >= 21) {
		        if (UStats.getUsageStatsList(this).isEmpty()){
		            intent = new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS);
		            startActivity(intent);
		        }
	        }
	        saveid = (TextView)findViewById(R.id.myid);
	        saveid.setText(id);
	        
	        initView();
	    }
		 
		/**
		 * ��ʼ�����
		 */
		private void initView(){
			//ʵ�������ֶ���
			layoutInflater = LayoutInflater.from(this);
					
			//ʵ����TabHost���󣬵õ�TabHost
			mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
			mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);	
			
			//�õ�fragment�ĸ���
			int count = fragmentArray.length;	
					
			for(int i = 0; i < count; i++){	
				//Ϊÿһ��Tab��ť����ͼ�ꡢ���ֺ�����
				TabSpec tabSpec = mTabHost.newTabSpec(mTextviewArray[i]).setIndicator(getTabItemView(i));
				//��Tab��ť���ӽ�Tabѡ���
				mTabHost.addTab(tabSpec, fragmentArray[i], null);
				//����Tab��ť�ı���
				mTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.selector_tab_background);
			}
		}
					
		/**
		 * ��Tab��ť����ͼ�������
		 */
		private View getTabItemView(int index)
		{
			View view = layoutInflater.inflate(R.layout.tab_item_view, null);
		
			ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
			imageView.setImageResource(mImageViewArray[index]);
			
			TextView textView = (TextView) view.findViewById(R.id.textview);		
			textView.setText(mTextviewArray[index]);
		
			return view;
		}

	 

}