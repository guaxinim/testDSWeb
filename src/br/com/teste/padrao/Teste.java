package br.com.teste.padrao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class Teste
 */
public class Teste extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  private Connection conn;
	  private static final String DATASOURCE = "java:/jdbc/pgDS";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teste() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("######## Iniciando testes");
	      try {
	          InitialContext context = new InitialContext();
	          
	          response.setContentType("text/html");
	          PrintWriter out = response.getWriter();

	          out.println("<title>Resultado</title>" + "<body bgcolor=FFFFFF><br>");
	          String ds = (String) (request.getParameter("datasource") != null ? request.getParameter("datasource") : "");
	          out.println("<p> Datasource: " + ds);
	          System.out.println("DATASOURCE: -------- " + ds);
	          
	          DataSource dataSource = (DataSource) context.lookup(ds);
	          this.conn = dataSource.getConnection();
	          String sql = "SELECT nome from USUARIO";
	          
	          PreparedStatement ps = null;
	          ResultSet rs = null;
	          
	          ps = this.conn.prepareStatement(sql);
	          
	          System.out.println("######## Conexão: " + conn.getCatalog());
	          
	          rs = ps.executeQuery();

	          while (rs.next()) {
	              out.println("------------ Conexão: " + rs.getString("nome") + "<br>");
	          }
	          out.close();
	          conn.close();

	          
	        } catch (NamingException e) {
	          e.printStackTrace();
	        } catch (SQLException e) {
	          e.printStackTrace();
	        } finally {
	        	conn = null;
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
