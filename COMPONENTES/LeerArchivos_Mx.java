package componentes;
//import paquetes105;
import java.io.RandomAccessFile;

public class LeerArchivos_Mx {

	static RandomAccessFile arch1,arch2,arch3;
	
	
	public static void abrirArchivo1() {
		try {
			arch1 = new RandomAccessFile("1.Dat", "r");	
		} catch (Exception e) {
		}
	}
	public static void abrirArchivo2() {
		try {
			arch2 = new RandomAccessFile("2.Dat", "r");	
		} catch (Exception e) {
		}
	}
	public static void abrirArchivo3() {
		try {
			arch3 = new RandomAccessFile("3.Dat", "r");	
		} catch (Exception e) {
		}
	}
	public static void cerrarArchivos() {
		try {
			arch1.close();
			arch2.close();
			arch3.close();
		} catch (Exception e) {
		}
	}
	
	public static String[] LeeArchivosEstados(String[] E) {
		//int Estados=32;
		try {
	int Estados=(int) (arch1.length() / 37);
		for (int i = 0; i < Estados; i++) {

			arch1.seek(i * Estados);
			E[i] = arch1.readInt() + arch1.readUTF();
		//	E[i] = arch1.readUTF();
		//	E[i] = arch1.readLine();
		}
		}catch(Exception e) {}

			return E;
	}
	
	public static String[] LeeArchivosMun(String[] M) {
		//int Municipios=32;
		
		//pirmero que me de el estado para luego entregarle cuales son sus municipios
		
		//primero que me de el municipio para luego que me regrese las ciudades correspondientes
		try {
			int Estados=(int) (arch1.length() / 37);
			for (int i = 0; i < Estados; i++) {
				int Municipio=(int) (arch2.length() / 37);
				for (int j = 0; j < M.length; j++) {
				//	(arch2.
				}
			}	
			
			
		}catch(Exception e) {}
	
		
		
		return M;
	}
}
