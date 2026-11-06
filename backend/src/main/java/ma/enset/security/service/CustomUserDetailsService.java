package ma.enset.security.service;

import ma.enset.security.entity.AppUser;
import ma.enset.security.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser  user = userRepository.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("User Not Found"));

        return User.builder().
                username(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();

    }
}
