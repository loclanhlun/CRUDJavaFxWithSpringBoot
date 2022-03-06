package com.huynhbaoloc;

import com.huynhbaoloc.entity.Account;
import com.huynhbaoloc.entity.ClassRoom;
import com.huynhbaoloc.entity.Student;
import com.huynhbaoloc.repo.AccountRepo;
import com.huynhbaoloc.repo.ClassRoomRepo;
import com.huynhbaoloc.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Autowired
    private ClassRoomRepo classRoomRepo;

    @Autowired
    private AccountRepo accountRepo;

    @Bean
    public CommandLineRunner getCommandLineRunner() {
        return args -> {
            classRoomRepo.save(new ClassRoom("C01", "Lớp 1", 1));
            classRoomRepo.save(new ClassRoom("C02", "Lớp 2", 1));
            classRoomRepo.save(new ClassRoom("C03", "Lớp 3", 1));
            accountRepo.save(new Account("loc","loc", Account.Role.Admin));
            accountRepo.save(new Account("dat","dat", Account.Role.Sale));
            accountRepo.save(new Account("kien","kien", Account.Role.Purchase));
        };
    }
}
