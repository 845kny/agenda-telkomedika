package com.Agenda.Agenda.Klinik.Telkomedika.Controller;

import com.Agenda.Agenda.Klinik.Telkomedika.model.AccountRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/account")
public class AccountController {
    URI uri = new URI("http://desktop-vld0s2c:8080/account");

    RestTemplate restTemplate = new RestTemplate();

    public AccountController() throws URISyntaxException {
        this.restTemplate = new RestTemplate();
    }
    @GetMapping
    public AccountRequest[] getAccountAll(){
        AccountRequest[] agendalist = restTemplate.getForObject(uri, AccountRequest[].class);
        return agendalist;
    }
    @GetMapping("{id}")
    public AccountRequest getAccountById(@PathVariable("id") Long id) throws URISyntaxException {
        AccountRequest account = restTemplate.getForObject(uri+"/"+id, AccountRequest.class);
        return account;
    }
    @PostMapping
    public AccountRequest addAgenda(@RequestBody AccountRequest account) throws URISyntaxException{
        AccountRequest newaccount =  restTemplate.postForObject(uri, account, AccountRequest.class);
        return newaccount;
    }
    @DeleteMapping("{id}")
    public void deteleAccount(@PathVariable Long id) throws URISyntaxException{
        restTemplate.delete(uri+"/"+id);
    }
}
