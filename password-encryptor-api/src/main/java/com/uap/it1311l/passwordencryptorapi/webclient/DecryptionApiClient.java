package com.uap.it1311l.passwordencryptorapi.webclient;

import com.uap.it1311l.passwordencryptorapi.models.DecryptionResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface DecryptionApiClient 
{
    @GetExchange("/decryptstring?secretKey={secretKey}&encryptedText={encryptedText}&cryptAlgorithm={cryptAlgorithm}")
    public DecryptionResponse decrypt(@PathVariable String secretKey, @PathVariable String encryptedText, @PathVariable String cryptAlgorithm);
}
