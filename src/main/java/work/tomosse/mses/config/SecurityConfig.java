package work.tomosse.mses.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import work.tomosse.mses.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

//    private static String ROLE_ADMIN = "ROLE_" + Role.ADMIN.getRole();
//    private static String ROLE_User = "ROLE_" + Role.USER.getRole();

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(final WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                "/images/**",
                "/css/**",
                "javascript/**",
                "/v2/api-docs",
                "/configuration/ui",
                "/swagger-resources/**",
                "/configuration/security",
                "/swagger-ui.html",
                "/webjars/**"
                );
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
            .csrf().ignoringAntMatchers("/api/**")
        .and()
            .authorizeRequests()
            .antMatchers("/", "/api/v1/**").permitAll()
            .anyRequest().authenticated()
        .and()
            .formLogin()
            .loginPage("/")
            .loginProcessingUrl("/sign_in")
            .successForwardUrl("/dashboard")
            .usernameParameter("username")
            .passwordParameter("password")
            .failureUrl("/?error")
            .permitAll()
        .and()
            .logout()
            .logoutUrl("/logout")
            .logoutSuccessUrl("/")
            .permitAll();
    }

    @Override
    public void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

}