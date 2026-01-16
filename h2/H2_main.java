package h2;

public class H2_main {

    // Cache für fibonacciCached
    private static long[] cache = new long[1000];

    public static void main(String[] args) {
        benchmark(40);
    }

    // Benchmark-Methode
    public static void benchmark(int n) {

        long start, end;

        // (a) rekursiv
        start = System.nanoTime();
        long r1 = fibonacci(n);
        end = System.nanoTime();
        System.out.println("Result fibonacci: " + r1);
        System.out.println("Elapsed nanoseconds (fibonacci): " + (end - start));

        // Cache zurücksetzen
        cache = new long[1000];

        // (b) rekursiv mit Cache
        start = System.nanoTime();
        long r2 = fibonacciCached(n);
        end = System.nanoTime();
        System.out.println("Result fibonacciCached: " + r2);
        System.out.println("Elapsed nanoseconds (fibonacciCached): " + (end - start));

        // (c) iterativ
        start = System.nanoTime();
        long r3 = fibonacciIterative(n);
        end = System.nanoTime();
        System.out.println("Result fibonacciIterative: " + r3);
        System.out.println("Elapsed nanoseconds (fibonacciIterative): " + (end - start));
    }

    // (a) Rekursive Fibonacci
    public static long fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // (b) Rekursive Fibonacci mit Cache
    public static long fibonacciCached(int n) {

        if (n == 1 || n == 2) {
            return 1;
        }

        if (cache[n] != 0) {
            return cache[n];
        }

        cache[n] = fibonacciCached(n - 1) + fibonacciCached(n - 2);
        return cache[n];
    }

    // (c) Iterative Fibonacci
    public static long fibonacciIterative(int n) {

        if (n == 1 || n == 2) {
            return 1;
        }

        long prev = 1;
        long curr = 1;

        for (int i = 3; i <= n; i++) {
            long next = prev + curr;
            prev = curr;
            curr = next;
        }

        return curr;
    }
}
