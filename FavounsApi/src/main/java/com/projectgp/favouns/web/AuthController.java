package com.projectgp.favouns.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectgp.favouns.dto.AuthCredentialsRequest;
import com.projectgp.favouns.model.User;
import com.projectgp.favouns.utils.JwtUtil;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("api/auth")
public class AuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping("login")
	public ResponseEntity<?> login(@RequestBody AuthCredentialsRequest request){
		try {
            Authentication authenticate = authenticationManager
                .authenticate(
                    new UsernamePasswordAuthenticationToken(
                        request.getUsername(), request.getPassword()
                    )
                );

            User user = (User) authenticate.getPrincipal();
            user.setPassword(null);
            
          HttpHeaders responseHeaders = new HttpHeaders();
          responseHeaders.set("authorization", jwtUtil.generateToken(user));
          responseHeaders.set("Access-Control-Expose-Headers", "*, Authorization");
          
          return new ResponseEntity<User>(user, responseHeaders, HttpStatus.OK);

            
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
	}

}

//HttpHeaders responseHeaders = new HttpHeaders();
//responseHeaders.set("authorization", jwtUtil.generateToken(user));
//
//return new ResponseEntity<User>(user, responseHeaders, HttpStatus.OK);

//return ResponseEntity.ok()
//.headers(responseHeaders)
//.body(user);


