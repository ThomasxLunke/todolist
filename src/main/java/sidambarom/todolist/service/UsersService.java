package sidambarom.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import sidambarom.todolist.details.MyUserDetails;
import sidambarom.todolist.entity.Users;
import sidambarom.todolist.repository.UsersRepository;

@Service
public class UsersService implements UserDetailsService {
	
	@Autowired
    private UsersRepository userRepo;
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Users user = userRepo.findByLogin(login);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new MyUserDetails(user);
	}
	
	
}
