package sidambarom.todolist.details;

import sidambarom.todolist.entity.Users;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Date : Mai 05-2022
 * Classe qui permet de stocker les information du user connecté
 * Il s'agit du controlleur.
 * @author Thomas Sidambarom
 * @version 1.0
 *
 */
public class MyUserDetails implements UserDetails {
	
	private Users user;
	
	public MyUserDetails(Users user) {
	        this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getMdp();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getLogin();
	}
	
	
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public String getFullName() {
        return user.getNom() + " " + user.getPrenom();
    }
	
	public int getUserId() {
		return user.getUsers_id();
	}

	
	

}
