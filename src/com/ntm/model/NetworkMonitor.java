package com.ntm.model;

//Java Program to Ping an IP address 
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.ntm.view.NetworkMonitorGUI;

public class NetworkMonitor extends TimerTask {

	//Load Device properties from 'devices.csv' file
	private static List<DeviceWrapper> loadDeviceProperties() throws FileNotFoundException, IOException{
		List<DeviceWrapper> devices = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("devices.csv"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(",");
		        devices.add(new DeviceWrapper(values));
		    }
		}
		return devices;	
	}
	
	// Sends ping request to a provided IP address
	public static boolean sendPingRequest(DeviceWrapper deviceWrapper) throws UnknownHostException, IOException {
		InetAddress geek = InetAddress.getByName(deviceWrapper.getIpAddress());
		NetworkInterface network = NetworkInterface.getByInetAddress(geek);
		/*byte[] mac = network.getHardwareAddress();
		System.out.print("Current MAC address : ");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < mac.length; i++) {
			sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
		}
		System.out.println(sb.toString());*/
		System.out.println("Sending Ping Request to " + deviceWrapper.getIpAddress());
		if (geek.isReachable(5000)) {
			System.out.println("Host, " + deviceWrapper.toString() + ", is reachable\n");
			return true;
		}
		else{
			System.out.println("Sorry ! We can't reach to the host " + deviceWrapper.toString() + "\n");
			return false;
		}
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
//		String ipAddress = "192.168.1.34";
		try {
			List<DeviceWrapper> devices = loadDeviceProperties();
			for (DeviceWrapper deviceWrapper : devices) {
				if(!sendPingRequest(deviceWrapper)){
					// Fire event to client(gui) or update client with failed device
					// gui.updateListItem(deviceWrapper, false);
				}
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}