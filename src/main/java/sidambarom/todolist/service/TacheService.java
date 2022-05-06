package sidambarom.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sidambarom.todolist.entity.Tache;
import sidambarom.todolist.repository.TacheRepository;

@Service
public class TacheService {
	@Autowired
	private TacheRepository repository;
	
	public Tache saveTache(Tache tache) {
		return repository.save(tache);
	}
	

}
