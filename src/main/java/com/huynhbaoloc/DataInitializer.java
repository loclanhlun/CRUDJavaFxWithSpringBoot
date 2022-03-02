package com.huynhbaoloc;

import com.huynhbaoloc.entity.Account;
import com.huynhbaoloc.entity.Student;
import com.huynhbaoloc.repo.AccountRepo;
import com.huynhbaoloc.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private AccountRepo accountRepo;

    @Bean
    public CommandLineRunner getCommandLineRunner() {
        return args -> {
            studentRepo.save(new Student("Lộc"));
            studentRepo.save(new Student("Đạt"));
            studentRepo.save(new Student("Kiên"));
            accountRepo.save(new Account("loc","loc", Account.Role.Admin));
            accountRepo.save(new Account("dat","dat", Account.Role.Sale));
            accountRepo.save(new Account("kien","kien", Account.Role.Purchase));
        };
    }
}
