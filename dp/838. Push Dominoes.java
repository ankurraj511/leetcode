class Solution {
    public String pushDominoes(String dominoes) {
        char[] arr = dominoes.toCharArray();
        int n = arr.length , st = 0 , end = 0;
        while (end < n) {
            while (end < n && arr[end] == '.') 
                end += 1;
            if (end == n)
                break;
            if (arr[end] == 'L') {
                if (arr[st] == 'R') {
                    int temp = end;
                    while (st < temp) {
                        arr[st++] = 'R';
                        arr[temp--] = 'L';
                    }
                } else {
                    while (st < end) 
                        arr[st++] = 'L';
                }
                
            } else {
                if (arr[st] == 'R') {
                    while (st < end)
                        arr[st++] = 'R';
                }
                
            }
            st = end;
            end += 1;
        }
        if (st < n && arr[st] == 'R') {
            while (st < n) 
                arr[st++] = 'R';
        }
        return String.valueOf(arr);
    }
}
