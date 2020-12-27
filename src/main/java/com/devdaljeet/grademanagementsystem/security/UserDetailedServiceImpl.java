package com.devdaljeet.grademanagementsystem.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.devdaljeet.grademanagementsystem.database.DatabaseAccess;

/** Represents the UserDetailedServiceImpl which loads all users from database to security 
 * @author Daljeet Singh (Dev-Daljeet)
 * @version 1.0
 */
@Service
public class UserDetailedServiceImpl implements UserDetailsService{

	@Autowired
	@Lazy
	DatabaseAccess da;

	/** Loads all the users by username
	 * @return userDetails An instance of class UserDetails
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//Find the user based on the user name
				com.devdaljeet.grademanagementsystem.beans.User user = da.findUserAccount(username);
				//If the user doesn't exist throw an exception
				if (user == null) {
					System.out.println("User not found: " + username);
					throw new UsernameNotFoundException
						("User " + username + " was not found in the database");
				}
				//Get a list of roles
				List<String> roleNames = da.getRolesById(user.getUserId());
				//Change the list of roles into a list of GrantedAuthority
				List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
				if (roleNames != null) {
					for(String role: roleNames) {
						grantList.add(new SimpleGrantedAuthority(role));
					}
				}
				//Create a user based on the information above.
				UserDetails userDetails = (UserDetails)new User(user.getUserName(), user.getEncryptedPassword(), grantList);		
				
				return userDetails;
	}

}
