package bg.softuni.regular_exam.services.impl;

import bg.softuni.regular_exam.models.entity.UserEntity;
import bg.softuni.regular_exam.models.entity.UserRoleEntity;
import bg.softuni.regular_exam.repositories.UserRepository;
import bg.softuni.regular_exam.services.ArduinoUserDetailsService;
import org.springframework.security.config.annotation.web.configurers.RememberMeConfigurer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//@Service
public class ArduinoUserDetailsServiceImpl implements  UserDetailsService {


    private final UserRepository userRepository;

    public ArduinoUserDetailsServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;

    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository
                .findByEmail(email)
                .map(ArduinoUserDetailsServiceImpl::map)
                .orElseThrow(() -> new UsernameNotFoundException("User " + email + " not found!"));
    }

    public static UserDetails map(UserEntity userEntity) {

        return User
                .withUsername(userEntity.getEmail())
                .password(userEntity.getPassword())
                .authorities(userEntity.getRoles().stream().map(ArduinoUserDetailsServiceImpl::map).toList())
                .build();
    }

    private static GrantedAuthority map(UserRoleEntity userRoleEntity) {
        return new SimpleGrantedAuthority(
                "ROLE_"+userRoleEntity.getRole().name());
    }
}