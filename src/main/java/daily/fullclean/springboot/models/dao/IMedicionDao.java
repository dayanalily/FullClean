package daily.fullclean.springboot.models.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import daily.fullclean.springboot.models.entity.Medicion;

public interface IMedicionDao  extends JpaRepository<Medicion, Long>{
		
		public Medicion findByNombre(String nombre);
		@Query("select u from Medicion u where u.nombre=?1")
		public Medicion findByNombre2(String nombre);
		public Page<Medicion> findAll(Pageable pegeable);

}
