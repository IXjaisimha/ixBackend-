import java.util.*;
import java.io.*;
class program1 {
    public String RemovemultipleSpaces(String str) {
        return str.replaceAll("\\s+", " ").trim();
    }

    public void display(String paragraph){
        int wordcount = 1;
        int sentencecount = 0;
        int charactercount = 0;

        for(int i=0; i<paragraph.length(); i++){
            char ch = paragraph.charAt(i);
            if(!Character.isWhitespace(ch)){
                charactercount++;
            }
            if(ch == ' '){
                wordcount++;
            }
            if(ch == '.' || ch == '!' || ch == '?' || ch == ';'){
                sentencecount++;
            }
        }
        System.out.println("Word count: " + wordcount);
        System.out.println("Sentence count: " + sentencecount);
        System.out.println("Character count: " + charactercount);
    }

    public void findMostFrequentWord(String paragraph){
        String[] words = paragraph.split(" ");
        Map<String, Integer> wordCountMap = new HashMap<>();

        for(String word : words){
            word = word.toLowerCase();
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }


        List<String> mostFrequentWords = new ArrayList<>(wordCountMap.keySet());

        Collections.sort(mostFrequentWords, (a, b) -> wordCountMap.get(b) - wordCountMap.get(a) );

        System.out.println("Top 5 most frequent words are:");
        for(int i=0; i<5; i++){
            String word = mostFrequentWords.get(i);
            int wordCount = wordCountMap.get(word);
            System.out.println(word + ": " + wordCount);
        }

        
    }

    public void reverseSentences(String paragraph){
        String[] sentences = paragraph.split("(?<=[.!?;])\\s*");
        List<String> reversedSentences = new ArrayList<>();
        for(String sentence : sentences){
            String[] words = sentence.split(" " );
            
            List<String> reversewords = new ArrayList<>(words.length);
            for(String word : words){
                StringBuilder sb = new StringBuilder(word);
                reversewords.add(sb.reverse().toString());
            }
            reversedSentences.add(String.join(" ", reversewords));

        }
        System.out.println("Reversed Sentences Paragraph:");
        System.out.println(String.join(" ", reversedSentences));
    }


    public static void main(String[] args) {
        System.out.println("======================================================================");
        System.out.println("\n\nReading the SampleText.txt file using IO:");

        String filePath = "D:\\CoDinG\\Innovatechs\\Bakckend\\Assignment2\\SampleText2.txt";

        StringBuilder content = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            int n = 8; // Line number to start reading from
            int i=0;
            while((line = br.readLine()) != null) {
                if(i >= n-1 && i < n+5) {
                System.out.println(line);
                content.append(line).append("\n");
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        program1 obj = new program1();
        System.out.println("======================================================================");
        System.out.println("\nComplete File Content:");
        System.out.println(content.toString());
        
        System.out.println("======================================================================");
        System.out.println("\nContent after removing multiple spaces:");   
        String result = obj.RemovemultipleSpaces(content.toString()); 
        System.out.println(result);
        
        System.out.println("======================================================================");
        System.out.println("\nDisplaying counts: Word count, Sentence count, Character count");
        obj.display(result);
        System.out.println("======================================================================");
        System.out.println("\n Find most frequently occurring word in the file:");
        obj.findMostFrequentWord(result);   
        System.out.println("======================================================================");
        System.out.println("Reverse the sentences of the file without the word order:");
        obj.reverseSentences(result);

        System.out.println("======================================================================");
        System.out.println("Demostarting the differnece between the equals and == operator:");
        String str1 = new String("hello");  
        String str2 = new String("hello");
        String str3 = "hello";
        String str4 = "hello";
        System.out.println("Using == operator: " + (str1 == str2)); // false
        System.out.println("Using equals() method: " + str1.equals(str2)); // true
        System.out.println("Using == operator for str1 and str3: " + (str1 == str3)); // true
        System.out.println("Using == operator for str3 and str4: " + (str3 == str4)); // true

        System.out.println("Explanation:");
        System.out.println("The '==' operator checks for reference equality, meaning it checks whether both references point to the same object in memory.");
        System.out.println("The 'equals()' method checks for value equality, meaning it checks whether the values of the objects are the same.");
        
    }
}