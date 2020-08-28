package daily.fullclean.springboot.models.Imp;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import daily.fullclean.springboot.models.entity.Supervisor;

public interface ISupervisorServiceImp {
	public List<Supervisor> findall();
	public Page<Supervisor> findall(Pageable pegeable);
	public Supervisor finById(Long id);
	public Supervisor save(Supervisor supervisor);
	public void  delete(Long id);

}
