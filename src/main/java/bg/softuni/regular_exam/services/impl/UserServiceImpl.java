package bg.softuni.regular_exam.services.impl;

import bg.softuni.regular_exam.models.dto.UserRegisterDTO;
import bg.softuni.regular_exam.models.entity.ItemEntity;
import bg.softuni.regular_exam.models.entity.UserEntity;
import bg.softuni.regular_exam.repositories.UserRepository;
import bg.softuni.regular_exam.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;


    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }
    @Override
    public void register(UserRegisterDTO model) {

        model.setPassword(passwordEncoder.encode(model.getPassword()));
        UserEntity user = modelMapper.map(model, UserEntity.class);

        if (userRepository.findByEmail(user.getEmail()).isEmpty()){
            userRepository.save(user);
        }
    }
    public UserEntity GetUserByEmail(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        return userRepository.findByEmail(email).get();
    }

    public void saveItemToCart(ItemEntity item) {
        UserEntity user = GetUserByEmail();
        if (!user.getItemsInCart().contains(item)){
        user.AddToCart(item);
        }
        userRepository.save(user);
    }
    public void saveItemToLiked(ItemEntity item) {
        UserEntity user = GetUserByEmail();
        if (!user.getLikedItems().contains(item)){
        user.AddToLiked(item);
        }
        userRepository.save(user);
    }
    public void saveUser(UserEntity user){
        userRepository.save(user);
    }

    public void removeItemFromLiked(ItemEntity item) {
        UserEntity user = GetUserByEmail();
//        if (user.getLikedItems().contains(item)){
//            user.removeFromLiked(item);
//        }
        long userId = user.getId();
        long itemId = item.getId();
        userRepository.removeLikedItem(userId,itemId);
        List<ItemEntity> likedItems = user.getLikedItems();
//        likedItems.remove(item);
//        long id = item.getId();
//        likedItems.forEach(item1->{if (item1.getId().equals(id)){
//        likedItems.remove();
//        }
//        });

//        likedItems.remove(item);
//        user.setLikedItems(likedItems);
//        }
        userRepository.save(user);

    }public void removeItemFromCart(ItemEntity item) {
        UserEntity user = GetUserByEmail();
        if (user.getItemsInCart().contains(item)){
            user.removeFromCart(item);
        }
        userRepository.save(user);

    }
}
