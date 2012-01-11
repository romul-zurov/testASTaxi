package com.github.testastaxi;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class TestASTaxiActivity extends Activity {

	private EditText text;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		text = (EditText) findViewById(R.id.editText1);
	}

	public void startClick(View view) {
		switch (view.getId()) {
		case R.id.button_start:
			text.setText(R.string.version);
			break;
		case R.id.button_stop:
			text.setText("");
		}
	}

}