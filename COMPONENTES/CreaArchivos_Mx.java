package componentes;

import java.io.RandomAccessFile;


public class CreaArchivos_Mx {
	static RandomAccessFile arch1,arch2,arch3;
	
	public static void abrirArchivo1() {
		try {
			arch1 = new RandomAccessFile("1.Dat", "rw");	
		} catch (Exception e) {
		}
	}
	public static void abrirArchivo2() {
		try {
			arch2 = new RandomAccessFile("2.Dat", "rw");	
		} catch (Exception e) {
		}
	}
	public static void abrirArchivo3() {
		try {
			arch3 = new RandomAccessFile("3.Dat", "rw");	
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
	

	
	public boolean crearEstados() {//32 estados y no se cuanto pesara
		String [] E= {"Aguascalientes", "Baja California", "Baja California Sur", "Campeche", "Coahuila", "Colima", "Chiapas", "Chihuahua", "Durango", "Distrito Federal", "Guanajuato", "Guerrero", "Hidalgo", "Jalisco", "M�xico", "Michoac�n", "Morelos", "Nayarit", "Nuevo Le�n", "Oaxaca", "Puebla", "Quer�taro", "Quintana Roo", "San Luis Potos�", "Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala", "Veracruz", "Yucat�n", "Zacatecas"};
			
		
		try {
			arch1.seek(0);	//arch1.seek(arch1.length());	
			for (int i = 0; i < E.length; i++) {
				arch1.writeInt(Integer.parseInt(Rutinas.PonCeros(i, 2) ));
				arch1.writeUTF(Rutinas.PonBlancos(E[i],25));
			}
		}catch(Exception e) {return false;}
		return true;
	}
	public boolean crearMunicipios() {
				
			String [][] M= {
					{	"AGUASCALIENTES","ASIENTOS","CALVILLO","COS�O","JES�S MAR�A","PABELL�N DE ARTEAGA","RINC�N DE ROMOS","SAN JOS� DE GRACIA","TEPEZAL�","EL LLANO","SAN FRANCISCO DE LOS ROMO"},
					
					{	"ENSENADA","MEXICALI","TECATE","TIJUANA","PLAYAS DE ROSARITO"},
					
					{	"COMOND�","MULEG�","LA PAZ","LOS CABOS","LORETO"},
					
					{	"CALKIN�","CAMPECHE","CARMEN","CHAMPOT�N","HECELCHAK�N","HOPELCH�N","PALIZADA","TENABO","ESC�RCEGA","CALAKMUL","CANDELARIA"},
				
					{   "ACACOYAGUA","ACALA","ACAPETAHUA","ALTAMIRANO",
						"AMAT�N","AMATENANGO DE LA FRONTERA","AMATENANGO DEL VALLE","ANGEL ALBINO CORZO","ARRIAGA","BEJUCAL DE OCAMPO","BELLA VISTA","BERRIOZ�BAL","BOCHIL",
						"EL BOSQUE","CACAHOAT�N","CATAZAJ�","CINTALAPA","COAPILLA","COMIT�N DE DOM�NGUEZ","LA CONCORDIA","COPAINAL�","CHALCHIHUIT�N","CHAMULA",
						"CHANAL","CHAPULTENANGO","CHENALH�","CHIAPA DE CORZO","CHIAPILLA","CHICOAS�N","CHICOMUSELO","CHIL�N","ESCUINTLA","FRANCISCO LE�N",
						"FRONTERA COMALAPA","FRONTERA HIDALGO","LA GRANDEZA","HUEHUET�N","HUIXT�N","HUITIUP�N","HUIXTLA","LA INDEPENDENCIA","IXHUAT�N","IXTACOMIT�N","IXTAPA",
						"IXTAPANGAJOYA","JIQUIPILAS","JITOTOL","JU�REZ","LARR�INZAR","LA LIBERTAD","MAPASTEPEC","LAS MARGARITAS","MAZAPA DE MADERO","MAZAT�N",
						"METAPA","MITONTIC","MOTOZINTLA","NICOL�S RU�Z","OCOSINGO","OCOTEPEC","OCOZOCOAUTLA DE ESPINOSA","OSTUAC�N","OSUMACINTA","OXCHUC","PALENQUE","PANTELH�","PANTEPEC","PICHUCALCO","PIJIJIAPAN","EL PORVENIR","VILLA COMALTITL�N","PUEBLO NUEVO SOLISTAHUAC�N","RAY�N","REFORMA","LAS ROSAS","SABANILLA","SALTO DE AGUA","SAN CRIST�BAL DE LAS CASAS","SAN FERNANDO","SILTEPEC","SIMOJOVEL","SITAL�","SOCOLTENANGO","SOLOSUCHIAPA","SOYAL�","SUCHIAPA","SUCHIATE","SUNUAPA","TAPACHULA","TAPALAPA","TAPILULA","TECPAT�N","TENEJAPA","TEOPISCA","TILA","TONAL�","TOTOLAPA","LA TRINITARIA","TUMBAL�","TUXTLA GUTI�RREZ","TUXTLA CHICO","TUZANT�N","TZIMOL","UNI�N JU�REZ","VENUSTIANO CARRANZA","VILLA CORZO","VILLAFLORES","YAJAL�N","SAN LUCAS","ZINACANT�N","SAN JUAN CANCUC","ALDAMA","BENEM�RITO DE LAS AM�RICAS","MARAVILLA TENEJAPA","MARQU�S DE COMILLAS","MONTECRISTO DE GUERRERO","SAN ANDR�S DURAZNAL","SANTIAGO EL PINAR"},
							
					
					{	"AZCAPOTZALCO","COYOAC�N","CUAJIMALPA DE MORELOS","GUSTAVO A. MADERO","IZTACALCO","IZTAPALAPA","LA MAGDALENA CONTRERAS","MILPA ALTA","�LVARO OBREG�N","TL�HUAC","TLALPAN","XOCHIMILCO","BENITO JU�REZ","CUAUHT�MOC","MIGUEL HIDALGO","VENUSTIANO CARRANZA"},
					
					{	"ABASOLO","ACU�A","ALLENDE","ARTEAGA","CANDELA","CASTA�OS"},
			
					{   "ARMER�A","COLIMA","COMALA","COQUIMATL�N","CUAUHT�MOC","IXTLAHUAC�N","MANZANILLO","MINATITL�N","TECOM�N","VILLA DE �LVAREZ"},
				
					{   "DURANGO","CANATL�N","CANELAS","CONETO DE COMONFORT","CUENCAM�"},
					
					{	"ABASOLO","AC�MBARO","SAN MIGUEL DE ALLENDE","APASEO EL ALTO","APASEO EL GRANDE"},
					
					{    "ACAPULCO DE JU�REZ","AHUACUOTZINGO","AJUCHITL�N DEL PROGRESO","ALCOZAUCA DE GUERRERO","ALPOYECA"},
					
					{    "ACATL�N","ACAXOCHITL�N","ACTOPAN","AGUA BLANCA DE ITURBIDE","AJACUBA"},
				
					{    "ACATIC","ACATL�N DE JU�REZ","AHUALULCO DE MERCADO","AMACUECA","AMATIT�N"},
					
					{    "ACAMBAY DE RU�Z CASTA�EDA","ACOLMAN","ACULCO","ALMOLOYA DE ALQUISIRAS","ALMOLOYA DE JU�REZ"},
					
					{    "ACUITZIO","AGUILILLA","�LVARO OBREG�N","ANGAMACUTIRO","ANGANGUEO"},
					
					{    "AMACUZAC","ATLATLAHUCAN","AXOCHIAPAN","AYALA","COATL�N DEL R�O"},
				
					{    "ACAPONETA","AHUACATL�N","AMATL�N DE CA�AS","COMPOSTELA","HUAJICORI",},
					
					{    "ABASOLO","AGUALEGUAS","LOS ALDAMAS","ALLENDE","AN�HUAC"},
				
					{    "ABEJONES","ACATL�N DE P�REZ FIGUEROA","ASUNCI�N CACALOTEPEC","ASUNCI�N CUYOTEPEJI","ASUNCI�N IXTALTEPEC"},
					
					{    "ACAJETE","ACATENO","ACATL�N","ACATZINGO"},
					
					{	 "SINDATOS"	},		
					
					{    "AMEALCO DE BONFIL","PINAL DE AMOLES","ARROYO SECO","CADEREYTA DE MONTES"},
				
					{    "COZUMEL","FELIPE CARRILLO PUERTO","ISLA MUJERES","OTH�N P. BLANCO"},
				
					{    "SAN MART�N CHALCHICUAUTLA","SAN NICOL�S TOLENTINO","SANTA CATARINA","SANTA MAR�A DEL R�O"},
					
					{    "AHOME","ANGOSTURA","BADIRAGUATO","CONCORDIA","COSAL�","CULIAC�N","CHOIX","ELOTA","ESCUINAPA","EL FUERTE","GUASAVE","MAZATL�N","MOCORITO","ROSARIO","SALVADOR ALVARADO","SAN IGNACIO","SINALOA","NAVOLATO"},
					
					{    "ACONCHI","AGUA PRIETA","ALAMOS","ALTAR"},
					
					{    "BALANC�N","C�RDENAS","CENTLA","CENTRO","COMALCALCO",},
					
					{    "ABASOLO","ALDAMA","ALTAMIRA","ANTIGUO MORELOS","BURGOS"},
					
					{    "AMAXAC DE GUERRERO","APETATITL�N DE ANTONIO CARVAJAL","ATLANGATEPEC","ATLTZAYANCA"},
					
					{    "ACAJETE","ACATL�N","ACAYUCAN","ACTOPAN","ACULA"},
				
					{    "ABAL�","ACANCEH","AKIL","BACA","BOKOB�"},
				
					{    "APOZOL","APULCO","ATOLINGA","BENITO JU�REZ","CALERA"},};
			try {
				arch2.seek(0);
				for (int i = 0; i < M.length; i++) {
					for (int j = 0; j < M[i].length; j++) {
					arch2.writeInt(Integer.parseInt(Rutinas.PonCeros(i, 2) ));
					arch2.writeInt(Integer.parseInt(Rutinas.PonCeros(j, 2) ));
					arch2.writeUTF(Rutinas.PonBlancos( M[i][j],35));
					}
				}
			}catch(Exception e) {return false;}
		return true;
	}

	
	
	
	public boolean crearCiudades() {//32 estados y no se cuanto pesara
		String [][][] C= {
				
				{     {"AGUASCALIENTES"},{"ASIENTOS"},{"CALVILLO"},{"COS�O"},{"JES�S MAR�A"},{"PABELL�N DE ARTEAGA"},{"RINC�N DE ROMOS"},{"SAN JOS� DE GRACIA"},{"TEPEZAL�"},{"EL LLANO"},{"SAN FRANCISCO DE LOS ROMO"}},
				
				{	{"ENSENADA"},{"MEXICALI"},{"TECATE"},{"TIJUANA"},{"PLAYAS DE ROSARITO"}},
				
				{	{"COMOND�"},{"MULEG�"},{"LA PAZ"},{"LOS CABOS"},{"LORETO"}},
				
				{	{"CALKIN�"},{"CAMPECHE"},{"CARMEN"},{"CHAMPOT�N"},{"HECELCHAK�N"},{"HOPELCH�N"},
					{"PALIZADA"},{"TENABO"},{"ESC�RCEGA"},{"CALAKMUL"},{"CANDELARIA"}},
			
				{  {"ACACOYAGUA"} ,{"ACALA"},{"ACAPETAHUA"},{"ALTAMIRANO"},
					{"AMAT�N"},{"AMATENANGO DE LA FRONTERA"},{"AMATENANGO DEL VALLE"},{"ANGEL ALBINO CORZO"},{"ARRIAGA"},{"BEJUCAL DE OCAMPO"},{"BELLA VISTA"},{"BERRIOZ�BAL"},{"BOCHIL"},
					{"EL BOSQUE"},{"CACAHOAT�N"},{"CATAZAJ�"},{"CINTALAPA"},{"COAPILLA"},{"COMIT�N DE DOM�NGUEZ"},{"LA CONCORDIA"},{"COPAINAL�"},{"CHALCHIHUIT�N"},{"CHAMULA"},
					{"CHANAL"},{"CHAPULTENANGO"},{"CHENALH�"},{"CHIAPA DE CORZO"},{"CHIAPILLA"},{"CHICOAS�N"},{"CHICOMUSELO"},{"CHIL�N"},{"ESCUINTLA"},{"FRANCISCO LE�N"},
					{"FRONTERA COMALAPA"},{"FRONTERA HIDALGO"},{"LA GRANDEZA"},{"HUEHUET�N"},{"HUIXT�N"},{"HUITIUP�N"},{"HUIXTLA"},{"LA INDEPENDENCIA"},{"IXHUAT�N"},{"IXTACOMIT�N"},{"IXTAPA"},
					{"IXTAPANGAJOYA"},{"JIQUIPILAS"},{"JITOTOL"},{"JU�REZ"},{"LARR�INZAR"},{"LA LIBERTAD"},{"MAPASTEPEC"},{"LAS MARGARITAS"},{"MAZAPA DE MADERO"},{"MAZAT�N"},
					{"METAPA"},{"MITONTIC"},{"MOTOZINTLA"},{"NICOL�S RU�Z"},{"OCOSINGO"},{"OCOTEPEC"},{"OCOZOCOAUTLA DE ESPINOSA"},{"OSTUAC�N"},{"OSUMACINTA"},{"OXCHUC"},{"PALENQUE"},{"PANTELH�"},
					{"PANTEPEC"},{"PICHUCALCO"},{"PIJIJIAPAN"},{"EL PORVENIR"},{"VILLA COMALTITL�N"},{"PUEBLO NUEVO SOLISTAHUAC�N"},{"RAY�N"},{"REFORMA"},{"LAS ROSAS"},{"SABANILLA"},{"SALTO DE AGUA"},
					{"SAN CRIST�BAL DE LAS CASAS"},{"SAN FERNANDO"},{"SILTEPEC"},{"SIMOJOVEL"},{"SITAL�"},{"SOCOLTENANGO"},{"SOLOSUCHIAPA"},{"SOYAL�"},{"SUCHIAPA"},{"SUCHIATE"},{"SUNUAPA"},{"TAPACHULA"},
					{"TAPALAPA"},{"TAPILULA"},{"TECPAT�N"},{"TENEJAPA"},{"TEOPISCA"},{"TILA"},{"TONAL�"},{"TOTOLAPA"},{"LA TRINITARIA"},{"TUMBAL�"},{"TUXTLA GUTI�RREZ"},{"TUXTLA CHICO"},{"TUZANT�N"},
					{"TZIMOL"},{"UNI�N JU�REZ"},{"VENUSTIANO CARRANZA"},{"VILLA CORZO"},{"VILLAFLORES"},{"YAJAL�N"},{"SAN LUCAS"},{"ZINACANT�N"},{"SAN JUAN CANCUC"},{"ALDAMA"},{"BENEM�RITO DE LAS AM�RICAS"},
					{"MARAVILLA TENEJAPA"},{"MARQU�S DE COMILLAS"},{"MONTECRISTO DE GUERRERO"},{"SAN ANDR�S DURAZNAL"},{"SANTIAGO EL PINAR"}},
					
				
				{	{"AZCAPOTZALCO"},{"COYOAC�N"},{"CUAJIMALPA DE MORELOS"},{"GUSTAVO A. MADERO"},{"IZTACALCO"},{"IZTAPALAPA"},{"LA MAGDALENA CONTRERAS"},{"MILPA ALTA"},
						{"�LVARO OBREG�N"},{"TL�HUAC"},{"TLALPAN"},{"XOCHIMILCO"},{"BENITO JU�REZ"},{"CUAUHT�MOC"},{"MIGUEL HIDALGO"},{"VENUSTIANO CARRANZA"}},
				
				{	{"ABASOLO"},{"ACU�A"},{"ALLENDE"},{"ARTEAGA"},{"CANDELA"},{"CASTA�OS"}},
		
				{  {"ARMER�A"} ,{"COLIMA"},{"COMALA"},{"COQUIMATL�N"},{"CUAUHT�MOC"},{"IXTLAHUAC�N"},{"MANZANILLO"},{"MINATITL�N"},{"TECOM�N"},{"VILLA DE �LVAREZ"}},
			
				{   {"DURANGO"},{"CANATL�N"},{"CANELAS"},{"CONETO DE COMONFORT"},{"CUENCAM�"}},
				
				{	{"ABASOLO"},{"AC�MBARO"},{"SAN MIGUEL DE ALLENDE"},{"APASEO EL ALTO"},{"APASEO EL GRANDE"}},
				
				{    {"ACAPULCO DE JU�REZ"},{"AHUACUOTZINGO"},{"AJUCHITL�N DEL PROGRESO"},{"ALCOZAUCA DE GUERRERO"},{"ALPOYECA"}},
				
				{    {"ACATL�N"},{"ACAXOCHITL�N"},{"ACTOPAN"},{"AGUA BLANCA DE ITURBIDE"},{"AJACUBA"}},
			
				{    {"ACATIC"},{"ACATL�N DE JU�REZ"},{"AHUALULCO DE MERCADO"},{"AMACUECA"},{"AMATIT�N"}},
				
				{    {"ACAMBAY DE RU�Z CASTA�EDA"},{"ACOLMAN"},{"ACULCO"},{"ALMOLOYA DE ALQUISIRAS"},{"ALMOLOYA DE JU�REZ"}},
				
				{    {"ACUITZIO"},{"AGUILILLA"},{"�LVARO OBREG�N"},{"ANGAMACUTIRO"},{"ANGANGUEO"}},
				
				{    {"AMACUZAC"},{"ATLATLAHUCAN"},{"AXOCHIAPAN"},{"AYALA"},{"COATL�N DEL R�O"}},
			
				{   {"ACAPONETA"} ,{"AHUACATL�N"},{"AMATL�N DE CA�AS"},{"COMPOSTELA"},{"HUAJICORI"}},
				
				{    {"ABASOLO"},{"AGUALEGUAS"},{"LOS ALDAMAS"},{"ALLENDE"},{"AN�HUAC"}},
			
				{   { "ABEJONES"},{"ACATL�N DE P�REZ FIGUEROA"},{"ASUNCI�N CACALOTEPEC"},{"ASUNCI�N CUYOTEPEJI"},{"ASUNCI�N IXTALTEPEC"}},
				
				{    {"ACAJETE"},{"ACATENO"},{"ACATL�N"},{"ACATZINGO"}},
				
				{	{"SINDATOS"	} },		
				
				{    {"AMEALCO DE BONFIL"},{"PINAL DE AMOLES"},{"ARROYO SECO"},{"CADEREYTA DE MONTES"}},
			
				{    {"COZUMEL"},{"FELIPE CARRILLO PUERTO"},{"ISLA MUJERES"},{"OTH�N P. BLANCO"}},
			
				{    {"SAN MART�N CHALCHICUAUTLA"},{"SAN NICOL�S TOLENTINO"},{"SANTA CATARINA"},{"SANTA MAR�A DEL R�O"}},
				
				{    {"AHOME"},{"ANGOSTURA"},{"BADIRAGUATO"},{"CONCORDIA"},{"COSAL�"},{"CULIAC�N","BARRANCOS"},{"CHOIX"},{"ELOTA"},{"ESCUINAPA"},
					{"EL FUERTE"},{"GUASAVE"},{"MAZATL�N"},{"MOCORITO"},{"ROSARIO"},{"SALVADOR ALVARADO","GUAMUCHIL"},{"SAN IGNACIO"},{"SINALOA"},{"NAVOLATO"}},
				
				{   {"ACONCHI"} ,{"AGUA PRIETA"},{"ALAMOS"},{"ALTAR"}},
				
				{    {"BALANC�N"},{"C�RDENAS"},{"CENTLA"},{"CENTRO"},{"COMALCALCO"}},
				
				{   {"ABASOLO"} ,{"ALDAMA"},{"ALTAMIRA"},{"ANTIGUO MORELOS"},{"BURGOS"}},
				
				{    {"AMAXAC DE GUERRERO"},{"APETATITL�N DE ANTONIO CARVAJAL"},{"ATLANGATEPEC"},{"ATLTZAYANCA"}},
				
				{    {"ACAJETE"},{"ACATL�N"},{"ACAYUCAN"},{"ACTOPAN"},{"ACULA"}},
			
				{   {"ABAL�"} ,{"ACANCEH"},{"AKIL"},{"BACA"},{"BOKOB�"}},
			
				{    {"APOZOL"},{"APULCO"},{"ATOLINGA"},{"BENITO JU�REZ"},{"CALERA"}}
				
				};
		
		try {
			arch2.seek(0);
			for (int i = 0; i < C.length; i++) {
				for (int j = 0; j < C[i].length; j++) {
					for (int j2 = 0; j2 < C[i][j].length; j2++) {
					arch2.writeInt(Integer.parseInt(Rutinas.PonCeros(i, 2) ));
					arch2.writeInt(Integer.parseInt(Rutinas.PonCeros(j, 2) ));
					arch2.writeInt(Integer.parseInt(Rutinas.PonCeros(j2, 2) ));
					arch2.writeUTF(Rutinas.PonBlancos( C[i][j][j2],35));	
					}
				
				}
			}
		}catch(Exception e) {return false;}
	return true;
	}	

	
}

			