package com.Agenda.Agenda.Klinik.Telkomedika.Controller;

import com.Agenda.Agenda.Klinik.Telkomedika.Jwt.JwtResponse;
import com.Agenda.Agenda.Klinik.Telkomedika.Jwt.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping(value = "/authenticate")
public class authController {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @GetMapping
    public ResponseEntity<?> createAuthenticationToken() throws Exception {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", "ADMIN");
        final String token = jwtTokenUtil.doGenerateToken(claims,"kuncoro");

        return ResponseEntity.ok(new JwtResponse(token));
    }
}
