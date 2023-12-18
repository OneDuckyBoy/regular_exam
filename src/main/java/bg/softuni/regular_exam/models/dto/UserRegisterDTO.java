package bg.softuni.regular_exam.models.dto;

import bg.softuni.regular_exam.models.validation.FieldMatch;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.*;


//@FieldMatch(
//        first = "password",
//        second = "confirmPassword",
//        message = "Passwords should match."
//)

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
    @NotBlank(message = "Email can not be empty")
    @Email(message = "the email is invalid")
    private String email;
//        @NotNull
    @Length(min = 2,max = 20,message = "Password length must be between 3 and 20 characters!") //max 20

    private String password;
//    @NotNull
    @Length(min = 2,max = 20,message = "Password length must be between 3 and 20 characters!") //max 20
    private String confirmPassword;

    private String username;

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    private boolean admin;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}