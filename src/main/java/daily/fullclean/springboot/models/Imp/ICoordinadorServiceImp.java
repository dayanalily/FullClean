package daily.fullclean.springboot.models.Imp;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import daily.fullclean.springboot.models.entity.Coordinador;

public interface ICoordinadorServiceImp {
	
	public List<Coordinador> findall();
	public Page<Coordinador> findall(Pageable pegeable);
	public Coordinador finById(Long id);
	public Coordinador save(Coordinador coordinador);
	public void  delete(Long id);

}
