package org.eduami;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.security.Security;

public class ReadWebPage {
    public static void main(String[] args) {
        //Enable debugging to see the TLS handshake process
        System.setProperty("javax.net.debug", "all"); //Unfortunately, this does not work with BouncyCastle

        //Add BouncyCastle as a Security Provider
        Security.insertProviderAt(new org.bouncycastle.jce.provider.BouncyCastleProvider(), 1);
        Security.insertProviderAt(new org.bouncycastle.jsse.provider.BouncyCastleJsseProvider(), 2);

        try {
            //Read the content of the web page from the URL
            // BouncyCastle is used to establish a TLS connection with the web server
            URL url = new URL("https://www.google.com");
            URLConnection urlConnection = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}