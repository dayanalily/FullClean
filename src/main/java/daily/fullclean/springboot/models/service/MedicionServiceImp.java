package daily.fullclean.springboot.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import daily.fullclean.springboot.models.Imp.IMedicionServiceImp;
import daily.fullclean.springboot.models.dao.IMedicionDao;
import daily.fullclean.springboot.models.entity.Medicion;

@Service
public class MedicionServiceImp implements IMedicionServiceImp {
	
	@Autowired
	private IMedicionDao medicionDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Medicion> findall() {
		// TODO Auto-generated method stub
		return (List<Medicion>) medicionDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Medicion> findall(Pageable pegeable) {
		return medicionDao.findAll(pegeable);
	}

	@Override
	public Medicion save(Medicion medicion) {
		return medicionDao.save(medicion);
	}

	@Override
	public Medicion finById(Long id) {
		return medicionDao.findById(id).orElse(null);
	}

	@Override
	public void findByDelete(Long id) {
		medicionDao.deleteById(id);
		
	}

}
