package com.helloworldandroid.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public  class BDController {
  private Connection connect = null;
  private Statement statement = null;
  private PreparedStatement preparedStatement = null;
  private ResultSet resultSet = null;
  private String host="",database="",user="",password="";
  
  public BDController(){
	  
  }  
  
  public String getHost() {	return host;}
  public void setHost(String host) {this.host = host;}
  public String getDatabase() {return database;}
  public void setDatabase(String database) {this.database = database;}
  public String getUser() {	return user;}
  public void setUser(String user) {this.user = user;}
  public String getPassword() {return password;}
  public void setPassword(String password) {this.password = password;}



  public void connect() throws Exception {
	  try {
      
		  Class.forName("com.mysql.jdbc.Driver");
		  connect = DriverManager
          .getConnection("jdbc:mysql://"+this.getHost()+"/"+this.getDatabase()+"?"
              + "user="+this.getUser()+"&password="+this.getPassword());
	  }catch (Exception e) {
		  throw e;
	  } finally {
		  close();
	  }
  }

  public void createStatement(String query) throws Exception {
	  statement = connect.createStatement();
      
      preparedStatement = connect.prepareStatement(query);  
  }

  // You need to close the resultSet
  private void close() {
    try {
      if (resultSet != null) {
        resultSet.close();
      }

      if (statement != null) {
        statement.close();
      }

      if (connect != null) {
        connect.close();
      }
    } catch (Exception e) {

    }
  }

} 
