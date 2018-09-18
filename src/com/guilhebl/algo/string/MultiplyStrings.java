package com.guilhebl.algo.string;

public class MultiplyStrings {

    //Driver program
    public static void main(String args[]) {
       MultiplyStrings m = new MultiplyStrings();
       System.out.println(m.multiply("123456789", "987654321"));
    }
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();

        int[] digits = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                int p1 = i + j, p2 = i + j + 1;

                int sum = mul + digits[p2];

                digits[p1] += sum / 10;
                digits[p2] = sum % 10;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int d : digits) {
            if (!(sb.length() == 0 && d == 0)) sb.append(d);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}