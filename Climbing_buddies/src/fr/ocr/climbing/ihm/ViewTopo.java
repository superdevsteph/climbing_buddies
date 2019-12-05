package fr.ocr.climbing.ihm;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.ocr.climbing.business.TopoCatalogBrowser;

@WebServlet( "/viewTopo" )
public class ViewTopo extends HttpServlet {

	private static final long serialVersionUID = 550038282401302959L;


	@Override
	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		HttpSession session = request.getSession( true );
		if ( session.getAttribute( "connectedUser" ) == null ) {
			response.sendRedirect( "login" );
			return;
		}
		
		request.getRequestDispatcher( "/viewTopo.jsp" ).forward( request, response );
	}
	
	@Override
	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		HttpSession session = request.getSession( true );
		if ( session.getAttribute( "connectedUser" ) == null ) {
			response.sendRedirect( "login" );
			return;
		}

		TopoCatalogBrowser browser = (TopoCatalogBrowser) session.getAttribute( "TopocatalogBrowser" );
		
		if ( request.getParameter( "btnPrevious" ) != null ) {
			browser.goPrevious();
		} else if ( request.getParameter( "btnNext" ) != null ) {
			browser.goNext();
		} else if ( request.getParameter( "btnAdd" ) != null ) {
			browser.addCurrentTopo();
		}
		
		request.getRequestDispatcher( "/viewTopo.jsp" ).forward( request, response );
	}
	
}