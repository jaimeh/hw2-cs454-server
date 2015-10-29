package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GameDB {
	
	private String url = "jdbc:mysql://localhost:3306/game_db";
	private String db_username = "root";
	private String db_password = "";
	private Connection connection = null;
	private String user;
	private String password;
	private String character;
	
	public GameDB(){
		
	}
	
	public void connection() throws SQLException{
		System.out.println("Connecting database...");
		connection = DriverManager.getConnection(url, db_username, db_password);
		System.out.println("Database connected!");
	}
	
	public boolean checkLogin(String u, String pw){
		boolean login = false;
		String check = "SELECT * from users WHERE username = '"+u+"' AND password = '"+pw+"'";
		
		if(executeQuery(check) != false)
			login = true;
		return login;
		
	}
	
	public void register(String u, String pw){
		
		String add = "INSERT INTO users (username, password)"
				+ "VALUES ('"+u+"','"+pw+"')";
		
		executeUpdate(add);
		
	}
	
	public void chat(String u, String m){
		
		String add = "INSERT INTO chat (user, message)"
				+ "VALUES ('"+u+"','"+m+"')";
		
		executeUpdate(add);	
	}
	
	public void sendMessage(String f, String t, String m){
		
		String add = "INSERT INTO private_messages (fromUser, toUser, message)"
				+ "VALUES ('"+f+"','"+t+"','"+m+"')";
		
		executeUpdate(add);	
	}
	
	public ArrayList<String> retrieveChat(){
		
		boolean login = false;
		String retrieve = "SELECT * from chat";
		
		return executeChatQuery(retrieve);
		
	}
	
	public ArrayList<String> retrieveMessages(String u){
		
		
		String retrieve = "SELECT * from private_messages WHERE toUser ='"+u+"'";
		
		return executeMessageQuery(retrieve);
		
	}
	
	public void updateInfo(String u){
		
	}
	
	public boolean checkAvailability(String u){
		
		boolean login = false;
		String check = "SELECT * from users WHERE username = '"+u+"' ";
		
		if(executeQuery(check) != false)
			login = true;
		
		return login;
		
	}
	
	public void executeUpdate(String command){
		try {

			connection();
			    
			Statement stmt = connection.createStatement();

		    try{
		    	
		    	stmt.executeUpdate(command);
		    	System.out.println("process successfully!");
		    	
		    }
		    catch(SQLException s){
		    	//System.out.println("Process unsuccessful!");
		    	s.printStackTrace();
		    }//End of inner try catch
		    connection.close();
		}
		catch (Exception e){
			e.printStackTrace();
			
		}//End of outer try catch		
	}
	
	public ArrayList<String> executeMessageQuery(String command){
		ArrayList<String> query = new ArrayList<String>();
		try {

			connection();
			    
			Statement stmt = connection.createStatement();
			
		    try{
		    	
		    	ResultSet emp = stmt.executeQuery(command);
		    	System.out.println("process successfully!");
		    	
		    	while(emp.next()){
					
					String fromUser = emp.getString("fromUser");
					String message = emp.getString("message");
					
					
					String row = fromUser +" : "+ message;
					query.add(row);
					//System.out.println(row);
		    	}

				
		    }
		    catch(SQLException s){
		    	System.out.println("Process unsuccessful!");
		    	s.printStackTrace();
		    }//End of inner try catch
		    connection.close();
		}
		catch (Exception e){
			e.printStackTrace();
			
		}//End of outer try catch	
		return query;
	}
	
	public ArrayList<String> executeChatQuery(String command){
		ArrayList<String> query = new ArrayList<String>();
		try {

			connection();
			    
			Statement stmt = connection.createStatement();
			
		    try{
		    	
		    	ResultSet emp = stmt.executeQuery(command);
		    	System.out.println("process successfully!");
		    	
		    	while(emp.next()){
					
					String username = emp.getString("user");
					String message = emp.getString("message");
					
					
					String row = username +" : "+ message;
					query.add(row);
					//System.out.println(row);
		    	}

				
		    }
		    catch(SQLException s){
		    	System.out.println("Process unsuccessful!");
		    	s.printStackTrace();
		    }//End of inner try catch
		    connection.close();
		}
		catch (Exception e){
			e.printStackTrace();
			
		}//End of outer try catch	
		return query;
	}
	
	
	public boolean executeQuery(String command){
		boolean value = false;
		try {

			connection();
			    
			Statement stmt = connection.createStatement();
			
		    try{
		    	
		    	ResultSet result = stmt.executeQuery(command);
		    	System.out.println("process successfully!");
		    	
		    	if(result.next() != false){
		    		value = true;
		    	}else
		    		value = false;
				
		    }
		    catch(SQLException s){
		    	System.out.println("Process unsuccessful!");
		    	s.printStackTrace();
		    }//End of inner try catch
		    connection.close();
		}
		catch (Exception e){
			e.printStackTrace();
			
		}//End of outer try catch		
		return value;
	}
	

}
