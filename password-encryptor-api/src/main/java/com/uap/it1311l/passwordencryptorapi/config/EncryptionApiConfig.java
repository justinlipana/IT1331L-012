package com.uap.it1311l.passwordencryptorapi.config;

import com.uap.it1311l.passwordencryptorapi.webclient.EncryptionApiClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class EncryptionApiConfig 
{
    @Bean
    EncryptionApiClient encryptionApi() 
    {
        WebClient webClient = WebClient.builder()
                .baseUrl("https://encryption-api1.p.rapidapi.com/api/Cryptor")
                .defaultHeader("X-RapidAPI-Key", "df7f6591fcmshb2873bbfd657213p1e1ea9jsn17acabfd566d")
                .defaultHeader("X-RapidAPI-Host", "encryption-api1.p.rapidapi.com")
                .build();

        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(webClient))
                .build();
        return httpServiceProxyFactory.createClient(EncryptionApiClient.class);
    }
}
