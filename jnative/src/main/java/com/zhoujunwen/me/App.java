package com.zhoujunwen.me;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            new PlainOioServer().serve(1888);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
