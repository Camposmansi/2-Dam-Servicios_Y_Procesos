package Trimestre2.URL;

import java.net.MalformedURLException;
import java.net.URL;

public class URLv2 {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://www.google.es");
        System.out.println("Protocol: " + url.getProtocol());
    }
}
