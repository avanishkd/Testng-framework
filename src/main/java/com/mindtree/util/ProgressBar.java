/**
 * 
 */
package com.mindtree.util;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

/**
 * @author m1046875
 *
 */
public class ProgressBar {
	
	final int MAX = 100;

	final JFrame frame;

	// creates progress bar
	final JProgressBar pb = new JProgressBar();
	
	public ProgressBar(String name) {
		
		frame = new JFrame(name);

		pb.setMinimum(0);

		pb.setMaximum(MAX);

		pb.setStringPainted(true);
		
		frame.setLayout(new FlowLayout());
        frame.getContentPane().add(pb);
 
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(100, 100);
        frame.setVisible(true);
	}
	
	public JProgressBar getBar(){
		pb.setValue(0);
		return pb;
	}
}
