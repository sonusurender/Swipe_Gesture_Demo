package com.example.swipe_screen_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.widget.Toast;

import com.example.swipe_screen_demo.SimpleGestureFilter.SimpleGestureListener;

public class MainActivity extends AppCompatActivity implements
		SimpleGestureListener {
	private SimpleGestureFilter detector;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Detect touched area
		detector = new SimpleGestureFilter(MainActivity.this, this);
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent me) {
		// Call onTouchEvent of SimpleGestureFilter class
		this.detector.onTouchEvent(me);
		return super.dispatchTouchEvent(me);
	}

	@Override
	public void onSwipe(int direction) {
		
		//Detect the swipe gestures and display toast
		String showToastMessage = "";

		switch (direction) {

		case SimpleGestureFilter.SWIPE_RIGHT:
			showToastMessage = "You have Swiped Right.";
			break;
		case SimpleGestureFilter.SWIPE_LEFT:
			showToastMessage = "You have Swiped Left.";
			break;
		case SimpleGestureFilter.SWIPE_DOWN:
			showToastMessage = "You have Swiped Down.";
			break;
		case SimpleGestureFilter.SWIPE_UP:
			showToastMessage = "You have Swiped Up.";
			break;

		}
		Toast.makeText(this, showToastMessage, Toast.LENGTH_SHORT).show();
	}

	
	//Toast shown when double tapped on screen
	@Override
	public void onDoubleTap() {
		Toast.makeText(this, "You have Double Tapped.", Toast.LENGTH_SHORT)
				.show();
	}

}
