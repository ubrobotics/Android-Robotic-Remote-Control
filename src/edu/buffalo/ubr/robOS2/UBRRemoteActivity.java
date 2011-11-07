package edu.buffalo.ubr.robOS2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class UBRRemoteActivity extends Activity {

	private TextView txtX, txtY;
	private JoystickView joystick;
	private TCPConnection _tcp;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.joystick);

		txtX = (TextView)findViewById(R.id.TextViewX);
        txtY = (TextView)findViewById(R.id.TextViewY);
        joystick = (JoystickView)findViewById(R.id.joystickView);
        
        joystick.setOnJostickMovedListener(_listener);
        _tcp = new TCPConnection();
        
        _tcp.sendFwdVelocity(0);
        _tcp.sendRotVelocity(0);
	}
	

    private JoystickMovedListener _listener = new JoystickMovedListener() {

		//@Override
		public void OnMoved(int rotation, int forward) {
			txtX.setText("    " + Integer.toString(-forward * 10));
			txtY.setText("    " + Integer.toString(rotation * 10));
			_tcp.sendFwdVelocity(-(forward * 10));
			_tcp.sendRotVelocity((rotation * 10));
		}

		//@Override
		public void OnReleased() {
			txtX.setText("released");
			txtY.setText("released");
	        _tcp.sendFwdVelocity(0);
	        _tcp.sendRotVelocity(0);
		}
		
		public void OnReturnedToCenter() {
			txtX.setText("stopped");
			txtY.setText("stopped");
	        _tcp.sendFwdVelocity(0);
	        _tcp.sendRotVelocity(0);
		};
	}; 

}
