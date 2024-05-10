package bg.softuni.regular_exam.services.impl;

import bg.softuni.regular_exam.models.entity.UserEntity;
import bg.softuni.regular_exam.models.entity.UserRoleEntity;
import bg.softuni.regular_exam.repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

//@Service
public class UserDetailsServiceImpl implements  UserDetailsService {


    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;

    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository
                .findByEmail(email)
                .map(UserDetailsServiceImpl::map)
                .orElseThrow(() -> new UsernameNotFoundException("User " + email + " not found!"));
    }

    public static UserDetails map(UserEntity userEntity) {

        return User
                .withUsername(userEntity.getEmail())
                .password(userEntity.getPassword())
                .authorities(userEntity.getRoles().stream().map(UserDetailsServiceImpl::map1).toList())
                .build();
    }

    public static GrantedAuthority map1(UserRoleEntity userRoleEntity) {
        return new SimpleGrantedAuthority(
                "ROLE_"+userRoleEntity.getRole().name());
    }
}