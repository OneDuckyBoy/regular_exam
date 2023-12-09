package bg.softuni.regular_exam.models.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CheckoutDTO {

    @NotBlank(message = "the name can not be empty")
    private String name;
    @NotBlank(message = "the address can not be empty")
    private String address;
//    @NotBlank
    @Length(min = 1,max = 10,message = "the phone number is not correct")
    private String number;
}
