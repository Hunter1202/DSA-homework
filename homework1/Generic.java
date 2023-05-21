package dsa.com.homework1;

import dsa.com.homework1.Dictionary;

public class Generic {
    public static void main(String[] args){
        Dictionary<String, Integer> d = new Dictionary<String, Integer>("Study", 123);
        String string = d.getKey();
        String num = d.getKey();
        System.out.println(string + ": " + num);
    }
}
