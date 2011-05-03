package com.bigo.autocomplete;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.AdapterView.OnItemClickListener;


public class MyAutocomplete extends Activity implements OnClickListener, OnItemClickListener{
	private AutoCompleteTextView 	m_ACTextView;
	private Button			 		m_BTspinner;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.autocomplete_6);

		m_ACTextView	= (AutoCompleteTextView) findViewById(R.id.edit);
		m_BTspinner		= (Button)findViewById(R.id.IB_spinner);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.item_drop_down_text, COUNTRIES);
		m_ACTextView.setAdapter(adapter);
		m_ACTextView.setOnItemClickListener(this);
		m_BTspinner.setOnClickListener(this);
	}

	static final String[] COUNTRIES = new String[] {
		"��ü", "����/�����", "�ǰ�/���", "����/�ݷ�", "�̺�/����",
		"����/ȸ��", "ȸ�纰", "����/Ŀ�´�Ƽ", "�ų�/�۳�/����", "19��",
		"��Ÿ"
	};

	private boolean m_bShowDropDown = false;
	@Override
	public void onClick(View v) {
		Log.d("@@@@@@@@@@","PopupShow: "+ m_ACTextView.getDropDownAnchor());
		if(m_bShowDropDown == false){
			m_ACTextView.showDropDown();
			m_bShowDropDown = true;
		}else{
			m_ACTextView.dismissDropDown();
			m_bShowDropDown = false;
		}
	}


	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		m_BTspinner.setText(m_ACTextView.getText());
	}
}