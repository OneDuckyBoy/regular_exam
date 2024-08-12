package bg.softuni.regular_exam.innit;

import bg.softuni.regular_exam.models.entity.ItemCategory;
import bg.softuni.regular_exam.models.entity.UserRoleEntity;
import bg.softuni.regular_exam.models.enums.CategoriesEnum;
import bg.softuni.regular_exam.models.enums.UserRoleEnum;
import bg.softuni.regular_exam.services.ItemCategoryService;
import bg.softuni.regular_exam.services.RoleService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DBInnit {


    public DBInnit(RoleService roleService, ItemCategoryService itemCategoryService) {
        this.roleService = roleService;
        this.categoryService=itemCategoryService;
    }

    public RoleService roleService;
    public ItemCategoryService categoryService;
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

            List<String> categoryNames= new ArrayList<>();
            categoryNames.add("cablesAndOthers");
            categoryNames.add("Displays");
            categoryNames.add("LEDs");
            categoryNames.add("sensors");
            categoryNames.add("controllers");
            for (String categoryName : categoryNames) {
                ItemCategory category = new ItemCategory();
                category.setCategory(CategoriesEnum.valueOf(categoryName));
                categoryService.saveCategory(category);
            }

        }

    }
}
