package edu.buffalo.ubr.robOS2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import android.util.Log;

public class TCPConnection {
	private InetAddress _svrAddress;
	private Socket _socket;
	private int _port = 5993;
	private PrintWriter _outputWriter;
	
	public TCPConnection() {
		try {
			_svrAddress = InetAddress.getByName("192.168.1.103");
			Log.d("TCP", "Connecting...");
			
			_socket = new Socket(_svrAddress, _port);
			
			String message = "AndroidClient";
			
			Log.d("TCP", "C: Sending: '" + message + "'");
			
			_outputWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(_socket.getOutputStream())),true);

			_outputWriter.println(message);
			Log.d("TCP", "C: Sent.");
			Log.d("TCP", "C: Done."); 
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void sendFwdVelocity(int velocity){
		String vel = Integer.toString(velocity);
		if(vel.length() == 1){
			vel = "00" + vel;
		} else if(vel.length() == 2){
			vel = "0" + vel;
		}
		_outputWriter.println("fvel" + vel);		
	}
	
	public void sendRotVelocity(int velocity){
		String vel = Integer.toString(velocity);
		if(vel.length() == 1){
			vel = "00" + vel;
		} else if(vel.length() == 2){
			vel = "0" + vel;
		}
		_outputWriter.println("rvel" + vel);		
	}

	
	public static void main(String[] args) {
		new TCPConnection();
	}

}
