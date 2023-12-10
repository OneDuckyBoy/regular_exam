package bg.softuni.regular_exam.repositories;


import bg.softuni.regular_exam.models.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findByEmail(String email);



    @Query(value = "delete from users_liked_items where user_id = {user_id} and liked_item_id ={item_id}",nativeQuery = true)
    void removeLikedItem(long user_id,long item_id);

}