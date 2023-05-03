package factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	public static Connection getConnection() throws Exception {

		Class.forName("org.postgresql.Driver");

		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/bd_vct_aula04",
				"postgres", "coti");

	}

}
