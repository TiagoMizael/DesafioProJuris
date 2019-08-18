package br.com.projuris;


import br.com.projuris.interfaces.FindCharachter;

public class MyFindChar implements FindCharachter {
    @Override
    public String findChar(String word) {
        String result = "";

        try {
            char[] wordArray = word.toCharArray();
            char[] wordCompare = word.toCharArray();

            for (int i = 0; i < wordArray.length; i++) {
                int count = 0;
                for (int j = 0; j < wordCompare.length; j++) {
                    if (wordArray[i] == wordCompare[j]) {
                        count++;
                    }
                }
                if (count == 1) {
                    return result = String.valueOf(wordArray[i]);
                }
            }
            return result;
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
    }
}
