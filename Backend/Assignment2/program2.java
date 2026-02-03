import java.util.*;

public class program2 {
    public static void main(String[] args) {
        String[] Array = {"Aarav", "Neha", "Rahul","Rahul", "Priya", "Karan", "Ananya", "Rohit", "Sneha", "Vikram",
 "Pooja", "Suresh", "Kavya", "Aarav", "Neha", "Rahul", "Priya", "Karan", "Ananya",
 "Rohit", "Sneha", "Vikram"};


        List<String> list = new ArrayList<>();
        System.out.println("======================================================================");
        System.out.println("Converting array to List using the standard loop");
        for(String num : Array){
            list.add(num);
        }
        System.out.println("======================================================================");
        System.out.println("Converting array to List using Arrays.stream().toList():");
        List<String> list2 = Arrays.stream(Array).toList();
        System.out.println("List2: " + list2);

        System.out.println("======================================================================");
        System.out.println("Converting array to List using Arrays.asList():");
        List<String> list3 = Arrays.asList(Array);
        System.out.println("List3: " + list3);

        System.out.println("======================================================================");
        System.out.println("Converting array to List using Collections.addAll():");
        List<String> list4 = new ArrayList<>();
        Collections.addAll(list4, Array); 
        System.out.println("List4: " + list4);  

        HashMap<String , Integer>  frequenHashMap = new HashMap<>();
        for(String num : list){
            frequenHashMap.put(num, frequenHashMap.getOrDefault(num, 0) + 1);
        }

        HashSet<String> uniqueNumbers = new HashSet<>();
        for(String num : list){
            uniqueNumbers.add(num);
        }
         System.out.println("======================================================================");
        System.out.println("Iterating using HashSet:");
        for(String uniqueNum : uniqueNumbers){
            int frequency = frequenHashMap.get(uniqueNum);
            System.out.println("Number: " + uniqueNum + ", Frequency: " + frequency);
        }
         System.out.println("======================================================================");
        System.out.println("Iterating using forEach and lambda:");
        frequenHashMap.forEach((key, value) -> {
            System.out.println("Number: " + key + ", Frequency: " + value);
        });
         System.out.println("======================================================================");
        System.out.println("Iterating using for loop: for the frequency sorted order");
        List<String> frequencySorted = new ArrayList<>(frequenHashMap.keySet());
        Collections.sort(frequencySorted, (a, b) -> frequenHashMap.get(b) - frequenHashMap.get(a) );
        for(int i=0; i<frequencySorted.size(); i++){
                System.out.print(frequencySorted.get(i) + " ");
        }
        System.out.println();
         System.out.println("======================================================================");
        System.out.println("Iterating using Map Entries: using the entrySet()");
        for(Map.Entry<String, Integer> entry : frequenHashMap.entrySet()){
            System.out.println("Number: " + entry.getKey() + ", Frequency: " + entry.getValue());

        }

        System.out.println("======================================================================");
        Iterator<String> iterator = uniqueNumbers.iterator();
        System.out.println("Iterating using Iterator:");
        while(iterator.hasNext()){  
            String uniqueNum = iterator.next();
            System.out.print( uniqueNum + " ");
        }

        System.out.println("======================================================================");
        
    }
}
