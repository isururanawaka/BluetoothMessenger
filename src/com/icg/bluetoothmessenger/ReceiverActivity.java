package com.icg.bluetoothmessenger;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ReceiverActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		 setContentView(R.layout.receiver);
		 TextView from = (TextView) findViewById(R.id.from_txt);
		 EditText msgBox = (EditText) findViewById(R.id.msg_box);
		 
		 Bundle extras = getIntent().getExtras();
		 from.setText(extras.getString("sender"));
		 msgBox.setText(extras.getString("message"));
	}
}
