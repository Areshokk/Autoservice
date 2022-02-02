//package com.areshok.Autoservice.security;
//
//import com.areshok.Autoservice.model.Customer;
//import com.areshok.Autoservice.repository.CustomerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
//
//    @Autowired
//    private CustomerRepository customerRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Customer customer = customerRepository.getCustomerByUsername(username);
//
//        if (customer == null) {
//            throw  new UsernameNotFoundException("Could not find customer");
//        }
//
//        return new MyCustomerDetails(customer);
//    }
//}
