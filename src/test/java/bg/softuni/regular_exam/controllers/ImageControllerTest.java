package bg.softuni.regular_exam.controllers;


import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
//@SpringBootTest
//@AutoConfigureMockMvc
class ImageControllerTest {


//    @Autowired
//    private MockMvc mockMvc;
    @Test
    void image() {
    }

    @Test
    void img() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.post("/image")).andExpect(status().is3xxRedirection());
    }
    // @PostMapping("/image")
    //    public String img(@RequestParam("imageFile")MultipartFile imageFile){
    //        return "redirect:/";
    //    }

}