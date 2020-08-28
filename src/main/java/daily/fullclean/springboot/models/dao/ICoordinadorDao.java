package daily.fullclean.springboot.models.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import daily.fullclean.springboot.models.entity.Coordinador;

	public interface ICoordinadorDao  extends JpaRepository<Coordinador, Long>{

		
		public Coordinador findByNombre(String nombre);
		@Query("select u from Coordinador u where u.nombre=?1")
		public Coordinador findByNombre2(String nombre);
		public Page<Coordinador> findAll(Pageable pegeable);


}
