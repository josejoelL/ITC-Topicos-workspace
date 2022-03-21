package examen;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

/**
 * Fecha: 6 noviembre 2020 autor: landeros santos jose joel
 * 
 **/
public class Tinaco extends JFrame implements ActionListener {
	private JButton meterAgua, sacarAgua;
	private JLabel[] pila;
	private int glAc;
	private final int NP = 50;
	private int NumMarca;
	private Thread t;

	public Tinaco() {
		super("Nivel liquido de agua");

		HazInterfaz();
		HazEscuchas();
	}

	private void HazInterfaz() {

		
		setSize(300, 750);
		setLocationRelativeTo(null);

		setLayout(new GridLayout(0, 2, 5, 0));

		pila = new JLabel[NP];

		for (int i = 0; i < pila.length; i++) {
			pila[i] = new JLabel();
			pila[i].setOpaque(true);
			pila[i].setBackground(Color.green);
			pila[i].setBorder(new LineBorder(Color.lightGray));

		}
		for (int i = 50; i > 0; i--) {

			add(new JLabel(i + "", SwingConstants.RIGHT));

			add(pila[i - 1]);
		}

		meterAgua = new JButton("Meter agua");
		sacarAgua = new JButton("Sacar agua");

		add(meterAgua);
		add(sacarAgua);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void HazEscuchas() {
		meterAgua.addActionListener(this);
		sacarAgua.addActionListener(this);

	}

	public static void main(String a[]) {
		new Tinaco();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == meterAgua) {

			pila[NumMarca].setBackground(Color.green);
			pila[NumMarca].setText("");

			glAc += randomLts() / 4;

			NumMarca = glAc / 200;

			pila[NumMarca].setBackground(Color.yellow);
			pila[NumMarca].setText("       " + glAc % 200 + " galones");

			for (int i = 0; i < NumMarca; i++) {
				pila[i].setBackground(Color.red);
				pila[i].setText("");
				pila[i].update(pila[i].getGraphics());
			}

			if (NumMarca > 47) {
				for (int i = glAc % 200; i > 0; i--) {

					pila[NumMarca].setBackground(Color.LIGHT_GRAY);
					pila[NumMarca].setText("vaciando..." + glAc % 200);

					glAc--;
					NumMarca = glAc / 200;

					pila[NumMarca].update(pila[NumMarca].getGraphics());
					try {
						Thread.sleep(40);
					} catch (InterruptedException er) {
						er.printStackTrace();
					}

				}
				pila[NumMarca].setBackground(Color.green);
				pila[NumMarca].setText("lleno");

			}

			return;
		}

		if (e.getSource() == sacarAgua) {

			pila[NumMarca].setBackground(Color.green);
			pila[NumMarca].setText("");

			glAc -= randomLts() / 4;
			NumMarca = glAc / 200;

			if (glAc <= 0)
				glAc = 0;

			pila[NumMarca].setBackground(Color.yellow);
			pila[NumMarca].setText("       " + glAc % 200 + " galones");

			return;
		}

	}

	private int randomLts() {
		Random R = new Random();
		return R.nextInt(800);
	}
}
