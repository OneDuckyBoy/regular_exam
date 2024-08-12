package bg.softuni.regular_exam.innit;

import bg.softuni.regular_exam.models.entity.UserRoleEntity;
import bg.softuni.regular_exam.models.enums.UserRoleEnum;
import bg.softuni.regular_exam.services.RoleService;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
public class DBInnit {


    public DBInnit(RoleService roleService) {
        this.roleService = roleService;
    }

    public RoleService roleService;
    @PostConstruct
    public void init() {
       // System.out.println("Halloo");
        if (roleService.getRoleCount()==0){

        UserRoleEntity userRole = new UserRoleEntity();
        userRole.setRole(UserRoleEnum.USER);
        roleService.addRole(userRole);
        UserRoleEntity adminRole = new UserRoleEntity();
        adminRole.setRole(UserRoleEnum.ADMIN);
        roleService.addRole(adminRole);
    }
    }
}
