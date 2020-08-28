package com.daily.fullclean.springboot.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import daily.fullclean.springboot.FullCleanApplication;
import daily.fullclean.springboot.models.entity.Pais;


@SpringBootTest(classes = FullCleanApplication.class)
public class PaisTests {
	
	private Pais pais;
	
	@BeforeEach
	public void setupObject() {
		this.pais = new Pais();
	}
	
	@Test
	public void shouldValidateSetterId() {
		pais.setId(0);
		Assertions.assertEquals(0, pais.getId());
	}
	
	@Test
	public void shouldValidateSetterNombre() {
		pais.setNombre("dayana");
		Assertions.assertEquals("dayana", pais.getNombre());
	}

}
