package bg.softuni.regular_exam.repositories;

import bg.softuni.regular_exam.models.entity.UserRoleEntity;
import bg.softuni.regular_exam.models.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<UserRoleEntity,Long> {

    UserRoleEntity findByRole(UserRoleEnum role);

}
