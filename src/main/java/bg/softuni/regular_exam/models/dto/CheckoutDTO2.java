package bg.softuni.regular_exam.models.dto;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


//@FieldMatch(
//        first = "password",
//        second = "confirmPassword",
//        message = "Passwords should match."
//)

public class CheckoutDTO2 {

    public CheckoutDTO2() {
    }

    public CheckoutDTO2(String name, String address, String number) {
        this.name = name;
        this.address = address;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    //    @NotNull
    @NotBlank(message = "error")
//    @Email(message = "the email is invalid")
    private String name;
//        @NotNull
//    @Length(min = 3,max = 20,message = "Password length must be between 3 and 20 characters!") //max 20

    @jakarta.validation.constraints.NotBlank(message = "error")
    private String address;
//    @NotNull
    @Length(min = 10,max = 10,message = "error") //max 20
    private String number;

}