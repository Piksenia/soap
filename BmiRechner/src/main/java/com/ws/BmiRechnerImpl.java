package com.ws;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.jws.WebService;

//Service Implementation Bean

@WebService(endpointInterface = "com.ws.BmiRechner")
public class BmiRechnerImpl  implements BmiRechner{

	public String getHello() {
		return "Hello World JAX-WS";
	}

	public double getBmi(double gewicht, double groesse) {
		double ergebnis = 0.0;
		ergebnis = gewicht/ (groesse * groesse);
		return ergebnis;
	}
	
	public void createDB() {
        try
        {
            Class.forName("org.h2.Driver");
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "", "" );
            Statement stmt = con.createStatement();
            
            stmt.executeUpdate( "DROP TABLE Hersteller" );
            stmt.executeUpdate( "DROP TABLE Bonbon" );
            stmt.executeUpdate( "DROP TABLE Schokolade" );
            stmt.executeUpdate( "DROP TABLE Administrator" );
            
            stmt.executeUpdate( "CREATE TABLE Hersteller ( h_ID varchar(50) not null primary key ,name varchar(50),straße varchar(50), hausnummer varchar(50), plz varchar(50), ort varchar(50));" );
            stmt.executeUpdate( "CREATE TABLE Bonbon ( b_ID varchar(50) not null primary key , hersteller varchar(50), bezeichnung varchar(50), gewicht decimal, preis decimal, farbe varchar(50));" );
            stmt.executeUpdate( "CREATE TABLE Schokolade ( s_ID varchar(50) not null primary key , hersteller varchar(50), bezeichnung varchar(50), kakaoanteil decimal, gewicht decimal, art varchar(50), preis decimal, alkoholhaltig boolean);" );
            stmt.executeUpdate( "CREATE TABLE Administrator ( a_ID varchar(50) not null primary key ,name varchar(50), vorname varchar(50));" );
            
            stmt.executeUpdate("ALTER TABLE Bonbon ADD FOREIGN KEY(hersteller) REFERENCES Hersteller(h_ID)");
            stmt.executeUpdate("ALTER TABLE Schokolade ADD FOREIGN KEY(hersteller) REFERENCES Hersteller(h_ID)");
            
            stmt.executeUpdate( "INSERT INTO Hersteller VALUES ( '1H','Ferrero', 'Am Waschbrett', '10a', '410523', 'Nordpol' )" );
            stmt.executeUpdate( "INSERT INTO Hersteller VALUES ( '2H','Mars', 'Breiter Weg', '1', '565656', 'Manchheim' )" );
            stmt.executeUpdate( "INSERT INTO Hersteller VALUES ( '3H','Lindt', 'Karlstraße', '12', '41055', 'Aachen' )" );
            
            stmt.executeUpdate( "INSERT INTO Bonbon VALUES ( '1B', '1H', 'Saurer Drop', 20.0, 0.20, 'gelb' )" );
            stmt.executeUpdate( "INSERT INTO Bonbon VALUES ( '2B','1H', 'Süßer Drop', 15.0, 0.10, 'orange' )" );
            stmt.executeUpdate( "INSERT INTO Bonbon VALUES ( '3B','2H', 'Kleine Bombe', 18.0, 0.12, 'rot' )" );
            stmt.executeUpdate( "INSERT INTO Bonbon VALUES ( '4B','3H', 'Lucky bomb', 22.0, 0.15, 'blau' )" );
            stmt.executeUpdate( "INSERT INTO Bonbon VALUES ( '5B','3H', 'Großer Drop', 29.0, 0.25, 'blau' )" );
            
            stmt.executeUpdate( "INSERT INTO Schokolade VALUES ( '1S','3H', 'Schokoküsschen', 0.20, 0.20, 'Praline', 0.50, true )" );
            stmt.executeUpdate( "INSERT INTO Schokolade VALUES ( '2S','3H', 'Schokohase', 0.50, 0.80, 'Riegel', 0.60, false )" );
            stmt.executeUpdate( "INSERT INTO Schokolade VALUES ( '3S','2H', 'Schokoweihnachtsmann', 0.50, 0.60, 'Praline', 1.50, true )" );
            stmt.executeUpdate( "INSERT INTO Schokolade VALUES ( '4S','2H', 'Schokobär', 0.30, 0.90, 'Praline', 1.80, true )" );
            stmt.executeUpdate( "INSERT INTO Schokolade VALUES ( '5S','2H', 'Schokokatze', 0.30, 0.70, 'Riegel', 1.30, false )" );
            
            stmt.executeUpdate( "INSERT INTO Administrator VALUES ( '1A', 'Billinger', 'Xenia' )" );
            stmt.executeUpdate( "INSERT INTO Administrator VALUES ( '2A','Lichottka', 'Christopher' )" );
            stmt.executeUpdate( "INSERT INTO Administrator VALUES ( '3A','Otto', 'Denise' )" );
 
            /* Testaufrufe der angelegten Tabellen und eingefügten Daten
            ResultSet rs1 = stmt.executeQuery("SELECT * FROM Hersteller");
            while( rs1.next() )
            {
                String name = rs1.getString("name");
                
                System.out.println( name );
            }
            
            ResultSet rs2 = stmt.executeQuery("SELECT * FROM Bonbon");
            while( rs2.next() )
            {
                String name = rs2.getString("bezeichnung");
                
                System.out.println( name );
            }
            
            ResultSet rs3 = stmt.executeQuery("SELECT * FROM Schokolade");
            while( rs3.next() )
            {
                String name = rs3.getString("bezeichnung");
                
                System.out.println( name );
            }
            
            ResultSet rs4 = stmt.executeQuery("SELECT * FROM Administrator");
            while( rs4.next() )
            {
                String name = rs4.getString("vorname");
                
                System.out.println( name );
            }*/
            stmt.close();
            con.close();
        }
        catch( Exception e )
        {
            System.out.println( "ERRORMELDUNG: " +/*e.getMessage()+*/ e.toString());
        }
	}

}
