package com.example.puzzlewizard;

import com.example.puzzlewizard.StateMachine.State;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.view.Menu;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

public class Villager extends Activity{
	
	private int tens = 0;
	private int ones = 0;
	private int hundreds = 0;
	private int answer = -1;
	
	@SuppressLint("NewApi")
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_villager);
		createConvoStart();
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_screen, menu);
		return true;
	}
	
	@SuppressLint("NewApi")
	public void createConvoStart(){
		TextView start = (TextView) findViewById(R.id.maintext);
		start.setText("Wizard, could you help me solve this question?");
		Button yes = (Button) findViewById(R.id.yes_button);
		yes.setText("Only if you pay me.");
		yes.setY(100);
		Button no = (Button) findViewById(R.id.no_button);
		no.setText("I'm too busy for this. Figure it out yourself.");
		no.setY(200);
		Button one = (Button) findViewById(R.id.ones_button);
		one.setVisibility(View.INVISIBLE);
		Button ten = (Button) findViewById(R.id.tens_button);
		ten.setVisibility(View.INVISIBLE);
		Button hundred = (Button) findViewById(R.id.hundreds_button);
		hundred.setVisibility(View.INVISIBLE);
		Button oneup = (Button) findViewById(R.id.onesup_button);
		oneup.setVisibility(View.INVISIBLE);
		Button tenup = (Button) findViewById(R.id.tensup_button);
		tenup.setVisibility(View.INVISIBLE);
		Button hundredup = (Button) findViewById(R.id.hundredsup_button);
		hundredup.setVisibility(View.INVISIBLE);
		Button onedown = (Button) findViewById(R.id.onesdown_button);
		onedown.setVisibility(View.INVISIBLE);
		Button tendown = (Button) findViewById(R.id.tensdown_button);
		tendown.setVisibility(View.INVISIBLE);
		Button hundreddown = (Button) findViewById(R.id.hundredsdown_button);
		hundreddown.setVisibility(View.INVISIBLE);
		Button submit = (Button) findViewById(R.id.submit);
		submit.setVisibility(View.INVISIBLE);
		Button restart = (Button) findViewById(R.id.restart);
		restart.setVisibility(View.INVISIBLE);
	}
	
	public void endPuzzle(View view){
		MainActivity.state.setState(State.Field);
		Intent intent = new Intent(this, Screen.class);
    	startActivity(intent);
	}
	
	@SuppressLint("NewApi")
	public void beginPuzzle(View view){
		this.createQuestion();
		Button yes = (Button) findViewById(R.id.yes_button);
		yes.setVisibility(View.INVISIBLE);
		Button submit = (Button) findViewById(R.id.submit);
		submit.setText("My answer is perfect.");
		submit.setY(100);
		submit.setVisibility(View.VISIBLE);
		Button no = (Button) findViewById(R.id.no_button);
		no.setText("I don't have a clue.");
		Button oneup = (Button) findViewById(R.id.onesup_button);
		oneup.setY(100);
		oneup.setX(900);
		oneup.setText("+");
		Button tenup = (Button) findViewById(R.id.tensup_button);
		tenup.setY(100);
		tenup.setX(700);
		tenup.setText("+");
		Button hundredup = (Button) findViewById(R.id.hundredsup_button);
		hundredup.setY(100);
		hundredup.setX(500);
		hundredup.setText("+");
		Button one = (Button) findViewById(R.id.ones_button);
		one.setY(200);
		one.setX(900);
		one.setText("0");
		Button ten = (Button) findViewById(R.id.tens_button);
		ten.setY(200);
		ten.setX(700);
		ten.setText("0");
		Button hundred = (Button) findViewById(R.id.hundreds_button);
		hundred.setY(200);
		hundred.setX(500);
		hundred.setText("0");
		Button onedown = (Button) findViewById(R.id.onesdown_button);
		onedown.setY(300);
		onedown.setX(900);
		onedown.setText("-");
		Button tendown = (Button) findViewById(R.id.tensdown_button);
		tendown.setY(300);
		tendown.setX(700);
		tendown.setText("-");
		Button hundreddown = (Button) findViewById(R.id.hundredsdown_button);
		hundreddown.setY(300);
		hundreddown.setX(500);
		hundreddown.setText("-");
		one.setVisibility(View.VISIBLE);
		ten.setVisibility(View.VISIBLE);
		hundred.setVisibility(View.VISIBLE);
		oneup.setVisibility(View.VISIBLE);
		tenup.setVisibility(View.VISIBLE);
		hundredup.setVisibility(View.VISIBLE);
		onedown.setVisibility(View.VISIBLE);
		tendown.setVisibility(View.VISIBLE);
		hundreddown.setVisibility(View.VISIBLE);
	}
	
	public void createQuestion(){
			String newText = "";
			double x = Math.random() * 5;
			int val = (int) x;
			switch(val)
			{
			case 1:
				newText = "A man finds  small iron coin dated 154 B.C What's it worth?";
				answer = 0;
				break;
			case 2:
				newText = "How many letters are in the alphabet?";
				answer = 11;
				break;
			case 3:
				newText = "You have a cube made of 10x10x10 smaller cubes, for a total of 1000 smaller cubes. If you take off 1 layer of cubes, how many will remain?";
				answer = 512;
				break;
			case 4:
				newText = "What number do you get when you multiply all the numbers on a telephone pad?";
				answer = 0;
				break;
			case 5:
				newText = "John has been hired to paint the numbers 1 through 100 on 100 apartments. How many times will he paint 8?";
				answer = 20;
				break;
			default:
				newText = "There are 3 switches for 3 light bulbs upstairs. How many times do you need to look to figure which switch is with which bulb?";
				answer = 1;
			}
			
			TextView start = (TextView) findViewById(R.id.maintext);
			start.invalidate();
			start.setText(newText);
	}
	
	public void addOnes(View view){
		if(this.ones < 10)
			this.ones++;
		Button one = (Button) findViewById(R.id.ones_button);
		one.setText(""+ones);
	}
	
	public void addTens(View view){
		if(this.tens < 10)
			this.tens++;
		Button ten = (Button) findViewById(R.id.tens_button);
		ten.setText(""+tens);
	}
	
	public void addHundreds(View view){
		if(this.hundreds < 10)
			this.hundreds++;
		Button hundred = (Button) findViewById(R.id.hundreds_button);
		hundred.setText(""+hundreds);
	}
	
	public void subOnes(View view){
		if(this.ones > 0)
			this.ones--;
		Button one = (Button) findViewById(R.id.ones_button);
		one.setText(""+ones);
	}
	
	public void subTens(View view){
		if(this.tens > 0)
			this.tens--;
		Button ten = (Button) findViewById(R.id.tens_button);
		ten.setText(""+tens);
	}
	
	public void subHundreds(View view){
		if(this.hundreds > 0)
			this.hundreds--;
		Button hundred = (Button) findViewById(R.id.hundreds_button);
		hundred.setText(""+hundreds);
	}
	
	@SuppressLint("NewApi")
	public void Restart(View view)
	{
		Button restart = (Button) findViewById(R.id.restart);
		restart.setVisibility(View.INVISIBLE);
		Button submit = (Button) findViewById(R.id.submit);
		submit.setText("My answer is perfect.");
		submit.setY(100);
		submit.setVisibility(View.VISIBLE);
		Button no = (Button) findViewById(R.id.no_button);
		no.setText("I don't have a clue.");
	}
	
	@SuppressLint("NewApi")
	public void submitAnswer(View view){
		int ans = hundreds*100 + tens*10 + ones;
		if(ans == answer)
		{
			MainActivity.user.setXP(MainActivity.user.getXP()+10);
			MainActivity.user.setHP(MainActivity.user.getHP()+5*MainActivity.user.getLevel());
			MainActivity.state.setState(State.Field);
			Intent intent = new Intent(this, Screen.class);
	    	startActivity(intent);
		}
		else
		{
			Button submit = (Button) findViewById(R.id.submit);
			submit.setVisibility(view.INVISIBLE);
			Button restart = (Button) findViewById(R.id.restart);
			restart.setText("I'll get it this time.");
			restart.setVisibility(view.VISIBLE);
			restart.setY(100);
			Button one = (Button) findViewById(R.id.ones_button);
			one.setText("0");
			Button ten = (Button) findViewById(R.id.tens_button);
			ten.setText("0");
			Button hundred = (Button) findViewById(R.id.hundreds_button);
			hundred.setText("0");
			this.tens = 0;
			this.ones = 0;
			this.hundreds = 0;
		}
	}
	
}
