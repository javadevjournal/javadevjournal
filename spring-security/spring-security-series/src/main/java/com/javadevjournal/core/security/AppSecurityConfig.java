package com.javadevjournal.core.security;

import com.javadevjournal.core.security.authentication.CustomAuthenticationProvider;
import com.javadevjournal.core.security.filter.CustomAuthenticationFilter;
import com.javadevjournal.core.security.filter.CustomHeaderAuthFilter;
import com.javadevjournal.core.security.handlers.CustomAccessDeniedHandler;
import com.javadevjournal.core.security.handlers.CustomSuccessHandler;
import com.javadevjournal.core.security.handlers.LoginAuthenticationFailureHandler;
import com.javadevjournal.core.security.web.authentication.CustomWebAuthenticationDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.ldap.core.support.BaseLdapPathContextSource;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.authentication.DefaultAuthenticationEventPublisher;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.ldap.LdapAuthenticationProviderConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.ldap.authentication.BindAuthenticator;
import org.springframework.security.ldap.authentication.LdapAuthenticationProvider;
import org.springframework.security.ldap.authentication.LdapAuthenticator;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    UserDetailsService userDetailsService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private DataSource dataSource;

    @Resource
    CustomAuthenticationProvider customAuthenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login", "/register","/home")
                .permitAll()
                .antMatchers("/account/**").hasAnyAuthority("CUSTOMER", "ADMIN")
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler())
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
                .formLogin()
                .defaultSuccessUrl("/account/home")
                .loginPage("/login")
                .failureUrl("/login?error=true")
                .successHandler(successHandler())
                .failureHandler(failureHandler())
                //logout configurations
                .and()
                .logout().deleteCookies("dummyCookie")
                .logoutSuccessUrl("/login");

                /*
                .and()
                .sessionManagement()
                .sessionFixation().none(); */


               http.authorizeRequests().antMatchers("/admim/**").hasAuthority("ADMIN");
               http.addFilterAfter(customHeaderAuthFilter(), UsernamePasswordAuthenticationFilter.class);


    }

    @Bean
    public CustomHeaderAuthFilter customHeaderAuthFilter(){
        return new CustomHeaderAuthFilter();
    }


    private AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> authenticationDetailsSource() {

        return new AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails>() {
            @Override
            public CustomWebAuthenticationDetails buildDetails(
                    HttpServletRequest request) {
                return new CustomWebAuthenticationDetails(request);
            }

        };
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
    public AccessDeniedHandler accessDeniedHandler(){
        return new CustomAccessDeniedHandler();
    }

    @Bean
    public CustomAuthenticationFilter authFilter() throws Exception {
        CustomAuthenticationFilter filter = new CustomAuthenticationFilter();
        filter.setAuthenticationManager(authenticationManagerBean());
        filter.setAuthenticationFailureHandler(failureHandler());
        filter.setAuthenticationSuccessHandler(successHandler());
        return filter;
    }

    @Bean
    public LoginAuthenticationFailureHandler failureHandler(){
        LoginAuthenticationFailureHandler failureHandler = new LoginAuthenticationFailureHandler();
        failureHandler.setDefaultFailureUrl("/login?error=true");
        return failureHandler;
    }

    @Bean
    public AuthenticationEventPublisher authenticationEventPublisher
            (ApplicationEventPublisher applicationEventPublisher) {
        return new DefaultAuthenticationEventPublisher(applicationEventPublisher);
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
        //auth.authenticationProvider(authProvider());
        auth.authenticationProvider(customAuthenticationProvider)
                .authenticationProvider(authProvider());
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

    //Spring security LDAP configurations

    @Bean
    BindAuthenticator authenticator(BaseLdapPathContextSource contextSource) {
        BindAuthenticator authenticator = new BindAuthenticator(contextSource);
        authenticator.setUserDnPatterns(new String[] { "uid={0},ou=people" });
        return authenticator;
    }


    @Bean
    LdapAuthenticationProvider authenticationProvider(LdapAuthenticator authenticator) {
        return new LdapAuthenticationProvider(authenticator);
    }
}
