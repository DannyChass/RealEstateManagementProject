/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daodemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author maithili
 */
public class EmployeeDaoImpl implements EmployeeDao{
   public void addEmployee(Employee employee)
  {
    Connection dbConnection = null;
    Statement statement=null;

    String sql = "insert into employee values(" + employee.getEmployeeId() + ","             + "'" + employee.getName()
                    + "'" + "," + employee.getAge() + ")";

    try
    {
      DataSource dataSource = new DataSource();
      dbConnection = dataSource.createConnection();
      statement = dbConnection.createStatement();
   
      statement.executeUpdate(sql);

      System.out.println("Record is inserted into Employee table for  Employee : " + employee.getName());

    }
    catch( SQLException e )
    {

      e.printStackTrace();

    }
    finally
    {

      if( statement != null )
      {
        try
        {
          statement.close();
        }
        catch( SQLException e )
        {
          e.printStackTrace();
        }
      }

      if( dbConnection != null )
      {
        try
        {
          dbConnection.close();
        }
        catch( SQLException e )
        {
          e.printStackTrace();
        }
      }

    }

  }

}
