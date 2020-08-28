package daily.fullclean.springboot.models.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import daily.fullclean.springboot.models.entity.Auxiliar;

public interface IAuxiliarDao extends JpaRepository<Auxiliar, Long>{
	
	public Auxiliar findByNombre(String nombre);
	@Query("select u from Auxiliar u where u.nombre=?1")
	public Auxiliar findByNombre2(String nombre);
	public Page<Auxiliar> findAll(Pageable pegeable);


}
