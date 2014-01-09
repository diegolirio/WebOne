package br.com.tdv.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tdv.dao.ContatoDao;
import br.com.tdv.model.Contato;


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
    	String telefone = request.getParameter("telefone");
    	
    	try {
        	// Dao ----> Gravando no DB.
        	Contato c = new Contato();
        	c.setNome(nome);
        	c.setDataNascimento(Calendar.getInstance());
        	c.setEmail(email);
        	c.setTelefone(telefone);
        	c.setEndereco(endereco);
        	new ContatoDao().save(c);    		
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
    	out.println("<p>Telefone: "+telefone+"</p>");
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
