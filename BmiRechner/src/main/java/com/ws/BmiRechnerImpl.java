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
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "test", "" );
            Statement stmt = con.createStatement();
            //stmt.executeUpdate( "DROP TABLE table1" );
            stmt.executeUpdate( "CREATE TABLE table1 ( user varchar(50) )" );
            stmt.executeUpdate( "INSERT INTO table1 ( user ) VALUES ( 'Claudio' )" );
            stmt.executeUpdate( "INSERT INTO table1 ( user ) VALUES ( 'Bernasconi' )" );
 
            ResultSet rs = stmt.executeQuery("SELECT * FROM table1");
            while( rs.next() )
            {
                String name = rs.getString("user");
                System.out.println( name );
            }
            stmt.close();
            con.close();
        }
        catch( Exception e )
        {
            System.out.println( "ERRORMELDUNG: " +e.getMessage() );
        }
	}

}
