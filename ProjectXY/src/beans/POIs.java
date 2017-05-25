package beans;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Classe usada para encapsular e abstrair a entidade POIs (Pontos de Interesse)
 * 
 */
@Entity

public class POIs implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;
	private String nome;
	private Integer coordenadaX;
	private Integer coordenaday;   

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}   
	public Integer getCoordenadaX() {
		return this.coordenadaX;
	}

	public void setCoordenadaX(Integer coordenadaX) {
		this.coordenadaX = coordenadaX;
	}   
	public Integer getCoordenaday() {
		return this.coordenaday;
	}

	public void setCoordenaday(Integer coordenaday) {
		this.coordenaday = coordenaday;
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
   
}
