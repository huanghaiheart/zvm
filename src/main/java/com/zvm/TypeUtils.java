package com.zvm;

import com.zvm.basestruct.u1;

public class TypeUtils {
    /**
     * byte[]转int
     * byte的范围是-128至127，此处视为无符号，0-255
     * @param bytes
     * @return
     */
    static public Integer byteArr2Int(byte[] bytes) {
        Integer size = bytes.length;
        Integer res = 0xff & bytes[0];
        for (Integer i = 1; i < size; i++) {
            res = ((res << 8) + 0xff) & bytes[i];
        }
        return res;
    }

    static public long byteArr2Long(byte[] bytes) {
        Integer size = bytes.length;
        long res = 0xff & bytes[0];
        for (Integer i = 1; i < size; i++) {
            res = ((res << 8) + (2 << (8 * i) - 1)) & bytes[i];
        }
        return res;
    }

    /**
     * byte转int
     * byte的范围是-128至127，此处视为无符号，0-255
     * @param value
     * @return
     */
    static public Integer byte2Int(byte value) {
        Integer res = 0xff & value;
        return res;
    }

    static public float byteArr2Float(byte[] bytes) {
        float res = Float.intBitsToFloat(byteArr2Int(bytes));
        return res;
    }

    static public double byteArr2Double(byte[] bytes) {

        double res = Double.longBitsToDouble(byteArr2Long(bytes));
        return res;
    }

    static public int float2Int(float value) {
        return Float.floatToIntBits(value);
    }


    /**
     * byte[]转String
     *
     * @param bytes
     * @return
     */
    static public String byte2String(byte[] bytes) {
        Integer size = bytes.length;
        char[] res = new char[size];
        for (Integer i = 0; i < size; i++) {
            res[i] = (char) bytes[i];
        }
        return String.valueOf(res);
    }

    /**
     * u1[] to String
     *
     * @param bytes
     * @return
     */
    static public String u12String(u1[] bytes) {
        Integer size = bytes.length;
        char[] res = new char[size];
        for (Integer i = 0; i < size; i++) {
            res[i] = (char) bytes[i].u1[0];
        }
        return String.valueOf(res);
    }

    static public boolean compare(String s, String d){
        if(s == null && d == null){
            return true;
        }
        if(s == null || d == null){
            return false;
        }
        Integer len0 = s.length();
        Integer len1 = d.length();
        if(len0 != len1){
            return false;
        }

        char[] arr0 = s.toCharArray();
        char[] arr1 = d.toCharArray();
        for(int i = 0; i < len0; i++){
            if(arr0[i] != arr1[i]){
                return false;
            }
        }
        return true;
    }

    public static byte[] appendByte(byte[] high, byte[] low) {
        int len = high.length + low.length;
        byte[] res = new byte[len];
        int i = 0;
        for(int lowLen = low.length; i < lowLen; i++){
            res[i] = low[i];
        }
        for(int j = 0, highLen = high.length; j < highLen; j++){
            res[i ++] = high[j];
        }
        return res;
    }
}