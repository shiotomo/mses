package work.tomosse.mses.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import work.tomosse.mses.enums.Role;
import work.tomosse.mses.model.UserDetails;
import work.tomosse.mses.repository.AccountRepository;

@Service
@Transactional
public class UserService implements UserDetailsService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final var account = accountRepository.selectByName(username);
        if (account == null) {
            throw new UsernameNotFoundException("userName" + username + "was not found in the database");
        }
        final var grantList = new ArrayList<GrantedAuthority>();
        grantList.add(new SimpleGrantedAuthority(Role.ADMIN.getRole()));
        grantList.add(new SimpleGrantedAuthority(Role.USER.getRole()));
        final var userDetails = new UserDetails(username, account.getPassword(), grantList);
        return userDetails;
    }

}