package br.com.msantos.parking.config.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.msantos.parking.models.Colaborador;
import br.com.msantos.parking.repository.ColaboradorRepository;

@Service
public class AutenticationService implements UserDetailsService{

	@Autowired
	private ColaboradorRepository colaboradorRepository; 
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Colaborador> colaborador = colaboradorRepository.findByEmail(username);
		
		if (colaborador.isPresent()) {
			return colaborador.get();
		}
		
		throw new UsernameNotFoundException("Username or password is invalid");
	}

	
	
	
	
}
