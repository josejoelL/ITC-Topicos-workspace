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
		String [] E= {"Aguascalientes", "Baja California", "Baja California Sur", "Campeche", "Coahuila", "Colima", "Chiapas", "Chihuahua", "Durango", "Distrito Federal", "Guanajuato", "Guerrero", "Hidalgo", "Jalisco", "México", "Michoacán", "Morelos", "Nayarit", "Nuevo León", "Oaxaca", "Puebla", "Querétaro", "Quintana Roo", "San Luis Potosí", "Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala", "Veracruz", "Yucatán", "Zacatecas"};
			
		
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
					{	"AGUASCALIENTES","ASIENTOS","CALVILLO","COSÍO","JESÚS MARÍA","PABELLÓN DE ARTEAGA","RINCÓN DE ROMOS","SAN JOSÉ DE GRACIA","TEPEZALÁ","EL LLANO","SAN FRANCISCO DE LOS ROMO"},
					
					{	"ENSENADA","MEXICALI","TECATE","TIJUANA","PLAYAS DE ROSARITO"},
					
					{	"COMONDÚ","MULEGÉ","LA PAZ","LOS CABOS","LORETO"},
					
					{	"CALKINÍ","CAMPECHE","CARMEN","CHAMPOTÓN","HECELCHAKÁN","HOPELCHÉN","PALIZADA","TENABO","ESCÁRCEGA","CALAKMUL","CANDELARIA"},
				
					{   "ACACOYAGUA","ACALA","ACAPETAHUA","ALTAMIRANO",
						"AMATÁN","AMATENANGO DE LA FRONTERA","AMATENANGO DEL VALLE","ANGEL ALBINO CORZO","ARRIAGA","BEJUCAL DE OCAMPO","BELLA VISTA","BERRIOZÁBAL","BOCHIL",
						"EL BOSQUE","CACAHOATÁN","CATAZAJÁ","CINTALAPA","COAPILLA","COMITÁN DE DOMÍNGUEZ","LA CONCORDIA","COPAINALÁ","CHALCHIHUITÁN","CHAMULA",
						"CHANAL","CHAPULTENANGO","CHENALHÓ","CHIAPA DE CORZO","CHIAPILLA","CHICOASÉN","CHICOMUSELO","CHILÓN","ESCUINTLA","FRANCISCO LEÓN",
						"FRONTERA COMALAPA","FRONTERA HIDALGO","LA GRANDEZA","HUEHUETÁN","HUIXTÁN","HUITIUPÁN","HUIXTLA","LA INDEPENDENCIA","IXHUATÁN","IXTACOMITÁN","IXTAPA",
						"IXTAPANGAJOYA","JIQUIPILAS","JITOTOL","JUÁREZ","LARRÁINZAR","LA LIBERTAD","MAPASTEPEC","LAS MARGARITAS","MAZAPA DE MADERO","MAZATÁN",
						"METAPA","MITONTIC","MOTOZINTLA","NICOLÁS RUÍZ","OCOSINGO","OCOTEPEC","OCOZOCOAUTLA DE ESPINOSA","OSTUACÁN","OSUMACINTA","OXCHUC","PALENQUE","PANTELHÓ","PANTEPEC","PICHUCALCO","PIJIJIAPAN","EL PORVENIR","VILLA COMALTITLÁN","PUEBLO NUEVO SOLISTAHUACÁN","RAYÓN","REFORMA","LAS ROSAS","SABANILLA","SALTO DE AGUA","SAN CRISTÓBAL DE LAS CASAS","SAN FERNANDO","SILTEPEC","SIMOJOVEL","SITALÁ","SOCOLTENANGO","SOLOSUCHIAPA","SOYALÓ","SUCHIAPA","SUCHIATE","SUNUAPA","TAPACHULA","TAPALAPA","TAPILULA","TECPATÁN","TENEJAPA","TEOPISCA","TILA","TONALÁ","TOTOLAPA","LA TRINITARIA","TUMBALÁ","TUXTLA GUTIÉRREZ","TUXTLA CHICO","TUZANTÁN","TZIMOL","UNIÓN JUÁREZ","VENUSTIANO CARRANZA","VILLA CORZO","VILLAFLORES","YAJALÓN","SAN LUCAS","ZINACANTÁN","SAN JUAN CANCUC","ALDAMA","BENEMÉRITO DE LAS AMÉRICAS","MARAVILLA TENEJAPA","MARQUÉS DE COMILLAS","MONTECRISTO DE GUERRERO","SAN ANDRÉS DURAZNAL","SANTIAGO EL PINAR"},
							
					
					{	"AZCAPOTZALCO","COYOACÁN","CUAJIMALPA DE MORELOS","GUSTAVO A. MADERO","IZTACALCO","IZTAPALAPA","LA MAGDALENA CONTRERAS","MILPA ALTA","ÁLVARO OBREGÓN","TLÁHUAC","TLALPAN","XOCHIMILCO","BENITO JUÁREZ","CUAUHTÉMOC","MIGUEL HIDALGO","VENUSTIANO CARRANZA"},
					
					{	"ABASOLO","ACUÑA","ALLENDE","ARTEAGA","CANDELA","CASTAÑOS"},
			
					{   "ARMERÍA","COLIMA","COMALA","COQUIMATLÁN","CUAUHTÉMOC","IXTLAHUACÁN","MANZANILLO","MINATITLÁN","TECOMÁN","VILLA DE ÁLVAREZ"},
				
					{   "DURANGO","CANATLÁN","CANELAS","CONETO DE COMONFORT","CUENCAMÉ"},
					
					{	"ABASOLO","ACÁMBARO","SAN MIGUEL DE ALLENDE","APASEO EL ALTO","APASEO EL GRANDE"},
					
					{    "ACAPULCO DE JUÁREZ","AHUACUOTZINGO","AJUCHITLÁN DEL PROGRESO","ALCOZAUCA DE GUERRERO","ALPOYECA"},
					
					{    "ACATLÁN","ACAXOCHITLÁN","ACTOPAN","AGUA BLANCA DE ITURBIDE","AJACUBA"},
				
					{    "ACATIC","ACATLÁN DE JUÁREZ","AHUALULCO DE MERCADO","AMACUECA","AMATITÁN"},
					
					{    "ACAMBAY DE RUÍZ CASTAÑEDA","ACOLMAN","ACULCO","ALMOLOYA DE ALQUISIRAS","ALMOLOYA DE JUÁREZ"},
					
					{    "ACUITZIO","AGUILILLA","ÁLVARO OBREGÓN","ANGAMACUTIRO","ANGANGUEO"},
					
					{    "AMACUZAC","ATLATLAHUCAN","AXOCHIAPAN","AYALA","COATLÁN DEL RÍO"},
				
					{    "ACAPONETA","AHUACATLÁN","AMATLÁN DE CAÑAS","COMPOSTELA","HUAJICORI",},
					
					{    "ABASOLO","AGUALEGUAS","LOS ALDAMAS","ALLENDE","ANÁHUAC"},
				
					{    "ABEJONES","ACATLÁN DE PÉREZ FIGUEROA","ASUNCIÓN CACALOTEPEC","ASUNCIÓN CUYOTEPEJI","ASUNCIÓN IXTALTEPEC"},
					
					{    "ACAJETE","ACATENO","ACATLÁN","ACATZINGO"},
					
					{	 "SINDATOS"	},		
					
					{    "AMEALCO DE BONFIL","PINAL DE AMOLES","ARROYO SECO","CADEREYTA DE MONTES"},
				
					{    "COZUMEL","FELIPE CARRILLO PUERTO","ISLA MUJERES","OTHÓN P. BLANCO"},
				
					{    "SAN MARTÍN CHALCHICUAUTLA","SAN NICOLÁS TOLENTINO","SANTA CATARINA","SANTA MARÍA DEL RÍO"},
					
					{    "AHOME","ANGOSTURA","BADIRAGUATO","CONCORDIA","COSALÁ","CULIACÁN","CHOIX","ELOTA","ESCUINAPA","EL FUERTE","GUASAVE","MAZATLÁN","MOCORITO","ROSARIO","SALVADOR ALVARADO","SAN IGNACIO","SINALOA","NAVOLATO"},
					
					{    "ACONCHI","AGUA PRIETA","ALAMOS","ALTAR"},
					
					{    "BALANCÁN","CÁRDENAS","CENTLA","CENTRO","COMALCALCO",},
					
					{    "ABASOLO","ALDAMA","ALTAMIRA","ANTIGUO MORELOS","BURGOS"},
					
					{    "AMAXAC DE GUERRERO","APETATITLÁN DE ANTONIO CARVAJAL","ATLANGATEPEC","ATLTZAYANCA"},
					
					{    "ACAJETE","ACATLÁN","ACAYUCAN","ACTOPAN","ACULA"},
				
					{    "ABALÁ","ACANCEH","AKIL","BACA","BOKOBÁ"},
				
					{    "APOZOL","APULCO","ATOLINGA","BENITO JUÁREZ","CALERA"},};
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
				
				{     {"AGUASCALIENTES"},{"ASIENTOS"},{"CALVILLO"},{"COSÍO"},{"JESÚS MARÍA"},{"PABELLÓN DE ARTEAGA"},{"RINCÓN DE ROMOS"},{"SAN JOSÉ DE GRACIA"},{"TEPEZALÁ"},{"EL LLANO"},{"SAN FRANCISCO DE LOS ROMO"}},
				
				{	{"ENSENADA"},{"MEXICALI"},{"TECATE"},{"TIJUANA"},{"PLAYAS DE ROSARITO"}},
				
				{	{"COMONDÚ"},{"MULEGÉ"},{"LA PAZ"},{"LOS CABOS"},{"LORETO"}},
				
				{	{"CALKINÍ"},{"CAMPECHE"},{"CARMEN"},{"CHAMPOTÓN"},{"HECELCHAKÁN"},{"HOPELCHÉN"},
					{"PALIZADA"},{"TENABO"},{"ESCÁRCEGA"},{"CALAKMUL"},{"CANDELARIA"}},
			
				{  {"ACACOYAGUA"} ,{"ACALA"},{"ACAPETAHUA"},{"ALTAMIRANO"},
					{"AMATÁN"},{"AMATENANGO DE LA FRONTERA"},{"AMATENANGO DEL VALLE"},{"ANGEL ALBINO CORZO"},{"ARRIAGA"},{"BEJUCAL DE OCAMPO"},{"BELLA VISTA"},{"BERRIOZÁBAL"},{"BOCHIL"},
					{"EL BOSQUE"},{"CACAHOATÁN"},{"CATAZAJÁ"},{"CINTALAPA"},{"COAPILLA"},{"COMITÁN DE DOMÍNGUEZ"},{"LA CONCORDIA"},{"COPAINALÁ"},{"CHALCHIHUITÁN"},{"CHAMULA"},
					{"CHANAL"},{"CHAPULTENANGO"},{"CHENALHÓ"},{"CHIAPA DE CORZO"},{"CHIAPILLA"},{"CHICOASÉN"},{"CHICOMUSELO"},{"CHILÓN"},{"ESCUINTLA"},{"FRANCISCO LEÓN"},
					{"FRONTERA COMALAPA"},{"FRONTERA HIDALGO"},{"LA GRANDEZA"},{"HUEHUETÁN"},{"HUIXTÁN"},{"HUITIUPÁN"},{"HUIXTLA"},{"LA INDEPENDENCIA"},{"IXHUATÁN"},{"IXTACOMITÁN"},{"IXTAPA"},
					{"IXTAPANGAJOYA"},{"JIQUIPILAS"},{"JITOTOL"},{"JUÁREZ"},{"LARRÁINZAR"},{"LA LIBERTAD"},{"MAPASTEPEC"},{"LAS MARGARITAS"},{"MAZAPA DE MADERO"},{"MAZATÁN"},
					{"METAPA"},{"MITONTIC"},{"MOTOZINTLA"},{"NICOLÁS RUÍZ"},{"OCOSINGO"},{"OCOTEPEC"},{"OCOZOCOAUTLA DE ESPINOSA"},{"OSTUACÁN"},{"OSUMACINTA"},{"OXCHUC"},{"PALENQUE"},{"PANTELHÓ"},
					{"PANTEPEC"},{"PICHUCALCO"},{"PIJIJIAPAN"},{"EL PORVENIR"},{"VILLA COMALTITLÁN"},{"PUEBLO NUEVO SOLISTAHUACÁN"},{"RAYÓN"},{"REFORMA"},{"LAS ROSAS"},{"SABANILLA"},{"SALTO DE AGUA"},
					{"SAN CRISTÓBAL DE LAS CASAS"},{"SAN FERNANDO"},{"SILTEPEC"},{"SIMOJOVEL"},{"SITALÁ"},{"SOCOLTENANGO"},{"SOLOSUCHIAPA"},{"SOYALÓ"},{"SUCHIAPA"},{"SUCHIATE"},{"SUNUAPA"},{"TAPACHULA"},
					{"TAPALAPA"},{"TAPILULA"},{"TECPATÁN"},{"TENEJAPA"},{"TEOPISCA"},{"TILA"},{"TONALÁ"},{"TOTOLAPA"},{"LA TRINITARIA"},{"TUMBALÁ"},{"TUXTLA GUTIÉRREZ"},{"TUXTLA CHICO"},{"TUZANTÁN"},
					{"TZIMOL"},{"UNIÓN JUÁREZ"},{"VENUSTIANO CARRANZA"},{"VILLA CORZO"},{"VILLAFLORES"},{"YAJALÓN"},{"SAN LUCAS"},{"ZINACANTÁN"},{"SAN JUAN CANCUC"},{"ALDAMA"},{"BENEMÉRITO DE LAS AMÉRICAS"},
					{"MARAVILLA TENEJAPA"},{"MARQUÉS DE COMILLAS"},{"MONTECRISTO DE GUERRERO"},{"SAN ANDRÉS DURAZNAL"},{"SANTIAGO EL PINAR"}},
					
				
				{	{"AZCAPOTZALCO"},{"COYOACÁN"},{"CUAJIMALPA DE MORELOS"},{"GUSTAVO A. MADERO"},{"IZTACALCO"},{"IZTAPALAPA"},{"LA MAGDALENA CONTRERAS"},{"MILPA ALTA"},
						{"ÁLVARO OBREGÓN"},{"TLÁHUAC"},{"TLALPAN"},{"XOCHIMILCO"},{"BENITO JUÁREZ"},{"CUAUHTÉMOC"},{"MIGUEL HIDALGO"},{"VENUSTIANO CARRANZA"}},
				
				{	{"ABASOLO"},{"ACUÑA"},{"ALLENDE"},{"ARTEAGA"},{"CANDELA"},{"CASTAÑOS"}},
		
				{  {"ARMERÍA"} ,{"COLIMA"},{"COMALA"},{"COQUIMATLÁN"},{"CUAUHTÉMOC"},{"IXTLAHUACÁN"},{"MANZANILLO"},{"MINATITLÁN"},{"TECOMÁN"},{"VILLA DE ÁLVAREZ"}},
			
				{   {"DURANGO"},{"CANATLÁN"},{"CANELAS"},{"CONETO DE COMONFORT"},{"CUENCAMÉ"}},
				
				{	{"ABASOLO"},{"ACÁMBARO"},{"SAN MIGUEL DE ALLENDE"},{"APASEO EL ALTO"},{"APASEO EL GRANDE"}},
				
				{    {"ACAPULCO DE JUÁREZ"},{"AHUACUOTZINGO"},{"AJUCHITLÁN DEL PROGRESO"},{"ALCOZAUCA DE GUERRERO"},{"ALPOYECA"}},
				
				{    {"ACATLÁN"},{"ACAXOCHITLÁN"},{"ACTOPAN"},{"AGUA BLANCA DE ITURBIDE"},{"AJACUBA"}},
			
				{    {"ACATIC"},{"ACATLÁN DE JUÁREZ"},{"AHUALULCO DE MERCADO"},{"AMACUECA"},{"AMATITÁN"}},
				
				{    {"ACAMBAY DE RUÍZ CASTAÑEDA"},{"ACOLMAN"},{"ACULCO"},{"ALMOLOYA DE ALQUISIRAS"},{"ALMOLOYA DE JUÁREZ"}},
				
				{    {"ACUITZIO"},{"AGUILILLA"},{"ÁLVARO OBREGÓN"},{"ANGAMACUTIRO"},{"ANGANGUEO"}},
				
				{    {"AMACUZAC"},{"ATLATLAHUCAN"},{"AXOCHIAPAN"},{"AYALA"},{"COATLÁN DEL RÍO"}},
			
				{   {"ACAPONETA"} ,{"AHUACATLÁN"},{"AMATLÁN DE CAÑAS"},{"COMPOSTELA"},{"HUAJICORI"}},
				
				{    {"ABASOLO"},{"AGUALEGUAS"},{"LOS ALDAMAS"},{"ALLENDE"},{"ANÁHUAC"}},
			
				{   { "ABEJONES"},{"ACATLÁN DE PÉREZ FIGUEROA"},{"ASUNCIÓN CACALOTEPEC"},{"ASUNCIÓN CUYOTEPEJI"},{"ASUNCIÓN IXTALTEPEC"}},
				
				{    {"ACAJETE"},{"ACATENO"},{"ACATLÁN"},{"ACATZINGO"}},
				
				{	{"SINDATOS"	} },		
				
				{    {"AMEALCO DE BONFIL"},{"PINAL DE AMOLES"},{"ARROYO SECO"},{"CADEREYTA DE MONTES"}},
			
				{    {"COZUMEL"},{"FELIPE CARRILLO PUERTO"},{"ISLA MUJERES"},{"OTHÓN P. BLANCO"}},
			
				{    {"SAN MARTÍN CHALCHICUAUTLA"},{"SAN NICOLÁS TOLENTINO"},{"SANTA CATARINA"},{"SANTA MARÍA DEL RÍO"}},
				
				{    {"AHOME"},{"ANGOSTURA"},{"BADIRAGUATO"},{"CONCORDIA"},{"COSALÁ"},{"CULIACÁN","BARRANCOS"},{"CHOIX"},{"ELOTA"},{"ESCUINAPA"},
					{"EL FUERTE"},{"GUASAVE"},{"MAZATLÁN"},{"MOCORITO"},{"ROSARIO"},{"SALVADOR ALVARADO","GUAMUCHIL"},{"SAN IGNACIO"},{"SINALOA"},{"NAVOLATO"}},
				
				{   {"ACONCHI"} ,{"AGUA PRIETA"},{"ALAMOS"},{"ALTAR"}},
				
				{    {"BALANCÁN"},{"CÁRDENAS"},{"CENTLA"},{"CENTRO"},{"COMALCALCO"}},
				
				{   {"ABASOLO"} ,{"ALDAMA"},{"ALTAMIRA"},{"ANTIGUO MORELOS"},{"BURGOS"}},
				
				{    {"AMAXAC DE GUERRERO"},{"APETATITLÁN DE ANTONIO CARVAJAL"},{"ATLANGATEPEC"},{"ATLTZAYANCA"}},
				
				{    {"ACAJETE"},{"ACATLÁN"},{"ACAYUCAN"},{"ACTOPAN"},{"ACULA"}},
			
				{   {"ABALÁ"} ,{"ACANCEH"},{"AKIL"},{"BACA"},{"BOKOBÁ"}},
			
				{    {"APOZOL"},{"APULCO"},{"ATOLINGA"},{"BENITO JUÁREZ"},{"CALERA"}}
				
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

			