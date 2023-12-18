package bg.softuni.regular_exam.services.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FilesStorageServiceImplTest {

    private FilesStorageServiceImpl filesStorageService;
    private final Path root = Paths.get("src/main/resources/static/images/uploads/");


    @BeforeEach
    void Setup(){
        filesStorageService = new FilesStorageServiceImpl();
    }

    @Test
    void testInnit(){

        filesStorageService.init();

    }
    @Test
    void testSave(){
        Exception exception = assertThrows(Exception.class,()-> {filesStorageService.save(null);});
            assertEquals("Cannot invoke \"org.springframework.web.multipart.MultipartFile.getInputStream()\" because \"file\" is null",exception.getMessage());
    }

}