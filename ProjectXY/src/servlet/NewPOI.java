package servlet;

import java.io.IOException;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import beans.POIs;

/**
 * Servlet utilizado para cadastrar novos pontos de interesse no banco de dados
 */
@WebServlet(urlPatterns={"/NewPOI", "/cadastro"})
public class NewPOI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource
	private UserTransaction ut;
	
	@PersistenceContext
	private EntityManager em;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//recebe os parametros enviados pelo formulário
		String nome = request.getParameter("nome");
		String coordenadaX = request.getParameter("coordenadaX");
		String coordenadaY = request.getParameter("coordenadaY");
		//converte os valores para numeros inteiros
		int x = Integer.parseInt(coordenadaX);
		int y = Integer.parseInt(coordenadaY);
		
		//cria um novo objeto
		POIs p = new POIs();
		p.setNome(nome);
		p.setCoordenadaX(x);
		p.setCoordenaday(y);
		
		try {
			ut.begin();//começa a transação com o BD
			em.persist(p);//armazena a informação no BD
			ut.commit();//comita a alteração
		} catch (Exception e){
			throw new ServletException(e);
		}
		
		//HTML básico utilizado como resposta do Cadastro
		String out = "<br><br><center><h1>Ponto de interesse criado com ID " + p.getId() + "</h1></center>" +
				"<br><center>Nome: " + nome + "</center>" + 
				"<br><center>Coordenada X: " + coordenadaX + "</center>" + 
				"<br><center>Coordenada Y: " + coordenadaY + "</center>" + 
				"<center><h3><a href='index.jsp'>Voltar</a></h3></center>";
		
		response.getWriter().append(out).close();
	}

}
