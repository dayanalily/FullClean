package daily.fullclean.springboot.models.Imp;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import daily.fullclean.springboot.models.entity.Auxiliar;

public interface IAuxiliarServiceImp {
	
	public List<Auxiliar> findall();
    public Page<Auxiliar> findall(Pageable pegeable);
	public Auxiliar save(Auxiliar auxliar);
	public Auxiliar finById(Long id);
	public void findByDelete(Long id);

}
