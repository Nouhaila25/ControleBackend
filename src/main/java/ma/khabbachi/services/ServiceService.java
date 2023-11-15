package ma.khabbachi.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ma.khabbachi.dao.IDao;
import ma.khabbachi.entities.Servece;
import ma.khabbachi.repository.ServiceRepository;





@Service
public class ServiceService implements IDao<Servece>{
	@Autowired
	private ServiceRepository serviceRepository;

	@Override
	public Servece create(Servece o) {
		return serviceRepository.save(o);
	}

	@Override
	public boolean delete(Servece o) {
		try {
			serviceRepository.delete(o);
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}

	@Override
	public Servece update(Servece o) {
		return serviceRepository.save(o);
	}

	@Override
	public List<Servece> findAll() {
		return serviceRepository.findAll();
	}

	@Override
	public Servece findById(Long id) {
		return serviceRepository.findById(id).orElse(null);
	}
	

}
