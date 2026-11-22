// https://leetcode.com/problems/check-if-all-as-appears-before-all-bs/description
package dsa_revision.newpractice;

class AllAComesBeforeB {
    public boolean checkString(String s) {
      int fi = s.indexOf('a');
      int li = s.lastIndexOf('a');

      // can we calculate the last and first index of the a , while running in loop right ?
      for(int i=0; i<s.length(); i++){
        char c = s.charAt(i);
        if(c=='b' && ((i>=fi && i<=li) || i<fi)){
         return false;
        }
      }
      return true; 
    }
}

// aaabbb
// a -0
// a - 2
// b- 3

// "ba"
// a-1
// a-1
// b-0
