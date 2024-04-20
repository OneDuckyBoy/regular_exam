package bg.softuni.regular_exam.services.impl;

import bg.softuni.regular_exam.models.entity.UserRoleEntity;
import bg.softuni.regular_exam.models.enums.UserRoleEnum;
import bg.softuni.regular_exam.repositories.RoleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)

class RoleServiceImplTest {

    RoleServiceImpl roleService;

    @Mock
    private RoleRepository mockRoleRepository;
    @BeforeEach
    void before(){
        roleService = new RoleServiceImpl(mockRoleRepository);

    }
    @Test
    void getRoleFromEnum() {
        UserRoleEntity role = new UserRoleEntity();
        role.setRole(UserRoleEnum.USER);
        role.setId(1l);

        Mockito.when(mockRoleRepository.findByRole(UserRoleEnum.USER)).thenReturn(role);

        UserRoleEntity newRole= roleService.getRoleFromEnum(UserRoleEnum.USER);
        assertEquals(newRole,role);
    }
}