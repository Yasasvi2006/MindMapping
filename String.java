class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); 
        while (t-- > 0) {
            String s = sc.nextLine();
            char[] c = s.toCharArray();
            int left = 0, right = c.length - 1;
            while (left < right) {
                char temp = c[left];
                c[left] = c[right];
                c[right] = temp;
                left++;
                right--;
            }
            System.out.println(new String(c));
        }
    }
}
class AnagramCheck {
    public boolean checkAnagrams(String a, String b) {
        boolean ans = false;
        if (a.length() != b.length()) return ans;
        char[] cha = a.toCharArray();
        char[] chb = b.toCharArray();
        Arrays.sort(cha);
        Arrays.sort(chb);
        return Arrays.equals(cha, chb);
    }
}
class ValidPalindrome {
    public boolean validPalindrome(String str, int n) {
        int l = 0, r = n - 1;
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) {
                return isPali(str, l + 1, r) || isPali(str, l, r - 1);
            }
            l++;
            r--;
        }
        return true;
    }
    private boolean isPali(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
class PangramCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String s = sc.nextLine();
            s = s.toLowerCase();
            int[] freq = new int[26];
            int flag = 1;
            for (char ch : s.toCharArray()) {
                if (Character.isLetter(ch)) {
                    freq[ch - 'a']++;
                }
            }
            for (int i = 0; i < 26; i++) {
                if (freq[i] == 0) {
                    flag = 0;
                    break;
                }
            }
            if (flag == 1) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
class WordsVowelsConsonants {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); 
        while (t-- > 0) {
            String s = sc.nextLine();
            int words = countWords(s);
            int vowels = countVowels(s);
            int consonants = countConsonants(s);
            System.out.println(words + " " + vowels + " " + consonants);
        }
    }
    public static int countWords(String s) {
        if (s == null || s.isEmpty()) return 0;
        String[] words = s.trim().split("\\s+");
        return words.length;
    }
    public static int countVowels(String s) {
        int count = 0;
        s = s.toLowerCase();
        for (char ch : s.toCharArray()) {
            if (isVowel(ch)) count++;
        }
        return count;
    }
    public static int countConsonants(String s) {
        int count = 0;
        s = s.toLowerCase();
        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch) && !isVowel(ch)) count++;
        }
        return count;
    }
    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}