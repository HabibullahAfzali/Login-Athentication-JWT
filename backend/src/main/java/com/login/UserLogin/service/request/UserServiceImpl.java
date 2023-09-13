package com.login.UserLogin.service.request;

import com.login.UserLogin.models.RoleEntity;
import com.login.UserLogin.models.UserEntity;
import com.login.UserLogin.repositories.RoleRepository;
import com.login.UserLogin.repositories.UserRepository;
import com.login.UserLogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void assignRolesToUser(AssignRoleRequest assignRoleRequest) {
		Long userId = assignRoleRequest.getUserId();
		Long roleId = assignRoleRequest.getRoleId();

		UserEntity user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
		RoleEntity role = roleRepository.findById(roleId).orElseThrow(() -> new RuntimeException("Role not found"));

		user.addRole(role); // Add the new role to the user

		userRepository.save(user);
	}
}
