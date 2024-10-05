package com.example.bookmistakes.util;

import org.mindrot.jbcrypt.BCrypt;

public class BcryptUtil {
    static final String key = "xuzhi0505";


    public static String encoding(String password){
        return BCrypt.hashpw(password,BCrypt.gensalt());
    }

//    public String Decoding(String password){
//        return
//    }
}
