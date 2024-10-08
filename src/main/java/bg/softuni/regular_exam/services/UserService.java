package bg.softuni.regular_exam.services;

import bg.softuni.regular_exam.models.dto.UserRegisterDTO;
import bg.softuni.regular_exam.models.entity.ItemEntity;
import bg.softuni.regular_exam.models.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public UserEntity register(UserRegisterDTO userRegisterDTO);

    UserEntity GetUserByEmail();

    Optional<UserEntity> GetUserByEmailOptional();

    void saveItemToCart(ItemEntity item);

    void removeItemsFromCart();

    void saveItemToLiked(ItemEntity item);

    void saveUser(UserEntity user);

    void removeItemFromLiked(ItemEntity item);

    void removeItemFromCart(ItemEntity item);

    List<ItemEntity> GetLikedItemsFromUser();

    List<ItemEntity> GetCartItemsFromUser();

    List<ItemEntity> GetLikedCartItemsFromUser();

    void setUserCartPrice(double price);

    void BuyItemsFromCart();
    List<ItemEntity> getBoughtItems();
}
