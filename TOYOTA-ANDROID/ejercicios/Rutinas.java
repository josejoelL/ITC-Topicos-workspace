package com.example.holamundo;

import java.util.Random;

public class Rutinas {

    static Random R=new Random();
    static String []VN ={"ANASTACIA","PLUTARCO","Alicia","Maria","Sofia","Antonio","Nereida","Carolina",
            "Rebeca","Javier","Luis"};
    static String [] VA={"Garcia","Lopez","Perez","Urias","Mendoza","Coppel","Diaz"};
    static boolean [] Sexo={false,true,false,false,false,true,false,false,
            false,true,true};

    public static String PonBlancos(String Texto,int Tamaño){
        while (Texto.length() <Tamaño)
            Texto+=" ";
        return Texto;
    }
    public static String PonCeros(int Valor, int Tamaño){
        String Texto=Valor+"";
        while (Texto.length()<Tamaño)
            Texto="0"+Texto;
        return Texto;
    }
    public static int nextInt(int Valor){
        return R.nextInt(Valor);
    }
    public static int nextInt(int Ini,int Fin){
        return R.nextInt( Fin-Ini+1  )+Ini;
    }
    public static String nextNombre(int Numero){
        String Nom="",NomTra="";
        int Pos;
        boolean Genero=true;;

        for(int i=0;i<Numero;i++){
            Pos=nextInt(VN.length);

            NomTra=VN[Pos]+" ";

            if (i==0){
                Genero=Sexo[Pos];
            }

            if( Genero != Sexo[Pos]  || i>0 && Nom.indexOf(NomTra)>-1    ){
                i--;
                continue;
            }

            Nom+=NomTra;

        }
        for(byte i=0;i<2;i++){
            Nom+=VA[nextInt(VA.length)]+" ";
        }
        return Nom.trim();
    }
    public static String nextEstacion() {
        String [] estaciones= {"primavera","verano","otoño","invierno"};
        return estaciones[R.nextInt(estaciones.length)];
    }
    public static String nextColor() {
        String [] color= {"azul","rojo","amarillo","verde","gris","negro","cafe","violeta","purpura"};
        return color[R.nextInt(color.length)];
    }
}
