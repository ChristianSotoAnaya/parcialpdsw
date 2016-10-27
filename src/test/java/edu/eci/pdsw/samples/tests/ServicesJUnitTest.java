/*
 * Copyright (C) 2015 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.pdsw.samples.tests;

import edu.eci.pdsw.samples.services.ServiceFacadeException;
import edu.eci.pdsw.samples.services.ServicesFacade;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author hcadavid
 */
public class ServicesJUnitTest {

    public ServicesJUnitTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void clearDB() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:file:./target/db/testdb;MODE=MYSQL", "anonymous", "");
        Statement stmt = conn.createStatement();
        stmt.execute("delete from CONSULTAS");
        stmt.execute("delete from PACIENTES");
        
        conn.commit();
        conn.close();
    }

    /**
     * Obtiene una conexion a la base de datos de prueba
     * @return
     * @throws SQLException 
     */
    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:h2:file:./target/db/testdb;MODE=MYSQL", "anonymous", "");        
    }
    
    //@Test
    public void pruebaCeroTest() throws SQLException, ServiceFacadeException {
        //Insertar datos en la base de datos de pruebas, de acuerdo con la clase
        //de equivalencia correspondiente
        Connection conn=getConnection();
        Statement stmt=conn.createStatement();  
        
        stmt.execute("INSERT INTO `PACIENTES` (`id`, `tipo_id`, `nombre`, `fecha_nacimiento`) VALUES (9876,'ti','Carmenzo','1995-07-10')");
        stmt.execute("INSERT INTO `CONSULTAS` (`idCONSULTAS`, `fecha_y_hora`, `resumen`, `PACIENTES_id`, `PACIENTES_tipo_id`) VALUES (1262218,'2001-01-01 00:00:00','Gracias',9876,'ti')"); 
        
        
        ResultSet rs=stmt.executeQuery("select count(*) from PACIENTES");
        while (rs.next()){
            System.out.println(">>>>"+rs.getInt(1));
        }
        
        
        conn.commit();
        conn.close();
	
        //Realizar la operacion de la logica y la prueba
        
        ServicesFacade servicios=ServicesFacade.getInstance("h2-applicationconfig.properties");
        servicios.topNPacientesPorAnyo(2, 2005);	
        //assert ...
        Assert.fail("Pruebas no implementadas aun...");
        
    }    
    /*
    Caso de equivalencia "Frontera" : revisar los pasientes del año actual
    */
    //@Test
    public void pruebaCE1Test() throws SQLException, ServiceFacadeException {
        //Insertar datos en la base de datos de pruebas, de acuerdo con la clase
        //de equivalencia correspondiente
        Connection conn=getConnection();
        Statement stmt=conn.createStatement();  
        
        stmt.execute("INSERT INTO `PACIENTES` (`id`, `tipo_id`, `nombre`, `fecha_nacimiento`) VALUES (9876,'ti','Carmenzo','1995-07-10')");
        stmt.execute("INSERT INTO `CONSULTAS` (`idCONSULTAS`, `fecha_y_hora`, `resumen`, `PACIENTES_id`, `PACIENTES_tipo_id`) VALUES (1262218,'2001-01-01 00:00:00','Gracias',9876,'ti')"); 
        
        
        ResultSet rs=stmt.executeQuery("select count(*) from PACIENTES");
        while (rs.next()){
            System.out.println(">>>>"+rs.getInt(1));
        }
        
        
        conn.commit();
        conn.close();
	
        //Realizar la operacion de la logica y la prueba
        
        ServicesFacade servicios=ServicesFacade.getInstance("h2-applicationconfig.properties");
        servicios.topNPacientesPorAnyo(2, 2005);	
        //assert ...
        Assert.fail("Pruebas no implementadas aun...");
        
    }
    /*
    Caso de equivalencia "Normal" consular el primer paciente con mas consultas
    */
    //@Test
    public void pruebaCE2Test() throws SQLException, ServiceFacadeException {
        //Insertar datos en la base de datos de pruebas, de acuerdo con la clase
        //de equivalencia correspondiente
        Connection conn=getConnection();
        Statement stmt=conn.createStatement();  
        
        stmt.execute("INSERT INTO `PACIENTES` (`id`, `tipo_id`, `nombre`, `fecha_nacimiento`) VALUES (9876,'ti','Carmenzo','1995-07-10')");
        stmt.execute("INSERT INTO `CONSULTAS` (`idCONSULTAS`, `fecha_y_hora`, `resumen`, `PACIENTES_id`, `PACIENTES_tipo_id`) VALUES (1262218,'2001-01-01 00:00:00','Gracias',9876,'ti')"); 
        
        
        ResultSet rs=stmt.executeQuery("select count(*) from PACIENTES");
        while (rs.next()){
            System.out.println(">>>>"+rs.getInt(1));
        }
        
        
        conn.commit();
        conn.close();
	
        //Realizar la operacion de la logica y la prueba
        
        ServicesFacade servicios=ServicesFacade.getInstance("h2-applicationconfig.properties");
        servicios.topNPacientesPorAnyo(2, 2005);	
        //assert ...
        Assert.fail("Pruebas no implementadas aun...");
        
    }
    

}
