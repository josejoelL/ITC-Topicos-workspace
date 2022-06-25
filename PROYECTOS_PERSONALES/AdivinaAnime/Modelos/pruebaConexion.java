package Modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * JDBC.
Java DataBase Connectivity o JDBC es una API que permite realizar operaciones de bases de datos 
desde un sistema en lenguaje Java
JDBC cuenta con una colección de interfaces Java y diferentes métodos para realizar la 
conexión a bases de datos SQL
Connection: Para establecer conexiones con las bases de datos
Statement: Para ejecutar sentencias SQL y enviarlas a las BBDD
PreparedStatement: La ruta de ejecución está predeterminada en el servidor de base de datos que
 le permite ser ejecutado varias veces
ResultSet: Para almacenar el resultado de la consulta
 * 
 */

public class pruebaConexion {
	private String nombreBd="adivinaanime";
	private String usuario="root";
	private String password="1o1br1n3";
	private String url="jdbc:mysql://localhost:3306/"+nombreBd+"?useUnicode=true&use"
			+ "JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&"
			+ "serverTimezone=UTC";

	Connection conn=null;// maneja la coneccion
	Statement stat=null;// con este haces query
	ResultSet rset=null;//manejas resultados
	
	//constructor de la clase
	public pruebaConexion(){
		try {
			//obtener el driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//obtener la conexion
			conn=DriverManager.getConnection(url,usuario,password);
			stat = conn.createStatement();
			if (conn==null) {
				System.out.println("******************NO SE PUDO CONECTAR "+nombreBd);
			}
		}
		catch (ClassNotFoundException e) {
			System.out.println("ocurre una ClassNotFoundException : "+e.getMessage());
		} catch (SQLException e) {
			System.out.println("ocurre una SQLException: "+e.getMessage());
			System.out.println("Verifique que Mysql esté encendido...");
		}
	}
	public Connection getConnection(){
		return conn;
	}
	public void desconectar(){
		conn=null;
	}
	
	public void setQuery(String Query){
		try {
		
			rset = stat.executeQuery(Query);
			//next sirve para moverse en la bd
			ResultSetMetaData metaData= rset.getMetaData();
			int numberOfColumns = metaData.getColumnCount();
			

			for (int i = 1; i <= numberOfColumns; i++) {
				System.out.print(metaData.getColumnName(i)+ " ");
			}
			System.out.println();
			while (rset.next()) {
				for (int i = 0; i <= numberOfColumns; i++) {
					System.out.println(rset.getObject(i));
				}
				
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		conn=null;
	}
	
	
	
}