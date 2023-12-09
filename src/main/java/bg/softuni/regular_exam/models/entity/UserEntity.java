package bg.softuni.regular_exam.models.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity{
    public UserEntity() {
    }

    public UserEntity(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String email;

    private String password;

    public List<UserRoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRoleEntity> roles) {
        this.roles = roles;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(

            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")

    )
    private List<UserRoleEntity> roles=new ArrayList<>();


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(

            name = "users_liked_items",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "liked_item_id")

    )
    private List<ItemEntity> likedItems;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(

            name = "users_items_in_cart",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "item_in_cart_id")

    )
    private List<ItemEntity> itemsInCart;


}
