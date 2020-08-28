package com.daily.fullclean.springboot.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import daily.fullclean.springboot.FullCleanApplication;
import daily.fullclean.springboot.models.entity.Region;

@SpringBootTest(classes = FullCleanApplication.class)
public class RegionTest {

	
	private Region region;

	@BeforeEach
	public void setupObject() {
		this.region = new Region();
	}
	
	
	@Test
	public void shouldValidateSetterId() {
		region.setId(0);
		Assertions.assertEquals(0, region.getId());
	}
	
	@Test
	public void shouldValidateSetterNombre() {
		region.setNombre("dayana");
		Assertions.assertEquals("dayana", region.getNombre());
	}
}
