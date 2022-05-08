package dal;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public abstract class ConnectionProvider {
	private static DataSource datasource;

		public static Connection getConnection() {
			
			try {
				if(datasource == null) {
					Context context = new InitialContext();
					datasource = (DataSource) context.lookup("java:comp/env/jdbc/budget_bb");
				}
				return datasource.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
}
