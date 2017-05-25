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
 * Servlet que implementa a busca dos pontos de interesse no BD de acordo com sua proximidade
 */
@WebServlet("/list")
public class list extends HttpServlet {
	private static final long serialVersionUID = 1L;
      

	@Resource
	private UserTransaction ut;
	
	@PersistenceContext
	private EntityManager em;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//recebe os parametros enviados pelo formulário
		String coordenadaX = request.getParameter("coordenadaX");
		String coordenadaY = request.getParameter("coordenadaY");
		String dMax = request.getParameter("dMax");
		//converte os valores para numeros inteiros
		int x = Integer.parseInt(coordenadaX);
		int y = Integer.parseInt(coordenadaY);
		int max = Integer.parseInt(dMax);
				
		//String onde é salvo a Query que irá executar no BD
		//Dentro da Query é feito a lógica da busca dos POIs por proximidade
		String query = "SELECT nome FROM `mysql-xy`.pois WHERE abs(" + x + " - coordenadaX) + abs(" + y + " - coordenadaY) <= " + max + ";";
		
		//Variável que armazena o HTML básico utilizado como resposta
		String out = "<h1 style='margin:auto;padding: 10px;text-align: center;'>Pontos de interesse por proximidade dado:</h1>";
		out=out.concat("<h3 style='margin:auto;padding: 10px;text-align: center;'>Coordenada X: "+x+" - Coordenada Y: "+y+"</h3>");
		out=out.concat("<h3 style='margin:auto;padding: 10px;text-align: center;'>Distância da Busca: "+max+"</h3>");
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
