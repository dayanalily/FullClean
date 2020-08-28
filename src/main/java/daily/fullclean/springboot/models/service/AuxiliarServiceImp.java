package daily.fullclean.springboot.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import daily.fullclean.springboot.models.Imp.IAuxiliarServiceImp;
import daily.fullclean.springboot.models.dao.IAuxiliarDao;
import daily.fullclean.springboot.models.entity.Auxiliar;

@Service
public class AuxiliarServiceImp implements IAuxiliarServiceImp {
	
	@Autowired
	private IAuxiliarDao auxiliarDao;

	

	@Override
	@Transactional(readOnly = true)
	public List<Auxiliar> findall() {
		return (List<Auxiliar>) auxiliarDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Auxiliar> findall(Pageable pegeable) {
		return auxiliarDao.findAll(pegeable);
	}
	@Override
	@Transactional(readOnly = true)
	public Auxiliar finById(Long id) {
		return auxiliarDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional()
	public Auxiliar save(Auxiliar auxiliar) {
		return auxiliarDao.save(auxiliar);
	}


	@Override
	@Transactional
	public void findByDelete(Long id) {
		auxiliarDao.deleteById(id);
		
	}



}
