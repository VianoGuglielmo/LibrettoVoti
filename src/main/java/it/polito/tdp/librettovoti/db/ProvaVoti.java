package it.polito.tdp.librettovoti.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProvaVoti {
	
	public void aggiungiVoto(String nome, int punti) {
		String url= "jdbc:mysql://localhost:3306/libretto?user=root&password=12345"; //ripetere questo non va bene ripeterlo bisogna centralizzarlo
		try {
			Connection conn = DriverManager.getConnection(url);  //SI USA QUESTO PER FARE LE INSTRUZIONI
			String sql = "INSERT INTO voti (nome, punti) VALUES ( ?, ?)";
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, nome);
			st.setInt(2, punti);
			
			int res =st.executeUpdate();
			
			st.close();
			conn.close();
			
			if (res==1)
				System.out.println("Dato correttamente inserito");
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	public static void main(String[] args) {
		
		ProvaVoti provaVoti = new ProvaVoti();
		provaVoti.aggiungiVoto("Tecniche di Programmazione", 30);
		
		
		
		//SCHEMA GENERALE
		String url= "jdbc:mysql://localhost:3306/libretto?user=root&password=12345";
		
		try {
			Connection conn = DriverManager.getConnection(url);
			
			Statement st=conn.createStatement();//restituisce oggetto statement, coonessione costriusce l'oggetto statement va avanti e inditro sulla connessione
			
			String sql = "SELECT * FROM voti"; // la query (POTREBBE CAMBIARE)
			
			ResultSet res = st.executeQuery(sql); //contine risultato della query stessa metodo per spostare cursore sul data base
			
			while(res.next()) { // viene eseguito una volta per riga così non bobbiamo gestire casi particolati
				String nome = res.getString("nome"); // prende la colonna nome string perhè e di tipo string nome (E I CAMPI DIPENDE DA COSA SI RICHIEDE)
				int voto =res.getInt("punti"); // prende la colonna punti int perchè è di tipo int
				System.out.println(nome+ " "+ voto);	
			}

			st.close();// buona norma liberare lo statement così libera la memoria 
			
			conn.close(); // buona norma alla fine chiudere la conessione
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
