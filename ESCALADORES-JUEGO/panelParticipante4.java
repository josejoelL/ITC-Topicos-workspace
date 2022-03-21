package Escalador;
import java.awt.*;
	import java.awt.event.*;

	

public	class panelParticipante4  extends Panel
	{
	    public void paint(Graphics g)
	    {
	        g.setColor(Color.red);
	        g.fillRect(10,12,300,150);
	    }
	    
	    public static void main(String args[])
	    {
	        Frame f=new Frame();
	        f.add(new myframe());
	        
	        
	        f.setSize(400,400);
	        f.setVisible(true);
	        
	    }
	}

