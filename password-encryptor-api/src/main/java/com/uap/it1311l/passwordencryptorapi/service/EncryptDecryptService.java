package com.uap.it1311l.passwordencryptorapi.service;

import com.uap.it1311l.passwordencryptorapi.models.DecryptionResponse;
import com.uap.it1311l.passwordencryptorapi.models.EncryptionResponse;
import com.uap.it1311l.passwordencryptorapi.repository.PasswordEncryptorMybatisRepository;
import com.uap.it1311l.passwordencryptorapi.webclient.DecryptionApiClient;
import com.uap.it1311l.passwordencryptorapi.webclient.EncryptionApiClient;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EncryptDecryptService 
{
    @Autowired
    EncryptionApiClient encryptionApiClient;
    
    @Autowired
    DecryptionApiClient decryptionApiClient;
    
    @Autowired
	PasswordEncryptorMybatisRepository mybatisRepo;
    
    public EncryptionResponse encrypt(String password)
    {
    	EncryptionResponse response = encryptionApiClient.encrypt("roiceOgalescoPogi", URLEncoder.encode(password, StandardCharsets.UTF_8), "AES");
		mybatisRepo.insert(response.getResult());
		return response;
    }
    
    public String decrypt(String encryptedText) 
    {
        if (mybatisRepo.exists(encryptedText) > 0) 
        {
            DecryptionResponse response = decryptionApiClient.decrypt("roiceOgalescoPogi", encryptedText, "AES");
            return response.getResult();
        } 
        else 
        {
            return "Encrypted Password does not exist.";
        }
    } 
}