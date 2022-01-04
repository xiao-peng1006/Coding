class Solution {
    public int bitwiseComplement(int n) {
        if (n == 1) return 0;
        int l = (int)( Math.log(n) / Math.log(2) ) + 1;
        int mask = (1 << l) - 1;
        return n^mask;
    }
}