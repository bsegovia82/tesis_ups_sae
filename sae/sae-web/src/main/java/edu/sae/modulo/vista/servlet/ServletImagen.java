package edu.sae.modulo.vista.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.commons.io.IOUtils;
// TODO: Auto-generated Javadoc

/**
 * The Class ServletImagen.
 */
@WebServlet("/imagen.do")
public class ServletImagen extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The l conexion. */
	@Resource(lookup = "java:/ONIX-ORCL")
	private DataSource lConexion;

	/**
	 * Instantiates a new servlet imagen.
	 */
	public ServletImagen() {
		super();

	}

	/**
	 * Obtener imagen.
	 *
	 * @param codigoPregunta the codigo pregunta
	 * @return the input stream
	 * @throws Throwable the throwable
	 */
	private InputStream obtenerImagen(Long codigoPregunta) throws Throwable {
		PreparedStatement sentencia = null;
		ResultSet resultado = null;
		Connection lcon = null;
		try {
			lcon = lConexion.getConnection();
			sentencia = lcon.prepareStatement("select t.imagen from EVAL_PREGUNTA_BANCO t " + "where t.id_pregunta = ?");
			sentencia.setLong(1, codigoPregunta);
			resultado = sentencia
					.executeQuery();

			if (resultado.next()) {
				return resultado.getBinaryStream(1);
			} else {
				return null;
			}
		} finally {
			if (resultado != null) {
				resultado.close();
			}
			if (sentencia !=null)
			{
				sentencia.close();
			}
			if (lcon !=null)
			{
				lcon.close();
			}
		}

	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String codigoPregunta = request.getParameter("idPregunta");
		InputStream imagenByte = null;
		byte[] bytes = null;
		try {
			if (codigoPregunta != null) {
				imagenByte = obtenerImagen(new Long(codigoPregunta));
				bytes = IOUtils.toByteArray(imagenByte);
				response.reset();
				response.setContentLength(bytes.length);
				response.getOutputStream().write(bytes);
			} else {
				System.out.println("No hay imagen");
			}
		} catch (Throwable pError) {
			pError.printStackTrace();
		}
	}

}
