package bg.softuni.regular_exam.services.impl;

import bg.softuni.regular_exam.models.dto.UserRegisterDTO;
import bg.softuni.regular_exam.models.entity.UserEntity;
import bg.softuni.regular_exam.repositories.UserRepository;
import bg.softuni.regular_exam.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
}
