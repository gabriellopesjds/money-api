package com.gabriellopesjds.moneyapi.user.domain.service;

import com.gabriellopesjds.moneyapi.user.domain.model.User;
import com.gabriellopesjds.moneyapi.user.persistence.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final MessageSource messageSource;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =  userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(
            messageSource.getMessage("MONEY-003", null, LocaleContextHolder.getLocale())));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getRoleList());
    }

}
