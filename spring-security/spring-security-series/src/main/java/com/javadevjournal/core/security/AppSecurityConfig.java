package com.javadevjournal.core.security;

import com.javadevjournal.core.security.handlers.CustomSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import javax.annotation.Resource;
import javax.sql.DataSource;

@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    UserDetailsService userDetailsService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login", "/register","/home")
                .permitAll()
                .antMatchers("/account/**").hasAuthority("USER")
                .and()

                //Setting HTTPS for my account
                .requiresChannel().anyRequest().requiresSecure()
                .and()

                // Remember me configurations
                .rememberMe().tokenRepository(persistentTokenRepository())
                .rememberMeCookieDomain("domain")
                .rememberMeCookieName("custom-remember-me-cookie")
                .userDetailsService(this.userDetailsService)
                .tokenValiditySeconds(2000)
                .useSecureCookie(true)

                //Login configurations
                .and()
                .formLogin().defaultSuccessUrl("/account/home")
                .loginPage("/login")
                .failureUrl("/login?error=true")
                .successHandler(successHandler())
                //logout configurations
                .and()
                .logout().deleteCookies("dummyCookie")
                .logoutSuccessUrl("/login");

                /*
                .and()
                .sessionManagement()
                .sessionFixation().none(); */







    }

    /**
     * <p></p>Creating bean for the custom suucess handler. You can use the custom success handlers for
     * different use cases like</p>
     * <li> Redirect customer to different page page based on profile.</li>
     * <li>Running some additional logic on post authentication before redirecting user</li>
     * <p>Check the <code>successHandler()</code> in the <code>configure</code> section for configuration details.</p>
     * @return Customer success handler
     */
    @Bean
    public CustomSuccessHandler successHandler(){
        return new CustomSuccessHandler();
    }

    @Bean
    public SessionRegistry sessionRegistry() {
        SessionRegistry sessionRegistry = new SessionRegistryImpl();
        return sessionRegistry;
    }

    /**
     * We need this bean for the session management. Specially if we want to control the concurrent session-control support
     * with Spring security.
     * @return
     */
    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher(){
        return new HttpSessionEventPublisher();
    }



    @Override
    public void configure(WebSecurity web){
        web.ignoring()
                .antMatchers("/resources/**", "/static/**");
    }

    /**
     * DAO authentication provider. This authentication provider will authenticate the user with the help of
     * @UserdetailsService. This is based on the validating the user with the username and password.
     * @return
     */
    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        authenticationProvider.setUserDetailsService(userDetailsService);
        return authenticationProvider;
    }

    /**
     * Authentication manager which will be invoked by Spring security filter chain. This authentication
     * manager will delegate the work to the Authentication provider to
     * authenticate the user. Look out for the @DaoAuth provider in the above section to see
     * how it works with this.
     * @param auth
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth){
        auth.authenticationProvider(authProvider());
    }

    /**
     * Using this to persist the remember-me token in the database for more secure approach.
     * We are not usin gthe memory based remember-me cookie which is not very secure but saving the token in the
     * DB for better security and secure validation.
     * @return
     */
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
        db.setDataSource(dataSource);
        return db;
    }
}
