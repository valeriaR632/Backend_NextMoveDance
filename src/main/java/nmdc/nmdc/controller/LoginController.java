package nmdc.nmdc.controller;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import nmdc.nmdc.config.JwtFilter;
import nmdc.nmdc.dto.Token;
import nmdc.nmdc.model.UsuarioRegistrado;
import nmdc.nmdc.service.UsuarioRegistradoService;

@RestController
@RequestMapping(path="api/ai/login")//http://localhost:8080/api/login/
public class LoginController {
	
	private final UsuarioRegistradoService service;
	@Autowired
	public LoginController(UsuarioRegistradoService service) {
		this.service=service;
	}//constructor
	
	@PostMapping
    public Token loginUserReg(@RequestBody UsuarioRegistrado usuarioRegistrado) throws ServletException {
        if (service.validateUserReg(usuarioRegistrado)) {
            // Aquí podrías generar un JWT en vez del correo
            return new Token( generateToken(usuarioRegistrado.getCorreo()));
        }
        throw new ServletException("Nombre o contraseña incorrecta");
    }//loginuser
	private String generateToken(String correo) {
		Calendar calendar=Calendar.getInstance();
		calendar.add(Calendar.HOUR,24);
		return Jwts.builder().setSubject(correo)
				.claim("role", "UsuarioRegistrado")
				.setIssuedAt(new Date())
				.setExpiration(calendar.getTime())
				.signWith(SignatureAlgorithm.HS256,JwtFilter.secret)
				.compact();
		
	}
}
