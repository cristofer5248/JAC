package com.jac.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jac.app.models.entity.Role;

public interface IRolesDao extends CrudRepository<Role, Long> {
	
	@Query ("select r from Role r where r.user_id =?1 and r.authority=?2")
	public Role findByUser_idByAuthority(Long id, String rol);
	

	@Query ("select r from Role r where r.user_id =?1")
	public Role findByUser_id(Long id);
	
	@Query ("select r from Role r where r.user_id =?1 and (authority='ROLE_JEFEADM' or authority='ROLE_ADMIN')")
	public Role findByUser_idUnique(Long id);
	
	@Query ("select r from Role r where r.user_id =?1")
	public List<Role> findByUser_idList(Long id);
	
}
