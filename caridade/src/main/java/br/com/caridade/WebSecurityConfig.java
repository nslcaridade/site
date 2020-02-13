package br.com.caridade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

import br.com.caridade.service.CustomAuthenticationEntryPoint;
import br.com.caridade.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	 http.cors().and().csrf().disable();
		 http.authorizeRequests().antMatchers("/registration",
				 							  "/registration/**",
				 							  "/",
				 							  "/Bazar/Todos",
				 							  "/Bazar/Todos/**",
				 							  "/Cadastro",
				 							  "/calendario/listar",
				 							  "/calendario/listar/**",
				 							  "/calendario/Lista",
				 							  "/calendario/calendario/**",
				 							  "/doacao/Periodo",
				 							  "/doacao/Periodo/**",
				 							  "/documento/diretriz",
				 							  "/documento/diretriz/**",
				 							  "/relatorio*",
				 							  "/Diretrizes_NSL.pdf",
				 							  "/Diretrizes_NSL.pdf**",
				 							  "/css/**",
				 							  "/dist/**",
				 							  "/fonts/**",
				 							  "/image/**",
				 							  "/js/**",
				 							  "/lib/**",
				 							  "/ListInstitution/Todas",
				 							  "/ListInstitution/Todas/**",
				 							  "/ListVideos/Todos",
				 							  "/ListVideos/Todos/**",
				 							  "/doacao/mensal/",
				 							  "/doacao/mensal/**",
				 							  "/doacao/anual/",
				 							  "/doacao/anual/**",
				 							  "/doacao/anualItens/",
				 							  "/doacao/anualItens/**",
				 							 "/doacao/listaEmprestimo/",
				 							  "/doacao/listaEmprestimo/**",
				 							  "/instituicao/listar",
				 							  "/Mensagem",
				 							  "/Mensagem/**",
				 							  "/missao",
				 							  "/missao/**",
				 							  "/User",
				 							  "/User/**",
				 							  "/User/Delete/**",
				 							  "/User/Localiza",
				 							  "/User/Localiza/**",
				 							  "/User/Atualiza",
				 							  "/User/Atualiza/**",
				 							  "/User/Delete",
				 							  "/usuario/listagtcontato").permitAll()
		  .anyRequest().authenticated() .and() .formLogin() .loginPage("/login")
		  .permitAll() .and() .logout() .permitAll();
		 
    }
    
	/*
	 * @Bean CorsConfigurationSource corsConfigurationSource() { CorsConfiguration
	 * configuration = new CorsConfiguration();
	 * configuration.setAllowedOrigins(Arrays.asList("*"));
	 * configuration.setAllowedMethods(Arrays.asList("*"));
	 * configuration.setAllowedHeaders(Arrays.asList("*"));
	 * configuration.setAllowCredentials(true); UrlBasedCorsConfigurationSource
	 * source = new UrlBasedCorsConfigurationSource();
	 * source.registerCorsConfiguration("/caridade/**", configuration); return
	 * source; }
	 */

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    	auth.userDetailsService(userDetailsService);
    }
    
        
    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint(){
        return new CustomAuthenticationEntryPoint();
    }
}