package componentes;

import java.awt.Color;

import java.awt.GridLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class HannoiGrafico  extends JPanel implements ComponentListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x,y,w,h,n;
	private JTextField [] vc;
	
	private JButton startBtn;
	private Deslizador D;
	private hanoiCanvas C;
//	public material_clase.Graphic2d G;
	public HannoiGrafico(int n){
		this.n=n;
		D=new Deslizador("Discos", 3, 9, n, JSlider.HORIZONTAL);
		C=new hanoiCanvas(n);
		//G= new Graphic2d();
		HazInterfaz();
		HazEscuchas();
	}
	private void HazInterfaz(){
		setLayout(null);
		//this.setPreferredSize(new Dimension(100,100));
		this.setSize(100,100);
		
		
		this.setBorder(new LineBorder(Color.blue));
		
		w = getWidth();
		h = getHeight();
	//	for(int i=0 ; i< vc.length; i++){
		//	vc[i]=new JTextField();
//			vc[i].setSize(w-20,20);
//			vc[i].setLocation(10,5+i*20);
//			add(vc[i]);
	//	}
		 startBtn=new JButton("start");
		 
		//D.setSize(w-10, 20);
	//	add(D);
	//	add(startBtn);
		
	}
	private void HazEscuchas(){
		this.addComponentListener(this);
	}

	
	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void componentMoved(ComponentEvent e) {
		
		x = getX();
		y = getY();
	}
	@Override
	public void componentResized(ComponentEvent e) {
		//this.removeAll();
		
		w = getWidth();
		h = getHeight();
		/*
		for(int i=0 ; i< vc.length; i++){
		//	vc[i]=new JTextField();
			vc[i].setSize((int)(w*0.80),20);//w-20
			vc[i].setLocation((int)(w*0.10),5+i*20);
			add(vc[i]);
		}	*/	
		
		
		C.setSize((int) (w*0.50),(int) (h*0.90));
		C.setLocation( (int)(w*0.01 ),(int)(h*0.02));
		
//		G.setSize((int) (w*0.50),(int) (h*0.90));
//		G.setLocation( (int)(w*0.01 ),(int)(h*0.02));
		
		
		D.setSize((int) (w*0.25),(int) (w*0.15));
		D.setLocation( (int)(w*0.02 +w*0.70 ),(int)(h*0.02));
		//System.out.println(this);
		
		startBtn.setSize((int) (w*0.12),(int) (w*0.03));
		startBtn.setLocation( (int)(w*0.12+w*0.45 ),(int)(h*0.50));
		startBtn.grabFocus();
		add(D);
		add(startBtn);
	}
	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
	
	}

	class Deslizador extends JPanel implements ChangeListener {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		String originalLabel;
		JLabel label;
		JSlider slider;

		Deslizador(String labelString, int minValue, int maxValue, int tickSpacing, int orientation) {
			this.originalLabel = labelString;
			if (orientation == JSlider.HORIZONTAL) {
				setLayout(new GridLayout(2, 1));
			} else {
				setLayout(new GridLayout(1, 2));
			}

			slider = new JSlider(orientation, minValue, maxValue, minValue);
			slider.setMajorTickSpacing(tickSpacing);
			slider.setPaintTicks(true);
			slider.setPaintLabels(true);
			slider.addChangeListener(this);

			add(label = new JLabel());
			add(slider);

			// setValue(minValue);
			setValue(minValue);
		}

		public void stateChanged(ChangeEvent e) {
			JSlider source = (JSlider) e.getSource();
			if (!source.getValueIsAdjusting()) {
				label.setText(originalLabel + " " + Integer.toString(getValue()));
			}
		}

		int getValue() {
			return (int) slider.getValue();
		}

		void setValue(int value) {
			label.setText(originalLabel + " " + Integer.toString(value));
			slider.setValue(value);
		}
	}
}
