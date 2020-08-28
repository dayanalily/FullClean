package daily.fullclean.springboot.models.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import daily.fullclean.springboot.models.entity.MenuMultidinamico;
import daily.fullclean.springboot.models.entity.Usuario;

public interface IMenuMultidinamicoDao extends JpaRepository<MenuMultidinamico, Long> {
	

	public MenuMultidinamico findByNombre(String nombre);
	@Query("select u from MenuMultidinamico u where u.nombre=?1")
	public Usuario findByNombre2(String nombre);
	public Page<MenuMultidinamico> findAll(Pageable pegeable);

}
