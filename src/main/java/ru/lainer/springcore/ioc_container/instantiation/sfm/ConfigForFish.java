package ru.lainer.springcore.ioc_container.instantiation.sfm;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ru.lainer.springcore.ioc_container.instantiation.sfm")
public class ConfigForFish {

  @Bean(name = "krasnoperka")
  public Fish krasnoperka() {
    //Instantiation с помощью "Static Factory Method"
    return Fish.add("Krasnoperka", "Karpovie");
  }

  @Bean(name = "plotva")
  public Fish plotva(){
    //Instantiation с помощью "Static Factory Method"
    return Fish.addAnotherOne("Plotva", "Karpovie");
  }
}
