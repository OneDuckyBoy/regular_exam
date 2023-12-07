package bg.softuni.regular_exam.services;

import bg.softuni.regular_exam.models.dto.UserRegisterDTO;

public interface UserService {
    public void register(UserRegisterDTO userRegisterDTO);
}
