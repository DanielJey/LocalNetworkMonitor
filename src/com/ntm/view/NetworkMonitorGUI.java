package com.ntm.view;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class NetworkMonitorGUI {

	private JFrame gui1;
	private JList b;

	public NetworkMonitorGUI() {

		gui1 = new JFrame("Watch & Pray");
		// GridLayout gridLayout = new GridLayout(1,2);

		gui1.setLayout(new GridLayout(1, 2));
		// create a panel
		JPanel p = new JPanel();

		// create a new label
		JLabel l = new JLabel("select");

		// String array to store weekdays
		String week[] = { "Monday", "Tuesday", "Wednesday", "Thursday",
				"Friday", "Saturday", "Sunday" };
		b = new JList(week);
		b.setSelectedIndex(0);

		p.add(b);

		gui1.add(p, 0, 0);

		gui1.setSize(1024, 768);
		gui1.setVisible(true);
		// Exit the application when the window is closed
		gui1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui1.setLocationRelativeTo(null); // Center window on screen
	}

}