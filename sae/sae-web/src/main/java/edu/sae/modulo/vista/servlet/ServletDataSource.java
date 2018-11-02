package edu.sae.modulo.vista.servlet;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

// TODO: Auto-generated Javadoc
/**
 * The Class ServletDataSource.
 */
@WebServlet("/servicio_consultas.do")
public class ServletDataSource extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
       
	/** The l conexion. */
	@Resource(lookup = "java:/ONIX-ORCL")
	private DataSource lConexion;
	
    /**
     * Instantiates a new servlet data source.
     */
    public ServletDataSource() {
        super();
    }

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

}
