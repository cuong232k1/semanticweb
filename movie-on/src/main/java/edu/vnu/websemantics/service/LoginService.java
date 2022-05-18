package edu.vnu.websemantics.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.vnu.websemantics.dao.UserDAO;
import edu.vnu.websemantics.model.User;

@Service
public class LoginService implements UserDetailsService {

	@Autowired
	UserDAO userDAO;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userDAO.findUserByName(userName);
		if (user == null)
			throw new UsernameNotFoundException("User Not Found");
		List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
		//System.out.print(authorities);
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);

	}

}
