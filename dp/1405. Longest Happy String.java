class Solution {
    public String longestDiverseString(int a, int b, int c) {
        String res = "";
        char prev = '0';
        while (a > 0 || b > 0 || c > 0) {
            if (a >= b && a >= c) {
                if (prev == 'a') {
                    if (b > c) {
                        res += 'b';
                        b -= 1;
                        prev = 'b';
                    } else {
                        res += 'c';
                        c -= 1;
                        prev = 'c';
                    }
                } else {
                    if (a <= 1) {
                        res += 'a';
                        a -= 1;
                        prev = 'a';
                    }
                    else {
                        res += "aa";
                        a -= 2;
                        prev = 'a';
                    }
                }         
            } else if (b >= a && b >= c) {
                if (prev == 'b') {
                    if (a > c) {
                        res += 'a';
                        a -= 1;
                        prev = 'a';
                    } else {
                        res += 'c';
                        c -= 1;
                        prev = 'c';
                    }
                } else {
                    if (b <= 1) {
                        res += "b";
                        b -= 1;
                        prev = 'b';
                    } else {
                        res += "bb";
                        b -= 2;
                        prev = 'b';
                    }
                }
            } else {
                if (prev == 'c') {
                    if (b > a) {
                        res += "b";
                        b -= 1;
                        prev = 'b';
                    } else {
                        res += "a";
                        a -= 1;
                        prev = 'a';
                    }
                } else {
                    if (c <= 1) {
                        res += "c";
                        c -= 1;
                        prev = 'c';
                    }
                    else {
                        res += "cc";
                        c -= 2;
                        prev = 'c';
                    }
                }
            }
            if (prev == 'a' && b <= 0 && c <= 0)
                break;
            if (prev == 'b' && a <= 0 && c <= 0)
                break;
            if (prev == 'c' && a <= 0 && b <= 0)
                break;
        }
        return res;
    }
}
