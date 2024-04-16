package bg.softuni.regular_exam.models.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckoutDTOTest {

    private CheckoutDTO checkoutDTO;

    private final String name = "dummy name";
    private final String address = "dummy address";
    private final String number = "dummy number";

    @BeforeEach
    void setUp() {
        checkoutDTO = new CheckoutDTO();
        checkoutDTO = new CheckoutDTO(name, address, number);

    }

    @Test
    void getName() {
        assertEquals(name,checkoutDTO.getName());

    }

    @Test
    void setName() {
        checkoutDTO.setName(number);
        assertEquals(number,checkoutDTO.getName());

    }

    @Test
    void getAddress() {
        assertEquals(address,checkoutDTO.getAddress());

    }

    @Test
    void setAddress() {
        checkoutDTO.setAddress(number);
        assertEquals(number,checkoutDTO.getAddress());
    }

    @Test
    void getNumber() {
        assertEquals(number,checkoutDTO.getNumber());

    }

    @Test
    void setNumber() {
        checkoutDTO.setNumber(name);
        assertEquals(name,checkoutDTO.getNumber());

    }
}