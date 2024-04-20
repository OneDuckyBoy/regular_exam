package bg.softuni.regular_exam.models.entity;

import bg.softuni.regular_exam.models.enums.UserRoleEnum;
import org.junit.jupiter.api.Test;

import javax.management.relation.Role;

import static org.junit.jupiter.api.Assertions.*;

class UserRoleEntityTest {

    @Test
    void setId(){
        UserRoleEntity role = new UserRoleEntity();
        role.setId(1l);
        assertEquals(1l,role.getId());
    }
    @Test
    void setRole() {
        UserRoleEntity role = new UserRoleEntity();
        role.setRole(UserRoleEnum.ADMIN);
        role.setRole(UserRoleEnum.USER);
        assertEquals(UserRoleEnum.USER,role.getRole());
    }
}