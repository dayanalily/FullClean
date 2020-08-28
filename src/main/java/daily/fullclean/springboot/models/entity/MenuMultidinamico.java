package daily.fullclean.springboot.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "menuMultidinamico")
public class MenuMultidinamico implements Serializable{
	


	@Id
	// @GeneratedValue(strategy = GenerationType.SEQUENCE)
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menu_seq")
	  @SequenceGenerator(sequenceName = "seq_menu", allocationSize = 1, name = "menu_seq")
	private long id;
	
	@NotEmpty(message = "No puede estar vacio")
	@Column(nullable = false, unique = true) // nullable = no guardar vacio , unique = no se debe repetir

	private String nombre;
	
	@NotEmpty(message = "No puede estar vacio")
	@Column(nullable = false, unique = true) // nullable = no guardar vacio , unique = no se debe repetir

	private String rut;
	
	@NotEmpty(message = "No puede estar vacio")
	@Column(nullable = false, unique = true) // nullable = no guardar vacio , unique = no se debe repetir

	private String direccion;
	
//	@NotEmpty(message = "No puede estar vacio")
//	@Column(nullable = false, unique = true) // nullable = no guardar vacio , unique = no se debe repetir

//	private String coordinador;

	@ManyToMany(cascade = CascadeType.MERGE,fetch= FetchType.LAZY)
	// para asociar con role
	@JoinTable(name = "coordinador", joinColumns = @JoinColumn(name = "coordinador_id"), inverseJoinColumns = @JoinColumn(name = "role_id"), uniqueConstraints = {
			@UniqueConstraint(columnNames = { "coordinador_id", "role_id" }) })
	private List<Coordinador> coordinador;


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



	public String getRut() {
		return rut;
	}



	public void setRut(String rut) {
		this.rut = rut;
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public List<Coordinador> getCoordinador() {
		return coordinador;
	}



	public void setCoordinador(List<Coordinador> coordinador) {
		this.coordinador = coordinador;
	}


	



	



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
