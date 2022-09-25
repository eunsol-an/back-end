package repository;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBConnector {
	private static Logger log = LoggerFactory.getLogger(DBConnector.class);
	
	public static Connection getConnection() {
		Connection cn = null;
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env"); // 기본 설정값
			DataSource ds = (DataSource) envContext.lookup("jdbc/mysql"); // 직접 설정한 name
			
			try { // 한번 더 try-catch 해준다
				cn = ds.getConnection();
			} catch (SQLException e) {
				log.info(">>> DB 연결정보 오류");
				e.printStackTrace();
				return null;
			}
		} catch (NamingException e) {
			log.info(">>> DBCP 설정 오류");
			e.printStackTrace();
			return null;
		}
		return cn;
	}
}