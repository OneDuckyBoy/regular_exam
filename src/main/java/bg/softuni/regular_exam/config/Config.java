package bg.softuni.regular_exam.config;

import bg.softuni.regular_exam.repositories.ItemRepository;
import bg.softuni.regular_exam.services.impl.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling

public class Config {
    final
    ModelMapperConfig modelMapperConfig;
    final
    SecurityConfiguration securityConfiguration;
    final
    WebConfiguration webConfiguration;

    public Config(ModelMapperConfig modelMapperConfig, SecurityConfiguration securityConfiguration, WebConfiguration webConfiguration) {
        this.modelMapperConfig = modelMapperConfig;
        this.securityConfiguration = securityConfiguration;
        this.webConfiguration = webConfiguration;
    }


    //@Bean
    public ItemServiceImpl itemServiceImpl(ItemRepository itemRepository) {
        return new ItemServiceImpl(itemRepository);
    }

}
