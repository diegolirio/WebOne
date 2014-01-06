package br.com.tdv.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AdicionaContatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdicionaContatoServlet() {
        super();
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String nome = request.getParameter("nome");
    	String endereco = request.getParameter("endereco");
    	String email = request.getParameter("email");
    	String data = request.getParameter("dataNascimento");
    	
    	try {
        	// Dao ----> Gravando no DB.    		
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	
    	PrintWriter out = response.getWriter();
    	out.println("<html>");
    	out.println("<body>");
    	out.println("<h4>Gravado com sucesso!</h4>");
    	out.println("<p>Nome: "+nome+"</p>");
    	out.println("<p>Endereço: "+endereco+"</p>");
    	out.println("<p>Email: "+email+"</p>");
    	out.println("<p>Data de Nascimento: "+data+"</p>");
    	out.println("<a href='add_contato.html'><<< Voltar</a>");
    	out.println("</body>");    	
    	out.println("</html>");
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
