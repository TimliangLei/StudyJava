package com.inspur;

import com.inspur.service.Server;
import com.inspur.utils.PropUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * Hello world!
 *
 */
@Slf4j
public class App 
{
    public static void main( String[] args ) {

        PropUtils.loadProperties();
        Server server = new Server();
        server.run();
    }
}
