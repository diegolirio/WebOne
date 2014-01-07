package br.com.tdv.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcIdadeServlet
 */
@WebServlet("/mostrarIdade")
public class CalcIdadeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) {
		int idade = -1;
		String dataNasc = request.getParameter("dataNascimento");
		Calendar dataNascimento = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			dataNascimento.setTime(format.parse(dataNasc));			
			idade = getIdade(dataNascimento);
		} catch (ParseException e) {
			e.printStackTrace();
			idade = -99;
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("mostrar_idade.jsp?idade="+idade);
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}		
	}
	
	private static int getIdade(Calendar dataNascimento) {
		Calendar hoje = Calendar.getInstance();		
		int idade = hoje.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR);		
		if(idade > 0) {		
			if (
			   (hoje.get(Calendar.MONTH) == dataNascimento.get(Calendar.MONTH) && 
			    hoje.get(Calendar.DATE)  < dataNascimento.get(Calendar.DATE))
		        ) {				
				idade--;
			}
		}
		return idade;
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalcIdadeServlet() {
        super();
        // TODO Auto-generated constructor stub
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
