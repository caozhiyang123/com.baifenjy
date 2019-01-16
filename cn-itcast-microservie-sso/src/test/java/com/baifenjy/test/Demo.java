package com.baifenjy.test;

import org.apache.commons.codec.digest.DigestUtils;

public class Demo
{
    public static void main(String[] args)
    {
        System.out.println(DigestUtils.md5Hex("admin"));
    }
}
