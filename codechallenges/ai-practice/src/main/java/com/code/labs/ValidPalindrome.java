package com.code.labs;

public class ValidPalindrome {

    public static void main(String[] args) {
        String string = "moiom";
        System.out.println(string);
        System.out.println(isPalindrome3(string));
    }

    public static boolean isPalindrome(String s) {
        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        for (int i = 0; i < cleaned.length(); i++) {
            for (int j = cleaned.length() - 1; j >= 0; j--) {
                if (cleaned.charAt(i) != cleaned.charAt(j)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isPalindrome2(String s) {
        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        StringBuilder compare = new StringBuilder();
        for (int  i = cleaned.length()-1; i >= 0; i--) {
            compare.append(cleaned.charAt(i));
        }
        return cleaned.contentEquals(compare);
    }

    public static boolean isPalindrome3(String s) {
        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        for (int i = 0; i < cleaned.length(); i++) {
            char left = cleaned.charAt(i);
            char right = cleaned.charAt(cleaned.length() - 1 - i);
            if (left != right) {
                return false;
            }
        }
        return true;
    }

}
