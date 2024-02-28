package com.bharath.dating.controller;

import com.bharath.dating.entities.Interest;
import com.bharath.dating.entities.UserAccount;
import com.bharath.dating.repos.InterestRepository;
import com.bharath.dating.repos.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserAccountController {

    @Autowired
    UserAccountRepository userAccountRepository;
    @Autowired
    InterestRepository interestRepository;

    @PostMapping("/users/register-user")
    public UserAccount registerUser(@RequestBody UserAccount userAccount){
        return userAccountRepository.save(userAccount);
    }
    @PostMapping("/interests/update")
    public Interest updateInterest(@RequestBody Interest interest){
        UserAccount userAccount = userAccountRepository.findById(interest.getUserAccountId()).get();
        interest.setUserAccount(userAccount);
        return interestRepository.save(interest);
    }

    @GetMapping("/users/get/all")
    public List<UserAccount> getUsers(){
        return userAccountRepository.findAll();
    }

    @DeleteMapping("/users/delete/{interestId}")
    public void deleteInterest(@PathVariable("interestId") int id ){
        interestRepository.deleteById(id);
    }
    @GetMapping("/users/matches/{id}")
    public List<UserAccount> findMatches(@PathVariable("id") int id){
       UserAccount userAccount =  userAccountRepository.findById(id).get();
        return userAccountRepository.findMatches(userAccount.getAge(),userAccount.getCity(),
                userAccount.getCountry(), userAccount.getId());
    }
}
