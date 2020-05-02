package com.boggle;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println(fibRecurse(6));
    }

    /**
     * for 0, throw. for 1, 1. for 2, 1; for 3,
     * @param n
     * @return
     */
    public static int fib(int n) {
        if (n == 0) {
            throw new RuntimeException("there is no 0th number");
        }
        int fib1 = 0;
        int fib2 = 1;
        if (n == 1) {
            return fib1;
        } else if (n == 2) {
            return fib2;
        }
        for (int i = 2; i < n; ++i) {
            int next = fib1 + fib2;
            fib1 = fib2;
            fib2 = next;
        }
        return fib2;
    }


    public static int fibRecurse(int n) {
        if (n == 0) {
            throw new RuntimeException("there is no 0th number");
        }
        return fibRecursHelper(n, 0, 0, 0);
    }

    public static int fibRecursHelper(int n, int current, int prev1, int prev2) {
        int currentFib = prev1 + prev2;;
        if (current == 1) {
            currentFib = 0;
        } else if (current == 2) {
            currentFib = 1;
        }
        if (n == current) {
            return currentFib;
        } else {
            return fibRecursHelper(n, current + 1, prev2, currentFib);
        }
    }
}
