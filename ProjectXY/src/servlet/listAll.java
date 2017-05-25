package servlet;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

/**
 * Servlet que implementa uma busca de todos os pontos de interesse no BD
 */
@WebServlet("/listAll")
public class listAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource
	private UserTransaction ut;
	
	@PersistenceContext
	private EntityManager em;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String onde é salvo a Query que irá executar no BD
		String query = "SELECT nome FROM `mysql-xy`.pois;";
		
		//Variável que armazena o HTML básico utilizado como resposta
		String out = "<h1 style='margin:auto;padding: 10px;text-align: center;'>Todos os Pontos de Interesse</h1>";
		out=out.concat("<div style='margin:auto;width: 20%;border: 3px solid;padding: 10px;text-align: center;'>");
		
		try{
			//executa a consulta no BD
			Query q = em.createNativeQuery(query);
			List<String> list = q.getResultList();
			
			for (String a : list) {
				out=out.concat("<h4>" + a + "</h4>");//adiciona um item na página da lista de retorno
			}
			
		} catch (Exception f) {
            f.printStackTrace();
        }

		//Finaliza o HTML básico utilizado como resposta
		out=out.concat("</div>");
		out=out.concat("<center><h3><a href='index.jsp'>Voltar</a></h3></center>");
		response.getWriter().append(out).close();
	}

}
