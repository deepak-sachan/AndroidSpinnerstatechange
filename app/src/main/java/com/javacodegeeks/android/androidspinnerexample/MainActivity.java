package com.javacodegeeks.android.androidspinnerexample;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
 
public class MainActivity extends Activity {
 
  private Spinner spinner1, spinner2;
  private Button button;
	String selectitem;
	List<String> list = new ArrayList<String>();
  @Override
  public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.main);
	  spinner2 = (Spinner) findViewById(R.id.spinner2);

	addListenerOnButton();
	addListenerOnSpinnerItemSelection();


	  final ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list);
	  dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	  spinner2.setAdapter(dataAdapter);

	  spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
		  @Override
		  public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

			  selectitem = parent.getItemAtPosition(position).toString();
			  if(selectitem.equals("India")){
                  list.clear();
				  list.add("Delhi");

			  }else if(selectitem.equals("France")){
				  list.clear();
				  list.add("Paris");
			  }
			  dataAdapter.notifyDataSetChanged();

			  spinner2.setAdapter(dataAdapter);
		  }

		  @Override
		  public void onNothingSelected(AdapterView<?> parent) {

		  }
	  });
  }

 
  public void addListenerOnSpinnerItemSelection() {
	spinner1 = (Spinner) findViewById(R.id.spinner1);
	spinner1.setOnItemSelectedListener(new MyOnItemSelectedListener());
  }
 
  public void addListenerOnButton() {
 
	spinner1 = (Spinner) findViewById(R.id.spinner1);
	spinner2 = (Spinner) findViewById(R.id.spinner2);
	button = (Button) findViewById(R.id.button);
 
	button.setOnClickListener(new OnClickListener() {
 
	  @Override
	  public void onClick(View v) {
 
	    Toast.makeText(MainActivity.this,
		"Result : " + 
                "\nSpinner 1 : "+ String.valueOf(spinner1.getSelectedItem()) + 
                "\nSpinner 2 : "+ String.valueOf(spinner2.getSelectedItem()),
			Toast.LENGTH_SHORT).show();
	  }
 
	});
  }
}