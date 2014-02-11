package com.example.buckaroos;

import com.password.buckaroos.AppPropertyWriter;

import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class Register extends Activity implements OnClickListener {

	EditText etName, etEmail, etPass;
	Button bRegister;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
		initialize();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register, menu);
		return true;
	}
	
	private void initialize() {
		etName = (EditText) findViewById(R.id.etName);
		etEmail = (EditText) findViewById(R.id.etEmail);
		etPass = (EditText) findViewById(R.id.etPass);
		bRegister = (Button) findViewById(R.id.bRegister);
		getActionBar().hide();
		bRegister.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		if(!etName.getText().toString().equals("") && !etEmail.getText().toString().equals("") && !etPass.getText().toString().equals("")) {
			AppPropertyWriter k = new AppPropertyWriter(this);
			k.storeAccountEmailAndPassword(etName.getText().toString(), etPass.getText().toString(), etEmail.getText().toString());
			startActivity(new Intent(Register.this, RegisterSuccess.class));

		} else {
			Toast toast = Toast.makeText(this, "All fields required.", Toast.LENGTH_SHORT);
			toast.show();
		}
	}

}
