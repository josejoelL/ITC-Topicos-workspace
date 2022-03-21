package GRUD;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Vector;






public class ManejoArchivos {
	RandomAccessFile arch1;
	RandomAccessFile arch2;
	//arch 1, rfc, nregistro, estatus
	//arch 2, nombre,edad,idCiudad
	
	
	public void abrirIndice() {
		try {
			arch1=new RandomAccessFile("indice.dat","rw");
		}catch(Exception e) {}
	}
	
	public void cerrarIndice() {
		try {
			arch1.close();
		}catch(Exception e) {}
	}
	public void abrirClientes() {
		try {
			arch2=new RandomAccessFile("CLIENTES.dat","rw");
		}catch(Exception e) {}
	}
	
	public void cerrarClientes() {
		try {
			arch2.close();
		}catch(Exception e) {}
	}
	
	public boolean registrarCliente(Cliente cliente) {
		try {
			arch2.seek(arch2.length());
			arch2.writeUTF(Rutinas.PonBlancos(cliente.getNombre(),40));
			arch2.writeInt(cliente.getEdad());
			arch2.writeInt(cliente.getIdCiudad());
		}catch(Exception e) {return false;}
		return true;
	}
	public boolean registrarIndice(Indice indice) {
		try {
			arch1.seek(arch1.length());
			arch1.writeUTF(Rutinas.PonBlancos(indice.getRfc(),10));	
			arch1.writeInt(indice.getNregistro());
			arch1.writeBoolean(true);
		}catch(Exception e) {return false;}
		return true;
	}
	/*
	public boolean OrdenarIndice(Vector<Indice> v) {
		try {
		for (int i = 0; i < v.size(); i++) {
			for (int j = i+1; i < v.size(); j++) {
				//(i*lr)
				arch1.seek(i*Indice.LARGO);
				//recuperan los tres atributo
				arch1.seek(j*Indice.LARGO);
				//recuperan los tres atributo
				
				if (rfci.compareTo(rfcj)>0) {
					arch1.seek(i*Indice.LARGO);
					//graban los atributo i
					arch1.seek(j*Indice.LARGO);
					//graban los atributo j
					Vector <Indice> aux =new Vector<Indice>();
					aux=v.[i];
					v[i]=v[j];
					v[j]=aux;
					
				}
			}
		}	
		}catch(Exception e) {return false;}
		return true;
	}*/
	
	//secuencial
	public Vector<Cliente> consultarClientes() {
		
		Vector<Cliente> ac=new Vector<Cliente>();
		try {
			int ndatos=(int) (arch2.length()/Cliente.LARGO);
			for(int i=0 ; i<ndatos ; i++) {
				arch2.seek(i*Cliente.LARGO+27+27+4);
				if(!arch2.readBoolean())
					continue;
				arch2.seek(i*Cliente.LARGO);
				ac.add(new Cliente(arch2.readUTF().trim(),arch2.readInt(),arch2.readInt()));
			}
		}catch(Exception e) {}
		return ac;
	}
	
	
	public Vector<Indice> consultarIndices() {
		Vector<Indice> ai=new Vector<Indice>();
		try {
		int n=(int) (arch1.length()/Indice.LARGO);
			for(int i=0 ; i<n ; i++) {
			
				arch1.seek(i*Indice.LARGO+12+4);
			if(!arch1.readBoolean())
				continue;
			
			
			arch1.seek(i*Cliente.LARGO);
			ai.add(new Indice(arch1.readUTF().trim(),arch1.readInt(),arch1.readBoolean()));
			}
		}catch(Exception e) {}
		
		return ai;
	}
	public Indice consultarIndicePorRFC(String RFC) {
		//debe ser con busqueda binaria
		String rfc;
		int nregistro;
		try {
			int i=-1;
			do {
				i++;
				arch1.seek(i*Indice.LARGO);
				rfc=arch1.readUTF().trim();
				nregistro=arch1.readInt();
			}while(!RFC.equalsIgnoreCase(rfc));
		}catch(Exception e) {return null;}
		try {
			if(!arch1.readBoolean())
				return null;
		}catch(Exception e) {}
		return new Indice(rfc,nregistro,true);
	}
	public Cliente consultarClientePorNregistro(int Nregistro) {
		String	nombre;
		int	edad;
		int idCiudad;
		try {
			
				arch2.seek(Nregistro*Indice.LARGO);
				nombre=arch2.readUTF().trim();
				edad=arch2.readInt();
				idCiudad=arch2.readInt();
			
		}catch(Exception e) {return null;}
		return new Cliente (nombre,edad,idCiudad);
	}
	
	
	public void darBajaPorRFC(String RFC) {
		//debe ser con busqueda binaria
		String rfc;
		int nregistro;
		try {
			int i=-1;
			do {
				i++;
				arch1.seek(i*Indice.LARGO);
				rfc=arch1.readUTF().trim();
				nregistro=arch1.readInt();
			}while(!RFC.equalsIgnoreCase(rfc));
		}catch(Exception e) {return;}
		try {
			arch1.writeBoolean(false);
		}catch(Exception e) {}
	}

	public int Nregistro() {
		int l = 0;//ultimoregistro
		try {
			l=(int)(arch1.length() /Indice.LARGO);
		} catch (Exception e) {}
		return l;
	}

	
}
