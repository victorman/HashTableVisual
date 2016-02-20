package se.frand.hash;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class HashTableComponent extends JComponent {
	private static final long serialVersionUID = 1L;
	private static final String NIL = "null";
	private String[] values;
	private Integer selected;
	private String key;
	private boolean out;

	
	public synchronized void paintComponent(Graphics g){ 
		if(values == null)
			return;
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		FontMetrics fm = g2.getFontMetrics();
		
		int height = getHeight() / values.length;
		int width = getWidth() / 2;
		
		for(int i=0;i<values.length;i++) {
			Rectangle2D rect = new Rectangle2D.Double(0, 5 + height * i, width, height - 4);
			
			String s = values[i];
			if(s == null)
				s = NIL;
			
			if(selected != null && i == selected) {
				
				g2.setColor(Color.BLUE);
				if(out)
					g2.drawString(s, 5 + getWidth()/2, 5 + height * i + fm.getHeight());
			} else {
				g2.setColor(Color.BLACK);
			}
			g2.drawString(i + ": " + s, 5, 5 + height * i + fm.getHeight());
			
			g2.draw(rect);
		}
		
		g2.setColor(Color.BLACK);
		if(key == null) {
			key = NIL;
		}
		g2.drawString(key, getWidth() - fm.stringWidth(key) - 5, fm.getHeight());
	}
	
	public synchronized void setValues(String[] values, Integer selected, String key, boolean out) {
		this.values = values.clone();
		this.selected = selected;
		this.key = key;
		this.out = out;
		repaint();
	}
}
