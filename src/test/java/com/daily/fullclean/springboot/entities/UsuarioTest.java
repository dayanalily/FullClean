package com.daily.fullclean.springboot.entities;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import daily.fullclean.springboot.FullCleanApplication;
import daily.fullclean.springboot.models.entity.Role;
import daily.fullclean.springboot.models.entity.Usuario;

@SpringBootTest(classes = FullCleanApplication.class)
public class UsuarioTest {
	
	private Usuario usuario;
	List<Role>  role;

	
	@BeforeEach
	public void setupObject() {
		usuario = new Usuario();
		
	}
	
	@Test
	public void ShoudValidateSetterId() {
		usuario.setId(0);
		Assertions.assertEquals(0, usuario.getId());
	}
	
	@Test
	public void ShoudValidateSetterNombre() {
		usuario.setNombre("dayana");
		Assertions.assertEquals("dayana", usuario.getNombre());
	}
	

	@Test
	public void ShoudValidateSetterEmail() {
		usuario.setEmail("dayana@gmail.com");
		Assertions.assertEquals("dayana@gmail.com", usuario.getEmail());
	}

	
	@Test
	public void ShoudValidateSetterPassword() {
		usuario.setPassword("12345");
		Assertions.assertEquals("12345", usuario.getPassword());
	}
	
	
	@Test
	public void ShoudValidateSetterApellido() {
		usuario.setApellido("SANCHEZ");
		Assertions.assertEquals("SANCHEZ", usuario.getApellido());
	}
	
	@Test
	public void ShoudValidateSetterTipoDocumento() {
		usuario.setTipo_documento(0L);
		Assertions.assertEquals(0L, usuario.getTipo_documento());
	}

	@Test
	public void ShoudValidateSetterNumeroDocumento() {
		usuario.setNumero_documento(0L);
		Assertions.assertEquals(0L, usuario.getNumero_documento());
	}
	
	@Test
	public void ShoudValidateSetterTerminos() {
		usuario.setTerminos(false);
		Assertions.assertEquals(false, usuario.getTerminos());
	}
	@Test
	public void ShoudValidateSetterFoto() {
		usuario.setFoto(".get");
		Assertions.assertEquals(".get", usuario.getFoto());
	}
	
	
	@Test
	public void ShoudValidatePais() {
		usuario.setPais("1");
		Assertions.assertEquals("1", usuario.getPais());
	}
	@Test
	public void ShoudValidateOcupacion() {
		usuario.setOcupacion("dev");
		Assertions.assertEquals("dev", usuario.getOcupacion());
	}
	@Test
	public void ShoudValidateNombreEmpresa() {
		usuario.setNombreEmpresa("dailyCode");
		Assertions.assertEquals("dailyCode", usuario.getNombreEmpresa());
	}
	@Test
	public void ShoudValidateTelefono() {
		usuario.setTelefono("11221");
		Assertions.assertEquals("11221", usuario.getTelefono());
	}
	@Test
	public void ShoudValidateDireccion() {
		usuario.setDireccion("el jarillo");
		Assertions.assertEquals("el jarillo", usuario.getDireccion());
	}
	@Test
	public void ShoudValidateCiudad() {
		usuario.setCiudad("teques1");
		Assertions.assertEquals("teques1", usuario.getCiudad());
		}
	@Test
	public void ShoudValidateEstado() {
		usuario.setEstado("miranda");
		Assertions.assertEquals("miranda", usuario.getEstado());
	}
	@Test
	public void ShoudValidateCodigoPostal() {
		usuario.setCodigoPostal("1234");
		Assertions.assertEquals("1234", usuario.getCodigoPostal());
	}
	@Test
	public void ShoudValidateLinkedink() {
		usuario.setLinkedink("Linkedink");
		Assertions.assertEquals("Linkedink", usuario.getLinkedink());
	}
	@Test
	public void ShoudValidateFacebook() {
		usuario.setFacebook("Facebook");
		Assertions.assertEquals("Facebook", usuario.getFacebook());
	}
	@Test
	public void ShoudValidateInstagram() {
		usuario.setInstagram("Instagram");
		Assertions.assertEquals("Instagram", usuario.getInstagram());
	}
	@Test
	public void ShoudValidateTwittter() {
		usuario.setTwittter("Twittter");
		Assertions.assertEquals("Twittter", usuario.getTwittter());
	}
	
	@Test
	public void ShoudValidateRoles() {
		usuario.setRoles(role);
	  Assertions.assertEquals(role, usuario.getRoles());
	}

}
