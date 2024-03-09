package bg.softuni.regular_exam;

import bg.softuni.regular_exam.models.dto.UserRegisterDTO;
import bg.softuni.regular_exam.models.entity.UserEntity;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class RegularExamApplication {

    //todo to use SOLID principles
    public static void main(String[] args) {
        SpringApplication.run(RegularExamApplication.class, args);
    }

}
