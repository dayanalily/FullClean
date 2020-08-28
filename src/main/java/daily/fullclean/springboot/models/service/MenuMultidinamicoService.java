package daily.fullclean.springboot.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import daily.fullclean.springboot.models.Imp.IMenuMultidinamicoService;
import daily.fullclean.springboot.models.dao.IMenuMultidinamicoDao;
import daily.fullclean.springboot.models.entity.MenuMultidinamico;

@Service
public class MenuMultidinamicoService implements IMenuMultidinamicoService {
	@Autowired
	private IMenuMultidinamicoDao MenuMultidinamicoDao;
	
	@Override
	@Transactional(readOnly = true)
	 public List<MenuMultidinamico> findall() {
		return (List<MenuMultidinamico>) MenuMultidinamicoDao.findAll();
	}
	
	
	@Override
	@Transactional(readOnly = true)
		public Page<MenuMultidinamico> findall(Pageable pegeable) {
			return MenuMultidinamicoDao.findAll(pegeable);
	}
		
	@Override
	@Transactional(readOnly = true)
	public MenuMultidinamico finById(Long id) {
		return MenuMultidinamicoDao.findById(id).orElse(null);
	}
	@Override
	@Transactional
	public MenuMultidinamico save(MenuMultidinamico menuMultidinamcio) {
		return MenuMultidinamicoDao.save(menuMultidinamcio);
	}
	@Override
	@Transactional
	public void  delete(Long id) {
		MenuMultidinamicoDao.deleteById(id);
	}

}
