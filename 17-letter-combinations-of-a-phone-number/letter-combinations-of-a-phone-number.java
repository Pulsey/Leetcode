class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() ==0 || digits == null) return res;
        String[] mappings = {"", "", "abc", "def","ghi","jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(digits, new StringBuilder(), 0, res, mappings);
        return res;
    }

    public void backtrack(String digits, StringBuilder path, int i, List<String> res, String[] mappings){
        if(i == digits.length()){
            res.add(path.toString());
            return;
        }
        String possibleChars = mappings[digits.charAt(i) - '0'];
        for( char ch :possibleChars.toCharArray()){
            path.append(ch);
            backtrack(digits, path, i+1, res, mappings);
            path.deleteCharAt(path.length() -1 );
        }
    }
}