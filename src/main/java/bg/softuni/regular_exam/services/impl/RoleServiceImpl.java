package bg.softuni.regular_exam.services.impl;

import bg.softuni.regular_exam.models.entity.UserRoleEntity;
import bg.softuni.regular_exam.models.enums.UserRoleEnum;
import bg.softuni.regular_exam.repositories.RoleRepository;
import bg.softuni.regular_exam.services.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public UserRoleEntity getRoleFromEnum(UserRoleEnum role){
        return roleRepository.findByRole(role);
    }

    @Override
    public void addRole(UserRoleEntity role) {
        roleRepository.save(role);
    }

    @Override
    public long getRoleCount() {
        return roleRepository.count();
    }
}
