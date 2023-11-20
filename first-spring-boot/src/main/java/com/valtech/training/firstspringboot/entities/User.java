package com.valtech.training.firstspringboot.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity

public class User  implements UserDetails{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String username;
	private String password;
	private boolean enabled;
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="roles", joinColumns = @JoinColumn(name="user_id",referencedColumnName = "id"))
	private List<String> roles;
	
	
	
	
	public User(String username, String password, List<String> roles) {
		this.username = username;
		this.password = password;
		this.roles = roles;
	}
	
	public User() {
	}
	public  void addRole(String role) {
		if(roles==null)roles= new ArrayList<String>();
		roles.add(role);
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return roles.stream().map(role-> new  SimpleGrantedAuthority(role)).toList();
	}

	@Override
	public boolean isAccountNonExpired() {
		return enabled;
	}

	@Override
	public boolean isAccountNonLocked() {
		return enabled;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return enabled;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id,username);
		
	}
	@Override
	public boolean equals(Object obj) {
		User user= (User)obj;
		return Objects.equals(id , user.id) && Objects.equals(username, user.username);
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", enabled=" + enabled
				+ ", roles=" + roles + "]";
	}

	
	
	

}
