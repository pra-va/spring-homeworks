package lt.prava.users.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.prava.users.model.Role;

public interface RoleRepository extends JpaRepository<Role, String> {

}
