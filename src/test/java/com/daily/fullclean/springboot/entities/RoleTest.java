package com.daily.fullclean.springboot.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import daily.fullclean.springboot.FullCleanApplication;
import daily.fullclean.springboot.models.entity.Role;

@SpringBootTest(classes = FullCleanApplication.class)
public class RoleTest {
	
	private Role role;
	
	

	@BeforeEach
	public void setupObject() {
		this.role = new Role();
	}
	
	
	@Test
	public void shouldValidateSetterId() {
		role.setId(0);
		Assertions.assertEquals(0, role.getId());
	}
	
	@Test
	public void shouldValidateSetterNombre() {
		role.setNombre("dayana");
		Assertions.assertEquals("dayana", role.getNombre());
	}
	
	

}
