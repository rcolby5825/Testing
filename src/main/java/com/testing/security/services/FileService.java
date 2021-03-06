package com.testing.security.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {
    private static final BigInteger FNV_128_PRIME = new BigInteger("309485009821345068724781371");
    public String readFile(MultipartFile textFile) {
        long startTime = System.currentTimeMillis();
        BufferedReader br;
        List<String> result = new ArrayList<>();
        try {
            String line;
            InputStream is = textFile.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {

                BigInteger FNV_128_INIT = new BigInteger(line, 16);
                        String output = fnv(FNV_128_INIT, FNV_128_INIT.toByteArray());
                        result.add(output);
                    System.out.println(result);
            }
            long endTime = System.currentTimeMillis();
            System.out.println("To read file it took " + (endTime - startTime) + " milliseconds");
            return result.toString();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return "error";
    }

    private String fnv(BigInteger FNV_128_INIT, byte[] data) {
        BigInteger newHash = new BigInteger(data);
        for (byte b : data) {
            newHash.multiply(FNV_128_PRIME).mod(FNV_128_INIT);
            newHash.xor(BigInteger.valueOf((int) b & 0xff));
        }
        return newHash.toString(16);
    }

}
