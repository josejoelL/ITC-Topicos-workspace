package GRUD;

import java.io.Serializable;

public class Indice	implements Serializable {
	private String rfc;
	private int nregistro;
	private boolean estado;
	static final int LARGO=12+4+2;
	public Indice(String rfc, int nregistro, boolean estado) {
		super();
		this.rfc = rfc;
		this.nregistro = nregistro;
		this.estado = estado;
	}
	
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public int getNregistro() {
		return nregistro;
	}
	public void setNregistro(int nregistro) {
		this.nregistro = nregistro;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String toString() {
		return rfc+nregistro+estado;
	}
	
}
