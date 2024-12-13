package org.sid.customerservice1;

import org.sid.customerservice1.config.CustomerConfigParams;
import org.sid.customerservice1.entities.Customer;
import org.sid.customerservice1.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;
@EnableConfigurationProperties(CustomerConfigParams.class)
@SpringBootApplication
public class CustomerService1Application {

    public static void main(String[] args) {
        SpringApplication.run(CustomerService1Application.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(CustomerRepository customerRepository,
                                               RepositoryRestConfiguration restConfiguration){
        return args -> {
            restConfiguration.exposeIdsFor(Customer.class);
            customerRepository.saveAll(
                    List.of(
                            Customer.builder().name("simo").email("simo@gmail.com").build(),
                            Customer.builder().name("simo1").email("simo2@gmail.com").build(),
                            Customer.builder().name("simo2").email("simo3@gmail.com").build()

                    )
            );
            customerRepository.findAll().forEach(c ->{
                System.out.println(c);
            });
        };
    }
}
