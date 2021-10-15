package com.ferdev.belajar.spring.baru.config;

import com.ferdev.belajar.spring.baru.repository.AccountRepository;
import com.ferdev.belajar.spring.baru.repository.impl.AccountRepositoryImpl;
import com.ferdev.belajar.spring.baru.service.AccountService;
import com.ferdev.belajar.spring.baru.service.impl.AccounServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // kelas yang akan dijadikan sebagai configuration.
               // harus menambahkan anotation @Configuration
public class ApplicationConfig {

    @Bean // dependency yang dibutuhkan harus dibuatkan method public dan ditambahkan @Bean
    public AccountRepository accountRepository(){
        return new AccountRepositoryImpl();
    }

    @Bean // jika dependency membutuhkan dependency lain, tambahkan diconstructor
          // dan bisa diterapkan melalui method setter didependency, yang bersangkutan
    public AccountService accountService(AccountRepository repository){
        AccounServiceImpl accounService = new AccounServiceImpl();
        accounService.setAccountRepository(repository);
        return accounService;
    }
}
