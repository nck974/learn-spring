package dev.nichoko.aop;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;

import dev.nichoko.aop.dao.AccountDAOimpl;
import dev.nichoko.aop.dao.MembershipDAOimpl;
import dev.nichoko.aop.entity.Account;

@SpringBootApplication
public class AopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAOimpl accountDAOimpl, MembershipDAOimpl membershipDAOimpl) {
		return runner -> {
			// demoBeforeAdvice(accountDAOimpl, membershipDAOimpl);
			// demoAfterReturnAdvice(accountDAOimpl);
			demoAfterThrowAdvice(accountDAOimpl);
		};
	}

	void demoBeforeAdvice(AccountDAOimpl accountDAOimpl, MembershipDAOimpl membershipDAOimpl) {

		Account account = new Account();
		account.setName("myName");
		account.setLevel("myLevel");

		accountDAOimpl.addAccount(account);
		accountDAOimpl.addOrder();
		membershipDAOimpl.addAccount();
		membershipDAOimpl.addOrder();
	}

	void demoAfterReturnAdvice(AccountDAOimpl accountDAOimpl) {

		Account account = new Account();
		account.setName("myName");
		account.setLevel("myLevel");

		accountDAOimpl.addAccount(account);
		accountDAOimpl.addOrder();
		List<Account> accounts = accountDAOimpl.findAccounts();

		System.out.println("Accounts found " + accounts);
	}

	void demoAfterThrowAdvice(AccountDAOimpl accountDAOimpl) {

		Account account = new Account();
		account.setName("myName");
		account.setLevel("myLevel");

		try {
			List<Account> accounts = accountDAOimpl.findAccounts();
			System.out.println("Accounts found " + accounts);
		} catch (RuntimeException exception) {
			System.out.println("RuntimeException catch...");
		}

	}

}
