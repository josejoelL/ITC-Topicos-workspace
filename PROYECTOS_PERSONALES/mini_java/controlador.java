package mini_java;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;


public class controlador implements ActionListener, KeyListener {

	// tener guardadas las variables 
	vista vista;
	modelo modelo;
	
	public controlador(vista vista, modelo modelo) {
		this.vista=vista;
		this.modelo=modelo;
	}
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==vista.getBtnEjecuta()){
		
			
			vista.getIdentficador().setText("Iniciar identificacion");
			//poner animacion de carga
			
			
			if (!vista.getPLexico().isDisplayable()) {
				vista.getP3().add(vista.getPLexico());
				vista.getP3().revalidate();
				vista.getP3().repaint();
			}
			//aqui es donde inicia lo chido 
			
			// Parser p = new Parser();
			
			 //Arbol = p.parser();
			
		}
		
		
		
		if(e.getSource()==vista.getGuardar_Archivo()){
			
			
			FileDialog fileDialog = new FileDialog(vista,"Guardar", FileDialog.SAVE);
			 fileDialog.setSize(400,400);
	            fileDialog.setVisible(true);
			//con este solo obtengo el nombre que le quiero dar
	          //no me guarda para eso clemente archivos apenas
	            
	            
			if (!fileDialog.isActive()) {
				String texto = "";
				texto = vista.getTxt().getText();
				//fileDialog.gett
				System.out.println("Se guardo el archivo :"+fileDialog.getFile());
		         System.out.println(texto);
			}
			
            
            return;
		}
		if(e.getSource()==vista.getAbrir_Archivo()){
			FileDialog fileDialog = new FileDialog(vista,"Abrir", FileDialog.LOAD);
			fileDialog.setSize(400,400);
			fileDialog.setVisible(true);
			
			//fileDialog.setFile(null);
			
			if (!fileDialog.isActive()) {
				//desde aqui obtengo el txt en formato file
				if (fileDialog.getFile()==null) {
					return;
				}
				//System.out.println("El archivo de codigo tiene el nombre de : "+fileDialog.getFile());
				File a=new File(fileDialog.getDirectory()+"\\"+fileDialog.getFile());
				//a = fileDialog.getFile();
				print(a);
			} 
			
		
			
			
			/*
			FileReader f=null;
			BufferedReader b = null;
			try {
				 f = new FileReader(fileDialog.getFile());
				 b = new BufferedReader(f);
	
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
					try {
						vista.getTxt().setText(b.readLine());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			*/
			
            
            return;
		}
		
		
/*
		if (e.getSource()== vista.btnCont ){
			
			String texto=vista.getTexto();
			int  Npalabras =modelo.contarPalabras(texto);
				if (texto.equals("")) {
					Npalabras=0;
				}
			vista.setResultado(Npalabras);
			return;
		
		}
			*/
		
	
	}
	private void print(File file) {
		  try{
              
              FileReader lector = new FileReader(file);
              BufferedReader bufer = new BufferedReader(lector);
              String linea = "";
              linea = bufer.readLine();
             
              while((linea = bufer.readLine()) != null){
             
              vista.getTxt().append(linea + "\n");
             
              }
              bufer.close();
              lector.close();
             
             
      }catch(Exception e){
             
      e.printStackTrace();
     
      }
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
	/**
		if(e.getKeyChar() == 'v' ){
			String Cadena = vista.getTxtScan().getText();
			
		vista.getIdentficador().setText(Cadena+"\n\t");

			//vista.getTxtScan().setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);;
		//System.out.println(	"se dio un espacio");
			
	//	vista.getIdentficador().setText("espacio");
		}*/
		/*
			if(text.length()==0){
				setText("0.");
				Evt.consume();
				return;
			}
		*/
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
