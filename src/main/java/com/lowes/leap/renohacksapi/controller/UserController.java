package com.lowes.leap.renohacksapi.controller;

import com.lowes.leap.renohacksapi.entity.Cart;
import com.lowes.leap.renohacksapi.entity.Customer;
import com.lowes.leap.renohacksapi.entity.Orders;
import com.lowes.leap.renohacksapi.entity.User;
import com.lowes.leap.renohacksapi.model.AuthenticationRequest;
import com.lowes.leap.renohacksapi.model.AuthenticationResponse;
import com.lowes.leap.renohacksapi.model.SignUpRequest;
import com.lowes.leap.renohacksapi.repository.UserRepository;
import com.lowes.leap.renohacksapi.service.CartService;
import com.lowes.leap.renohacksapi.service.CustomerService;
import com.lowes.leap.renohacksapi.service.OrdersService;
import com.lowes.leap.renohacksapi.service.UserService;
import com.lowes.leap.renohacksapi.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    CustomerService customerService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtTokenUtil;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    CartService cartService;

    @Autowired
    OrdersService ordersService;



    @GetMapping("/users")
    List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/login")
    public ResponseEntity<?> createLoginAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws  Exception{
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }catch (BadCredentialsException e){
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = userService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse((jwt)));
    }


    @PostMapping("/signup")
    public ResponseEntity<?> createSignUpAuthenticationToken(@RequestBody SignUpRequest signUpRequest) throws  Exception{
        User newAddedUser;
        Customer newAddedCustomer;
        Cart newCart;
        Orders newOrders;

        newCart = cartService.addNewCart();
        newOrders = ordersService.addNewOrders();

        Customer customer = Customer.builder()
                .customerName(signUpRequest.getCustomerName())
                .customerAddress(signUpRequest.getCustomerAddress())
                .customerEmail(signUpRequest.getCustomerEmail())
                .customerMobNo(signUpRequest.getCustomerMobNo())
                .cart(Cart.builder().cartId(newCart.getCartId()).build())
                .orders(Orders.builder().ordersId(newOrders.getOrdersId()).build())
                .build();

        newAddedCustomer = customerService.addNewCustomer(customer);
        User user = User.builder()
                .user_id(customer.getCustomerId())
                .userName(signUpRequest.getUserName())
                .password(this.bCryptPasswordEncoder.encode(signUpRequest.getPassword()))
                .customer_id(Customer.builder().customerId(newAddedCustomer.getCustomerId()).build())
                .build();

        newAddedUser = userService.addNewUser(user);

        final UserDetails userDetails = userService.loadUserByUsername(newAddedUser.getUserName());
        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse((jwt)));
    }
    @GetMapping("/customer/{jwtToken}")
    public Customer findCustomerByToken(@PathVariable String jwtToken){
        String userName = jwtTokenUtil.extractUsername(jwtToken);
        User user = userService.findByUserName(userName);
        Customer customer = user.getCustomer_id();
        return customer;
    }

    /*
        this endpoint is only for testing authentication
     */
    @GetMapping("/checkout")
    public String checkOut(){
        return "CHECK OUT DONE COMPLETELY";
    }
}
