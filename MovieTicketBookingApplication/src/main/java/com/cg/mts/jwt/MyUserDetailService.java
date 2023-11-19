package com.cg.mts.jwt;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cg.mts.entity.User;
import com.cg.mts.repository.UserRepository;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Service
public class MyUserDetailService implements UserDetailsService {

	
	@Autowired
	private UserRepository userDao;
	 private String name; 
	    private String password; 
	    private List<GrantedAuthority> authorities; 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	 
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				 getAuthority(user));
	}
	
	  private Set<SimpleGrantedAuthority> getAuthority(User user) {
	        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
	     
	            authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
	        return authorities;
	    }
}
