package se.frand.hash;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class HashTest {
	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 600;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		HashTableComponent component = new HashTableComponent();

		frame.add(component, BorderLayout.CENTER);
		
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setVisible(true);
		
		Runnable r = new HashRunnable(component);
		Thread t = new Thread(r);
		t.start();
	}
}
