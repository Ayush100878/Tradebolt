package com.example.tradebolt.controller;

import com.example.tradebolt.Modal.User;
import com.example.tradebolt.config.JwtProvider;
import com.example.tradebolt.repository.UserRepository;
import com.example.tradebolt.response.AuthResponse;
import com.example.tradebolt.service.CustomeUserDetailsService;
import com.example.tradebolt.service.WatchlistService;
import com.example.tradebolt.utils.OtpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@RestController //it is a REST controller and can handle http requests.cpmbines @controller and @ResponseBody and simplifies creation of RESTful apis
@RequestMapping("/auth")    // all endpoints in this controller will startwith endpoint /auth
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomeUserDetailsService customeUserDetailsService;

    @Autowired
    private WatchlistService watchlistService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> register (@RequestBody User user) throws Exception{      //to register new user in the system

        User isEmailExist = userRepository.findByEmail(user.getEmail());
        if(isEmailExist != null){
            throw new Exception("Email; is already hrown with another account");
        }
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setEmail(user.getEmail());
        newUser.setFullName(user.getFullName());
        User savedUser =userRepository.save(newUser);

        watchlistService.createWatchlist(savedUser);

        Authentication auth = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());
        SecurityContextHolder.getContext().setAuthentication(auth);

        String jwt = JwtProvider.generateToken(auth);

        AuthResponse res = new AuthResponse();
        res.setJwt(jwt);
        res.setStatus(true);
        res.setMessage("register success");
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> login (@RequestBody User user) throws Exception{      //to register new user in the system

        String userName = user.getEmail();
        String password = user.getPassword();


        Authentication auth = authenticate(userName, password);
        SecurityContextHolder.getContext().setAuthentication(auth);

        String jwt = JwtProvider.generateToken(auth);

        User authUser = userRepository.findByEmail(userName);


        AuthResponse res = new AuthResponse();
        res.setJwt(jwt);
        res.setStatus(true);
        res.setMessage("login success");
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    private Authentication authenticate(String userName, String password) { //check id user exists, if not then throw exception and if exists then verify password
        UserDetails userDetails = customeUserDetailsService.loadUserByUsername(userName);
        if(userDetails == null)
        {
            throw new BadCredentialsException("invalid username");
        }
        if (!password.equals(userDetails.getPassword())){
            throw new BadCredentialsException("invalid password");
        }

        return new UsernamePasswordAuthenticationToken(userDetails, password,userDetails.getAuthorities());

    }
}
