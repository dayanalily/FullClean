package daily.fullclean.springboot.models.Imp;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import daily.fullclean.springboot.models.entity.MenuMultidinamico;

public interface IMenuMultidinamicoService {
	
	public List<MenuMultidinamico> findall();
	public Page<MenuMultidinamico> findall(Pageable pegeable);
	public MenuMultidinamico finById(Long id);
	public MenuMultidinamico save(MenuMultidinamico menuMultidinamico);
	public void  delete(Long id);
}
