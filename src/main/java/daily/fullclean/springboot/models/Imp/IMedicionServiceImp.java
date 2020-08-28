package daily.fullclean.springboot.models.Imp;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import daily.fullclean.springboot.models.entity.Medicion;

public interface IMedicionServiceImp {

	public List<Medicion> findall();
    public Page<Medicion> findall(Pageable pegeable);
	public Medicion save(Medicion medicion);
	public Medicion finById(Long id);
	public void findByDelete(Long id);
}
