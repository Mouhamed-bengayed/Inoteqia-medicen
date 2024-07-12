package com.test.Inoteqia.Services;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class CryptDecrypt {


    @Value("${secret.key}")
    private String secretKey;


    // Méthode pour crypter les informations sensibles de l'utilisateur
    public String encryptSensitiveInformation(String data) throws Exception {
        if (data == null)
            return null;
        else {
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] encryptedData = cipher.doFinal(data.getBytes());
            return Base64.getEncoder().encodeToString(encryptedData);
        }
    }
    public List<String> encryptListeSensitiveInformation(List<String> dataList) throws Exception {
        if (dataList == null) {
            return null;
        } else {
            List<String> encryptedDataList = new ArrayList<>();
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

            for (String data : dataList) {
                if (data != null) {
                    byte[] encryptedData = cipher.doFinal(data.getBytes());
                    encryptedDataList.add(Base64.getEncoder().encodeToString(encryptedData));
                } else {
                    encryptedDataList.add(null); // If data is null, add null to the encrypted list
                }
            }

            return encryptedDataList;
        }
    }

    // Méthode pour décrypter les informations sensibles de l'utilisateur
    public String decryptSensitiveInformation(String encryptedData) throws Exception {
        if (encryptedData == null)
            return null;
        else {
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte[] decryptedData = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
            return new String(decryptedData);
        }
    }
}