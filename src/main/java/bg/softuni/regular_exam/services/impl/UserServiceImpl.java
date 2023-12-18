package bg.softuni.regular_exam.services.impl;

import bg.softuni.regular_exam.models.dto.UserRegisterDTO;
import bg.softuni.regular_exam.models.entity.ItemEntity;
import bg.softuni.regular_exam.models.entity.UserEntity;
import bg.softuni.regular_exam.models.entity.UserRoleEntity;
import bg.softuni.regular_exam.models.enums.UserRoleEnum;
import bg.softuni.regular_exam.repositories.UserRepository;
import bg.softuni.regular_exam.services.RoleService;
import bg.softuni.regular_exam.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    private final RoleService roleService;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper, RoleService roleService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
        this.roleService = roleService;
    }
    @Override
    public UserEntity register(UserRegisterDTO model) {

        model.setPassword(passwordEncoder.encode(model.getPassword()));
        UserEntity user = modelMapper.map(model, UserEntity.class);
        modelMapper.map(model, user);
        UserRoleEntity roleUser = roleService.getRoleFromEnum(UserRoleEnum.USER);
        user.AddRole(roleUser);
        if (model.isAdmin()){
            UserRoleEntity roleAdmin =roleService.getRoleFromEnum(UserRoleEnum.ADMIN);
            user.AddRole(roleAdmin);
        }

//        System.out.println();
        if (userRepository.findByEmail(user.getEmail()).isEmpty()){
            userRepository.save(user);
        }
        return user;
    }
    @Override
    public UserEntity GetUserByEmail(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        return userRepository.findByEmail(email).get();
    }
    @Override
    public Optional<UserEntity> GetUserByEmailOptional(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveItemToCart(ItemEntity item) {
        UserEntity user = GetUserByEmail();
        if (!user.getItemsInCart().contains(item)){
        user.AddToCart(item);
        }
        userRepository.save(user);
    }
    @Override
    public void saveItemToLiked(ItemEntity item) {
        UserEntity user = GetUserByEmail();
        if (!user.getLikedItems().contains(item)){
        user.AddToLiked(item);
        }
        userRepository.save(user);
    }
    @Override
    public void saveUser(UserEntity user){
        userRepository.save(user);

    }

    @Override
    public void removeItemFromLiked(ItemEntity item) {
        UserEntity user = GetUserByEmail();
        long itemId = item.getId();
        List<ItemEntity> likedItems = user.getLikedItems();

        List<ItemEntity> test = new ArrayList<>();
        for (ItemEntity likedItem : likedItems) {
            if (likedItem.getId().equals(itemId)){
                test.add( likedItem);
            }
        }
        likedItems.removeAll(test);
        user.setLikedItems(likedItems);

        userRepository.save(user);

    }
    @Override
    public void removeItemFromCart(ItemEntity item) {
        UserEntity user = GetUserByEmail();
        long itemId = item.getId();
        List<ItemEntity> cartItems = user.getItemsInCart();

        List<ItemEntity> test1 = new ArrayList<>();
        for (ItemEntity cartItem : cartItems) {
            if (cartItem.getId().equals(itemId)){
                test1.add( cartItem);
            }
        }
        cartItems.removeAll(test1);
        user.setItemsInCart(cartItems);
        userRepository.save(user);

    }


    @Override
    public List<ItemEntity> GetLikedItemsFromUser(){
        UserEntity user = GetUserByEmail();
        return user.getLikedItems();

    }@Override
    public List<ItemEntity> GetCartItemsFromUser(){
        UserEntity user = GetUserByEmail();
        List<ItemEntity> itemsInCart = user.getItemsInCart();

        return itemsInCart;

    }

    @Override
    public List<ItemEntity> GetLikedCartItemsFromUser() {
        UserEntity user = GetUserByEmail();
        List<ItemEntity> itemsInCart = user.getItemsInCart();
        List<ItemEntity> likedItems = user.getLikedItems();
        List<ItemEntity> x = new ArrayList<>();
        for (ItemEntity item : itemsInCart) {

            for (ItemEntity likedItem : likedItems) {
                if (item.getId().equals(likedItem.getId())){
                    x.add(item);
                }
            }
//            if (present){
//
//            }
        }
//        likedItemsInCart.retainAll(user.getLikedItems());
        System.out.println();
        return x;
    }

    @Override
    public void setUserCartPrice(double price) {
        UserEntity user = GetUserByEmail();
        user.setCartPrice(price);

        userRepository.save(user);

    }
}
