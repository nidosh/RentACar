package com.tobeto.a.spring.intro.core.filters;

import com.tobeto.a.spring.intro.core.services.JwtService;
import com.tobeto.a.spring.intro.services.abstracts.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@AllArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserService userService;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException
    {
        //...jwt'yi oku
        //jwt doğrula
        //security'e giriş yaptıracağız
        //chani ilerleteceğiz

        String jwtHeader = request.getHeader("Authorization");

        if (jwtHeader != null && jwtHeader.startsWith("Bearer")){

            String jwt = jwtHeader.substring(7); //saf jwt'yi verir.
            String username = jwtService.extractUser(jwt);

            if (username != null){

                UserDetails user = userService.loadUserByUsername(username);
                if (jwtService.validateToken(jwt,user)){

                    //her şey başarılı..
                    //BOILERPLATE CODES
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user,null, user.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);

                }

            }
        }

        filterChain.doFilter(request,response);
    }
}
