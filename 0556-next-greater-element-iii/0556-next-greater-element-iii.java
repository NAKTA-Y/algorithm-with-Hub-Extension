class Solution {
    public int nextGreaterElement(int n) {
        int len = String.valueOf(n).length();
        int[] nArray = new int[len];
        int swap = -1;
        int copy = n;

        for (int i = len-1; i >= 0; i--) {
            nArray[i] = copy % 10;
            copy /= 10;
        }

        int index = len-2;
        for (int i = len-2; i >= 0; i--) {
            if (nArray[i+1] > nArray[i]) {
                int minIndex = i+1;
                int diff = Integer.MAX_VALUE;

                for (int j = i+1; j < len; j++) { 
                    if (nArray[j] > nArray[i] && diff > nArray[j] - nArray[i]) {
                        diff = nArray[j] - nArray[i];
                        minIndex = j;
                    }
                }

                int temp = nArray[i];
                nArray[i] = nArray[minIndex];
                nArray[minIndex] = temp;

                index = i;
                break;
            }
        }

        Arrays.sort(nArray, index+1, len);

        StringBuilder sb = new StringBuilder();
        for (int number : nArray) {
            sb.append(number);
        }

        try {
            int result = Integer.parseInt(sb.toString());
            if (result == n) return -1;
            else return result;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}