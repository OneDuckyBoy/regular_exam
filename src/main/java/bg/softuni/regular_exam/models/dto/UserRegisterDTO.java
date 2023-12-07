package bg.softuni.regular_exam.models.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;


public class UserRegisterDTO {
    public UserRegisterDTO() {
    }

    public UserRegisterDTO(String email, String password, String confirmPassword) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    //    @NotNull
    @NotBlank
    @Email
    private String email;
    //    @NotNull
//    @Length(min = 3,max = 20) //max 20
    private String password;
//    @NotNull
//    @Length(min = 3,max = 20) //max 20

    private String confirmPassword;

}