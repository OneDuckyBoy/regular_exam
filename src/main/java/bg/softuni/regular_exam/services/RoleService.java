package bg.softuni.regular_exam.services;

import bg.softuni.regular_exam.models.entity.UserRoleEntity;
import bg.softuni.regular_exam.models.enums.UserRoleEnum;

public interface RoleService {
    UserRoleEntity getRoleFromEnum(UserRoleEnum role);

    void addRole(UserRoleEntity role);
    long getRoleCount();
}
