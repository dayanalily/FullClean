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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "supervisor")
public class Supervisor implements Serializable{


	@Id
	// @GeneratedValue(strategy = GenerationType.SEQUENCE)
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supervisor_seq")
	  @SequenceGenerator(sequenceName = "seq_supervisor", allocationSize = 1, name = "supervisor_seq")
	
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


	@NotEmpty(message = "No puede estar vacio")
	@Column(nullable = false, unique = true) // nullable = no guardar vacio , unique = no se debe repetir

	private String apellido;

	@NotEmpty(message = "No puede estar vacio")
	@Email(message = "No es una direccion de correo valida")
	@Column(nullable = false, unique = true) // nullable = no guardar vacio , unique = no se debe repetir

	private String email;


	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	// para asociar con role
	@JoinTable(name = "coordinador", joinColumns = @JoinColumn(name = "coordinador_id"), inverseJoinColumns = @JoinColumn(name = "role_id"), uniqueConstraints = {
			@UniqueConstraint(columnNames = { "coordinador_id", "role_id" }) })
	private List<Coordinador> coodinador;

	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	// para asociar con role
	@JoinTable(name = "usuario_roles", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "role_id"), uniqueConstraints = {
			@UniqueConstraint(columnNames = { "usuario_id", "role_id" }) })
	private List<Role> roles;

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

	public List<Coordinador> getCoodinador() {
		return coodinador;
	}

	public void setCoodinador(List<Coordinador> coodinador) {
		this.coodinador = coodinador;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
