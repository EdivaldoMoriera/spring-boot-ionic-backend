package com.valdosm.cursomc.resource.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class Url {

    public static String decodeParam(String s){
        try{
        return URLDecoder.decode(s, "UFF-8");
        }
        catch(UnsupportedEncodingException e){
            return "";

        }
    }

    public static List<Integer>decoIntList(String s){
        String [] vet = s.split(",");
        List<Integer>list = new ArrayList<>();
        for(int i = 0; i<vet.length; i++){
           list.add( Integer.parseInt(vet[i]));

        }
        return list;
    }
    
}
