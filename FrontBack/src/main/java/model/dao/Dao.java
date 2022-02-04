package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Vene;

public class Dao {
	private Connection con=null;
	private ResultSet rs = null;
	private PreparedStatement stmtPrep=null; 
	private String sql;
	private String db ="Venekanta.sqlite";
	
	private Connection yhdista(){
    	Connection con = null;    	
    	String path = System.getProperty("catalina.base");    	
    	path = path.substring(0, path.indexOf(".metadata")).replace("\\", "/"); //Eclipsessa
    	//path += "/webapps/"; //Tuotannossa. Laita tietokanta webapps-kansioon
    	String url = "jdbc:sqlite:"+path+db;    	
    	try {	       
    		Class.forName("org.sqlite.JDBC");
	        con = DriverManager.getConnection(url);	
	        System.out.println("Yhteys avattu.");
	     }catch (Exception e){	
	    	 System.out.println("Yhteyden avaus ep�onnistui.");
	        e.printStackTrace();	         
	     }
	     return con;
	}
	
	public ArrayList<Vene> listaaKaikki(){
		ArrayList<Vene> veneet = new ArrayList<Vene>();
		sql = "SELECT * FROM veneet";       
		try {
			con=yhdista();
			if(con!=null){ //jos yhteys onnistui
				stmtPrep = con.prepareStatement(sql);        		
        		rs = stmtPrep.executeQuery();   
				if(rs!=null){ //jos kysely onnistui
					//con.close();					
					while(rs.next()){
						Vene vene = new Vene();
						vene.setTunnus(rs.getInt(1));
						vene.setNimi(rs.getString(2));
						vene.setMerkkimalli(rs.getString(3));	
						vene.setPituus(rs.getDouble(4));	
						vene.setLeveys(rs.getDouble(5));
						vene.setHinta(rs.getInt(6));
						veneet.add(vene);
					}					
				}				
			}	
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return veneet;
	}
	
	public ArrayList<Vene> listaaKaikki(String hakusana){
		ArrayList<Vene> veneet = new ArrayList<Vene>();
		sql = "SELECT * FROM veneet WHERE nimi LIKE ? or merkkimalli LIKE ? or pituus LIKE ? or leveys LIKE ? or hinta LIKE ?";      
		try {
			con=yhdista();
			if(con!=null){ //jos yhteys onnistui
				stmtPrep = con.prepareStatement(sql);
				stmtPrep.setString(1, "%" + hakusana + "%");
				stmtPrep.setString(2, "%" + hakusana + "%");
				stmtPrep.setString(3, "%" + hakusana + "%");   
				stmtPrep.setString(4, "%" + hakusana + "%"); 
				stmtPrep.setString(5, "%" + hakusana + "%");
        		rs = stmtPrep.executeQuery();   
				if(rs!=null){ //jos kysely onnistui
					//con.close();					
					while(rs.next()){
						Vene vene = new Vene();
						vene.setTunnus(rs.getInt(1));
						vene.setNimi(rs.getString(2));
						vene.setMerkkimalli(rs.getString(3));	
						vene.setPituus(rs.getDouble(4));	
						vene.setLeveys(rs.getDouble(5));
						vene.setHinta(rs.getInt(6));
						veneet.add(vene);
					}					
				}				
			}	
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return veneet; 
	}
	
	public boolean lisaaVene(Vene vene) {
		boolean paluuArvo=true;
		sql="INSERT INTO veneet VALUES(?,?,?,?,?,?)";						  
		try {
			con = yhdista();
			stmtPrep=con.prepareStatement(sql); 
			stmtPrep.setInt(1, vene.getTunnus());
			stmtPrep.setString(2, vene.getNimi());
			stmtPrep.setString(3, vene.getMerkkimalli());
			stmtPrep.setDouble(4, vene.getPituus());
			stmtPrep.setDouble(5, vene.getLeveys());
			stmtPrep.setInt(6, vene.getHinta());
			stmtPrep.executeUpdate();
	        con.close();
		} catch (Exception e) {				
			e.printStackTrace();
			paluuArvo=false;
		}				
		return paluuArvo;
	}
	
	public boolean poistaVene(String poistettavaID) {
		boolean paluuArvo=true;
		int poistettava = Integer.parseInt(poistettavaID);
		sql="DELETE FROM veneet WHERE tunnus=?";						  
		try {
			con = yhdista();
			stmtPrep=con.prepareStatement(sql); 
			stmtPrep.setInt(1, poistettava);			
			stmtPrep.executeUpdate();
	        con.close();
	        System.out.println("Tunnus poistettu.");
		} catch (Exception e) {				
			e.printStackTrace();
			paluuArvo=false;
		}				
		return paluuArvo;
	}
	
	public Vene etsiVene(String tunnus) {
		Vene vene = null;
		int etsittava = Integer.parseInt(tunnus);
		sql = "SELECT * FROM veneet WHERE tunnus=?";       
		try {
			con=yhdista();
			if(con!=null){ 
				stmtPrep = con.prepareStatement(sql); 
				stmtPrep.setInt(1, etsittava);
        		rs = stmtPrep.executeQuery();  
        		if(rs.isBeforeFirst()){ //jos kysely tuotti dataa, eli tunnus on k�yt�ss�
        			rs.next();
        			vene = new Vene();        			
        			vene.setTunnus(rs.getInt(1));
        			vene.setNimi(rs.getString(2));
					vene.setMerkkimalli(rs.getString(3));
					vene.setPituus(rs.getDouble(4));	
					vene.setLeveys(rs.getDouble(5));  
					vene.setHinta(rs.getInt(6));
				}        		
			}	
			con.close();  
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return vene;		
	}
	
	public boolean muutaVene(Vene vene){
		boolean paluuArvo=true;
		sql="UPDATE veneet SET tunnus=?, nimi=?, merkkimalli=?, pituus=?, leveys=?, hinta=? WHERE tunnus=?";						  
		try {
			con = yhdista();
			stmtPrep=con.prepareStatement(sql); 
			stmtPrep.setInt(1, vene.getTunnus());
			stmtPrep.setString(2, vene.getNimi());
			stmtPrep.setString(3, vene.getMerkkimalli());
			stmtPrep.setDouble(4, vene.getPituus());
			stmtPrep.setDouble(5, vene.getLeveys());
			stmtPrep.setInt(6, vene.getHinta());
			stmtPrep.setInt(7, vene.getTunnus());
			stmtPrep.executeUpdate();
	        con.close();
		} catch (Exception e) {				
			e.printStackTrace();
			paluuArvo=false;
		}				
		return paluuArvo;
	}
	
}

