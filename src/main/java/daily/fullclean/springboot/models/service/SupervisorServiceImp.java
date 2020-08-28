package daily.fullclean.springboot.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import daily.fullclean.springboot.models.Imp.ISupervisorServiceImp;
import daily.fullclean.springboot.models.dao.ISupervisorDao;
import daily.fullclean.springboot.models.entity.Supervisor;

@Service
public class SupervisorServiceImp implements ISupervisorServiceImp {
	
	@Autowired
	private ISupervisorDao supervisorDao;
	@Override
	@Transactional(readOnly = true)
	public List<Supervisor> findall() {
		return (List<Supervisor>) supervisorDao.findAll();
	}
	@Override
	@Transactional(readOnly = true)
	public Page<Supervisor> findall(Pageable pegeable) {
		
		return supervisorDao.findAll(pegeable);
	}
	@Override
	@Transactional(readOnly = true)
	public Supervisor finById(Long id) {
		return supervisorDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public Supervisor save(Supervisor supervisor) {
	
		return supervisorDao.save(supervisor);
	}
	@Override
	@Transactional
	public void delete(Long id) {
		supervisorDao.deleteById(id);
		
	}

	

}
