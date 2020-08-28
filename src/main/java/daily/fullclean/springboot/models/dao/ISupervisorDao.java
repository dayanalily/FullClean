package daily.fullclean.springboot.models.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import daily.fullclean.springboot.models.entity.Supervisor;

public interface ISupervisorDao  extends JpaRepository<Supervisor, Long>{

	public Supervisor findByNombre(String nombre);
	@Query("select u from Supervisor u where u.nombre=?1")
	public Supervisor findByNombre2(String nombre);
	public Page<Supervisor> findAll(Pageable pegeable);
}

