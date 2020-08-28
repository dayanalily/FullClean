package daily.fullclean.springboot.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import daily.fullclean.springboot.models.Imp.ICoordinadorServiceImp;
import daily.fullclean.springboot.models.dao.ICoordinadorDao;
import daily.fullclean.springboot.models.entity.Coordinador;

@Service
public class CoordinadorServiceImp implements ICoordinadorServiceImp {
	
	@Autowired
	private ICoordinadorDao coordinadorDao;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Coordinador> findall() {
		return (List<Coordinador>) coordinadorDao.findAll();
	}
	@Override
	@Transactional(readOnly = true)
	public Page<Coordinador> findall(Pageable pegeable) {	
		return coordinadorDao.findAll(pegeable);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Coordinador finById(Long id) {
		return coordinadorDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public Coordinador save(Coordinador coordinador) {
	
		return coordinadorDao.save(coordinador);
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		coordinadorDao.deleteById(id);
		
	}

	
	

	
}
