package clemente;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.util.Vector;
public class Tabla extends JFrame implements ActionListener {
	JButton Btn,BtnBorrar,BtnModificar;
	JTable tbl ;
	DefaultTableModel modelo;
	public Tabla() {
		super("Mi tabla");
		HazInterfaz();
		HazEscuchas();

	}
	private void HazInterfaz(){
		this.setSize(700,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String [] col={"Código","Nombre","Puesto"};
		tbl = new JTable();
        modelo=new DefaultTableModel();
        modelo.setColumnIdentifiers(col);
        
        tbl.setModel(modelo);
;
		String [] datos={"X","Y","Z"};
		modelo.addRow(datos);		

		for(int i=0 ; i<100 ; i++){

			datos[0]="Cod"+i;
			datos[1]=Rutinas.nextNombre(3);
			datos[2]=i+"";

			modelo.addRow(datos);	

		}
		JScrollPane panel =new JScrollPane(tbl);
		add(panel);
		Btn=new JButton("Recuperar");
		BtnBorrar=new JButton("Borrar");
		BtnModificar=new JButton("Modificar");
		JPanel P=new JPanel();
		P.add(Btn);
		P.add(BtnBorrar);
		P.add(BtnModificar);
		add(P,BorderLayout.SOUTH);
		this.setVisible(true);		

	}
	public void HazEscuchas(){
		Btn.addActionListener(this);
		BtnBorrar.addActionListener(this);
		BtnModificar.addActionListener(this);
	}
	public static void main(String[] args)  {
		new Tabla();
	}
	@Override
	public void actionPerformed(ActionEvent Evt) {
		System.out.println("Renglon "+tbl.getSelectedRow());
		System.out.println("Columna "+tbl.getSelectedColumn());
		
		if (tbl.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null,
					"No ha seleccionado renglón de la tabla", "ISC",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		JButton Aux=(JButton) Evt.getSource();
		switch (Aux.getText()){
		case "Recuperar":
			// recupero cada columna
			String Valor1 = (String) modelo.getValueAt(tbl.getSelectedRow(), 0);
			String Valor2 = (String) modelo.getValueAt(tbl.getSelectedRow(), 1);
			String Valor3 = (String) modelo.getValueAt(tbl.getSelectedRow(), 2);
			System.out.println(Valor1+" "+Valor2+" "+Valor3);
			break;
		case "Borrar":

			modelo.removeRow((int)tbl.getSelectedRow());
			break;
		case "Modificar":
			modelo.setValueAt("modificado", (int)tbl.getSelectedRow(), 2);
		}
	}

	
	
}
