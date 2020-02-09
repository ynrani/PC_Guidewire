package com.datacon.model.DTO;

public class UserAccount
{

	private String Username;
	private boolean Enabled;
	private boolean AccountNonExpired;
	private boolean credentialsNonExpired;
	private boolean AccountNonLocked;
	private boolean GrantedAuthorities;

	public String getUsername()
	{
		return Username;
	}

	public void setUsername(String username)
	{
		Username = username;
	}

	public boolean isEnabled()
	{
		return Enabled;
	}

	public void setEnabled(boolean enabled)
	{
		Enabled = enabled;
	}

	public boolean isAccountNonExpired()
	{
		return AccountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired)
	{
		AccountNonExpired = accountNonExpired;
	}

	public boolean isCredentialsNonExpired()
	{
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired)
	{
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public boolean isAccountNonLocked()
	{
		return AccountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked)
	{
		AccountNonLocked = accountNonLocked;
	}

	public boolean isGrantedAuthorities()
	{
		return GrantedAuthorities;
	}

	public void setGrantedAuthorities(boolean grantedAuthorities)
	{
		GrantedAuthorities = grantedAuthorities;
	}
}
