package com.tesda.security;

import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.StringTokenizer;

import javax.persistence.EntityManagerFactory;

import org.apache.commons.lang.StringUtils;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;
import org.springframework.stereotype.Component;

import com.tdm.constant.AppConstant;
import com.tdm.dao.TDMAdminDAO;
import com.tdm.model.DO.TdmUserDO;
import com.tdm.model.DTO.TdmUserDTO;
import com.tdm.service.TDMAdminService;
import com.tdm.util.JDBCPreparedStatementSelect;

@Component
public class CustomLdapAuthoritiesPopulator implements LdapAuthoritiesPopulator
{
	
	private EntityManagerFactory factoryUser;
	JDBCPreparedStatementSelect jd = null;
	
	TdmUserDTO dto = null;
	TDMAdminService tdmAdminService = null;
	TDMAdminDAO tdmAdmindao = null;
	TdmUserDO userdo = new TdmUserDO();

	@Override
	public Collection<? extends GrantedAuthority> getGrantedAuthorities(
			DirContextOperations userData, String username)
	{
		
		String role= "", username_and_role="";
		jd = new JDBCPreparedStatementSelect();
		try {
			username_and_role = jd.selectRecordsFromTable(username);
			StringTokenizer st = new StringTokenizer(username_and_role, "-");
			while(st.hasMoreTokens()){
				username = st.nextToken();
				role = st.nextToken();
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		Collection<GrantedAuthority> gas = new HashSet<GrantedAuthority>();
		
		if (StringUtils.isNotEmpty(role) && role.equals(AppConstant.ROLE_USER)){		
			gas.add(new SimpleGrantedAuthority(AppConstant.ROLE_USER));
		}else if(StringUtils.isNotEmpty(role) && role.equals(AppConstant.ROLE_ADMIN)){
			gas.add(new SimpleGrantedAuthority(AppConstant.ROLE_ADMIN));
		}else if(StringUtils.isNotEmpty(role) && role.equals(AppConstant.ROLE_TDMUSER)){
			gas.add(new SimpleGrantedAuthority(AppConstant.ROLE_TDMUSER));
		}else if(StringUtils.isNotEmpty(role) && role.equals(AppConstant.ROLE_TDMADMIN)){
			gas.add(new SimpleGrantedAuthority(AppConstant.ROLE_TDMADMIN));
		}else{
			gas.add(new SimpleGrantedAuthority(AppConstant.ROLE_INVALID));
		}
		
		return gas;
	}
}
