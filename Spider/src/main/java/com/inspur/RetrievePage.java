package com.inspur;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class RetrievePage {
    private static HttpClient httpClient = new HttpClient();
    public static boolean downloadPage(String path){

        PostMethod postMethod = new PostMethod(path);
        NameValuePair[] postData = new NameValuePair[]{
                new NameValuePair("name","ltl"),
                new NameValuePair("password","111")
        };
        postMethod.addParameters(postData);
        InputStream input = null;
        OutputStream output = null;
        try {
            int statusCode = httpClient.executeMethod(postMethod);
            if ((statusCode == HttpStatus.SC_MOVED_TEMPORARILY)||
                    (statusCode == HttpStatus.SC_MOVED_PERMANENTLY)||
                    (statusCode == HttpStatus.SC_TEMPORARY_REDIRECT)){
                //todo 读取新的URL
                Header header = postMethod.getResponseHeader("location");
                if (header != null){
                    String newUrl = header.getValue();
                    if (newUrl == null || newUrl.equals("")){
                        newUrl = "/";
                        PostMethod redirect = new PostMethod(newUrl);
                    }

                }

            }
            if (statusCode == HttpStatus.SC_OK){
                input = postMethod.getResponseBodyAsStream();
                String fileName = path.substring(path.lastIndexOf('/')+1);
                output = new FileOutputStream(fileName);
                int tempByte = -1;
                while ((tempByte = input.read())>0){
                    output.write(tempByte);
                }
            }
            if (input != null){
                input.close();
            }
            if (output != null){
                output.close();
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }
}
