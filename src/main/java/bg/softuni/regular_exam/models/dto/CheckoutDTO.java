package bg.softuni.regular_exam.models.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@NoArgsConstructor

public class CheckoutDTO {

    @NotBlank(message = "the name can not be empty")
    @Length(min =2, message = "Name should be more than 2 characters!")
    private String name;
    @NotBlank(message = "the address can not be empty")
    @Length(min =2, message = "Address should be more than 2 characters!")

    private String address;
//    @NotBlank
    @Length(min = 1,max = 13,message = "the phone number is not correct")
    private String number;

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
}
