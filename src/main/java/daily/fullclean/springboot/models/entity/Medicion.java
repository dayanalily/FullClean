package daily.fullclean.springboot.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
@Entity
@Table(name = "medicion")
public class Medicion implements Serializable{
	@Id
	// @GeneratedValue(strategy = GenerationType.SEQUENCE)
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "coordinador_seq")
	  @SequenceGenerator(sequenceName = "seq_coordinador", allocationSize = 1, name = "coordinador_seq")
	private long id;

	@NotEmpty(message = "No puede estar vacio")
	@Column(nullable = false, unique = true) // nullable = no guardar vacio , unique = no se debe repetir

	private String nombre;
	
	
	

	public long getId() {
		return id;
	}




	public void setId(long id) {
		this.id = id;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
