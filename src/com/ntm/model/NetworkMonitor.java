package com.ntm.model;

//Java Program to Ping an IP address 
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Timer;
import java.util.TimerTask;

import com.ntm.view.NetworkMonitorGUI;

public class NetworkMonitor extends TimerTask {

	// Sends ping request to a provided IP address
	public static void sendPingRequest(String ipAddress) throws UnknownHostException, IOException {
		InetAddress geek = InetAddress.getByName(ipAddress);
		NetworkInterface network = NetworkInterface.getByInetAddress(geek);
		/*byte[] mac = network.getHardwareAddress();
		System.out.print("Current MAC address : ");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < mac.length; i++) {
			sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
		}
		System.out.println(sb.toString());*/
		System.out.println("Sending Ping Request to " + ipAddress);
		if (geek.isReachable(5000)) {
			System.out.println("Host is reachable\n");
		}
		else
			System.out.println("Sorry ! We can't reach to this host\n");
	}

	// Driver code
	public static void main(String[] args) throws UnknownHostException, IOException {

		NetworkMonitorGUI gui = new NetworkMonitorGUI();

		Timer timer = new Timer();
		timer.schedule(new NetworkMonitor(), 0, 5000);

		/*
		 * String ipAddress = "192.168.1.52";
		 * sendPingRequest(ipAddress);
		 * 
		 * ipAddress = "192.168.1.34";
		 * sendPingRequest(ipAddress);
		 * 
		 * ipAddress = "133.192.31.42";
		 * sendPingRequest(ipAddress);
		 */
	}

	@Override
	public void run() {
		String ipAddress = "192.168.1.34";
		try {
			sendPingRequest(ipAddress);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}