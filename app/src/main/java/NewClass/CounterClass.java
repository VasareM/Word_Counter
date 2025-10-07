package NewClass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CounterClass {
    public static int getCharsCount(String userInput) {
        return userInput.length();
    }
    public static int getNumbersCount(String userInput) {
        int numberCount=0;
        boolean startedNumber=false; // is the following digit the first one of a number
        for (int i=0; i<userInput.length(); i++) {
            char c = userInput.charAt(i);

            if(Character.isDigit(c)) {
                if(!startedNumber) {
                    numberCount++;
                    startedNumber=true;
                }
            }
            else {
                startedNumber=false;
            }
        }
        return numberCount;
    }
    public static int getWordsCount(String userInput) {
        int wordCount=0;
        Matcher matcher = Pattern.compile("\\b\\w+\\b").matcher(userInput);
        while(matcher.find()) wordCount++;
        /*
        String[] words=userInput.trim().split("[ ,.]");
        for (String word : words) {
            if (!word.trim().isEmpty()) {
                wordCount++;
            }
        }
         */
        return wordCount;
    }
    public static int getSentencesCount(String userInput) {
        //making sure that both "word.word.word" and "word.word.word." would be counted as three sentences, and "word" as one;
        int sentenceCount = 0;
        Matcher matcher = Pattern.compile("[^\\.]+(?:\\.|$)").matcher(userInput.trim());
        //  [^\\.]+     one or more characters that are not a period; (?:\\.|$)     followed by a period or the end of string
        while (matcher.find()) {
            String sentence = matcher.group().trim();
            if (!sentence.isEmpty()) sentenceCount++;
        }
        /*
        boolean hasTextAfterLastPeriod=false;
        int lastPeriodIndex=-1;

        for (int i=0; i<userInput.length(); i++) {
            char c = userInput.charAt(i);
            if (c == '.') {
                sentenceCount++;
                lastPeriodIndex=i;
            }
        }
        if (sentenceCount>0) {
            for (int i=lastPeriodIndex+1; i<userInput.length(); i++){
                if(!Character.isWhitespace(userInput.charAt(i))) {
                    hasTextAfterLastPeriod=true;
                    break;
                }
            }
            if(hasTextAfterLastPeriod) sentenceCount++;
        }
        else {
            if (sentenceCount == 0 && !userInput.trim().isEmpty()) return 1;
        }
         */
        return sentenceCount;
    }
}
// static: nereikia kurti klasės instance'ų; kai nererikia accessint objekto; mažiau kodo
