package jp.co.fitec.lesson.kaku.bookstore;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * <p>DatabaseのConnectionを扱うUtility Class</p>
 * @author M.Yoneyama
 */
public class ConnectionUtils {

	/**
	 * <p>Property file取得した接続情報を使用してDatabaseに接続し、Connectionオブジェクトを取得する</p>
	 * 
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 */
	public static Connection getConnection() throws IOException, SQLException {
		
		Properties properies = new Properties();
		ClassLoader classLoader = ConnectionUtils.class.getClassLoader();
		Connection conn = null;
		
		// デフォルトでは「jdbc.properties」ファイルを使用
		try(InputStream in = classLoader.getResourceAsStream("jdbc.properties")) {

			if (in == null) { // プロパティ・ファイルがクラスパス上に存在しない場合
				throw new FileNotFoundException(
					"Can't find the propertie file 'jdbc.properties' in your classpath."
				);
			}

			properies.load(in); // プロパティ・ファイルのロード
			String url = properies.getProperty("url");
			String user = properies.getProperty("user");
			String pass = properies.getProperty("pass");
				
			if(url == null || user == null || pass == null) { // 読み込みに失敗した場合
				throw new IOException(
					"Make sure that you specify all properties 'url', 'user' and 'pass'"
				);
			}
			
			conn = getConnection(url, user, pass);

		} 

		return conn;
	}
	
	/**
	 * @param url
	 * @param user
	 * @param pass
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 */
	public static Connection getConnection(String url, String user, String pass) throws IOException, SQLException {
		return DriverManager.getConnection(url, user, pass);
	}
}
