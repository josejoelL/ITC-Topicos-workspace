package material_clase;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SinLayout extends JFrame implements ActionListener {
    private JLabel lbl1,lbl2,lbl3;
    private JTextField txt1,txt2,txt3;
    JButton btnRecuperar,btnGrabar,btnBorrar, btnModificar,btnConsultar;
	public SinLayout() {
		super("sin layout activo");
		HazInterfaz();
		HazEscuchas();
	}
	private void HazInterfaz() {
		setLayout(null);
		setLayout(new GridLayout(0,2));
		setSize(350,250);
		//this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		lbl1=new JLabel("RFC :",SwingConstants.RIGHT);
		lbl2=new JLabel("Nombre :",SwingConstants.RIGHT);
		lbl3=new JLabel("Edad :",SwingConstants.RIGHT);
		
		lbl1.setBounds(15,10,50,10);
		lbl2.setBounds(15,30,55,10);
		lbl3.setBounds(15,50,50,10);
		txt1=new JTextField();
		txt2=new JTextField();
		txt3=new JTextField();
		
		txt1.setBounds(70,10,160,20);
		txt2.setBounds(70,30,160,20);
		txt3.setBounds(70,50,160,20);
		btnRecuperar=new JButton("Recuperar");
		btnGrabar=new JButton("Grabar");
		btnBorrar=new JButton("Borrar");
		btnModificar=new JButton("Modificar");
		btnConsultar=new JButton("Consultar");
		
		btnRecuperar.setBounds(15,80,90,40);
		btnGrabar.setBounds(110,80,90,40);
		
		btnBorrar.setBounds(15,125,90,40);
		btnModificar.setBounds(110,125,90,40);
		
		btnConsultar.setBounds(80,170,90,40);
		add(lbl1);
		add(txt1);
		add(lbl2);
		add(txt2);
		add(lbl3);
		
		
		
		add(txt3);
		
		add(btnRecuperar);
		add(btnGrabar);
		add(btnBorrar);
		add(btnModificar);
		add(btnConsultar);
		
		
		
		setVisible(true);
	}
	private void HazEscuchas() {
		btnRecuperar.addActionListener(this);
		btnGrabar.addActionListener(this);
		
	
	}
	public static void main(String [] a) {
		new SinLayout();
	}
	@Override
	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource()==btnRecuperar) {
			ImageIcon imagenAjustada=Rutinas.AjustarImagen("Caballo.jpg", btnRecuperar.getWidth(), btnRecuperar.getHeight());
			//btnRecuperar.setIcon(new ImageIcon("CABALLO.JPG"));
			btnRecuperar.setIcon(imagenAjustada);
			return;
		}
		if(evt.getSource()==btnGrabar) {
			
			btnGrabar.setIcon(Rutinas.AjustarImagen("grabar.png",btnGrabar.getWidth(),btnGrabar.getHeight()));
			return;
		}
		
	}
}
