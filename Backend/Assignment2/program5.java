import java.io.*;
import java.util.*;
import java.util.logging.Logger;
class IncalidAgeException extends Exception {
    public IncalidAgeException(String message) {
        super(message);
    }
}
public class program5 {
    private static final Logger logger = Logger.getLogger(program5.class.getName());

    public void validateAge(int age) throws IncalidAgeException {
        if(age < 18 || age > 60){
            throw new IncalidAgeException("Age " + age + " is not valid. Age must be between 18 and 60.");
        }
    }

    public String RemoveMultipleSpaces(String str) {
        return str.replaceAll(" +", "").trim();
    }
    public static void main(String args[]){
        String filepath = "D:\\CoDinG\\Innovatechs\\Bakckend\\Assignment2\\Program5input.txt";

        StringBuilder content= new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader(filepath))){
            String line;
            System.out.println("Contents of the file are:");
            while((line = br.readLine()) != null){
                System.out.println(line);
                content.append(line).append("\n");
            }
            System.out.println("Complete content of the file:");
            System.out.println(content.toString());
        
        } catch (FileNotFoundException e) {
            logger.severe("File not found: " + filepath);
        } catch (IOException e) {
            logger.severe("Error reading file: " + e.getMessage());
        }

        program5 obj = new program5();
        //cleaning multiple spaces
        String cleanedContent = obj.RemoveMultipleSpaces(content.toString());
        System.out.println("Content after removing multiple spaces:");
        System.out.println(cleanedContent);

        String[] records = cleanedContent.split("\\n");
        List<String> ValidRecords = new ArrayList<>();
        List<String> InvalidRecords = new ArrayList<>();

        Set<String> recordSet = new HashSet<>(Arrays.asList(records));
        records = recordSet.toArray(new String[0]);

        //Adding people with same id to invalid records and records length not equal to 3
        Map<String, Integer> idCountMap = new HashMap<>();
        for(String record : records){
            String[] fields = record.split(",");
            if(fields.length == 3){
                String id = fields[0].trim();
                idCountMap.put(id, idCountMap.getOrDefault(id, 0) + 1);
            }
            else{
                InvalidRecords.add(record);
                logger.severe("Invalid record format: " + record);
            }
        }
        for(String record : records){
            String[] fields = record.split(",");
            if(fields.length == 3){
                String id = fields[0].trim();
                if(idCountMap.get(id) > 1){
                    InvalidRecords.add(record);
                    logger.severe("Duplicate ID found: " + id + " in record: " + record);
                }
            }
        }
        System.out.println("Records after removing duplicates:");
        System.out.println(Arrays.toString(records));


        //Sorting the records based on ID
        Collections.sort(Arrays.asList(records), (a,b) -> {
            String idA = a.split(",")[0].trim();
            String idB = b.split(",")[0].trim();
            return idA.compareTo(idB);
        });

        System.out.println("##################################################################");

        for(String record : records){
            System.out.println("Record after removing duplicates: " + record);
        }
        
        System.out.println("##################################################################");

        

        for(String record : records){
            String[] fields = record.split(",");

            System.out.println("Processing record: " + record);
            for(String field : fields){
                System.out.println("Field: " + field);
            }
            if(fields.length != 3){
                InvalidRecords.add(record);
                logger.severe("Invalid record format: " + record);
                continue;
            }
            try{
                Integer.parseInt(fields[0].trim());
            } catch (NumberFormatException e) {
                InvalidRecords.add(record);
                logger.severe("Invalid ID format in record: " + record);
                continue;
            }
            try{
                int age = Integer.parseInt(fields[2].trim());
                obj.validateAge(age);
                if(!InvalidRecords.contains(record))ValidRecords.add(record);
            } catch (NumberFormatException e) {
                InvalidRecords.add(record);
                logger.severe("Invalid age format in record: " + record);
            } catch (IncalidAgeException e) {
                InvalidRecords.add(record);
                logger.severe(e.getMessage() + " in record: " + record);
            }
}
        for(String invalidrecord : InvalidRecords){
                System.out.println("Invalid Record: " + invalidrecord);
        }

        Iterator<String> validIterator = ValidRecords.iterator();
        while(validIterator.hasNext()){
            String validrecord = validIterator.next();
            System.out.println("Valid Record: " + validrecord);
        }

        String OutputfilepathValid = "D:\\CoDinG\\Innovatechs\\Bakckend\\Assignment2\\ValidRecords.txt";
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(OutputfilepathValid))){
            for(String validrecord : ValidRecords){
                bw.write(validrecord);
                bw.newLine();
            }
            System.out.println("Valid records written to file: " + OutputfilepathValid);
        } catch (IOException e) {
            logger.severe("Error writing valid records to file: " + e.getMessage());
        }

        String OutputfilepathInvalid = "D:\\CoDinG\\Innovatechs\\Bakckend\\Assignment2\\InvalidRecords.txt";
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(OutputfilepathInvalid))){
            for(String invalidrecord : InvalidRecords){
                bw.write(invalidrecord);
                bw.newLine();
            }
            System.out.println("Invalid records written to file: " + OutputfilepathInvalid);
        } catch (IOException e) {
            logger.severe("Error writing invalid records to file: " + e.getMessage());
        }
    }
}