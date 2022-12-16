import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static final String SHERLOCK = "sherlock";
    public static final String HARRY = "harry";
    public static final String HOMLER = "homler";
    public static final String SHELDON = "sheldon";
    public static final String BOB = "bob";
    public static final String FRED = "fred";

    public static void main(String[] args) {
        
        String usage = """
            Usage: Enter the format below: 
            ============
            <program> <CSV file> <template file> """;
    
            if ((args.length) != 2) {
                System.out.println("Incorrect Inputs. Please check the following usage.");
                System.out.println(usage);
                return;
            }
            
            String csvName = args[0];
            String templateName = args[1];
            if (csvName.equalsIgnoreCase("thankyou.csv") && templateName.equalsIgnoreCase("thankyou.txt")) {
                //once arguement match index[0] start method
                startShell();
            } else {
                System.out.println("Incorrect Arguements !!!");
            }
    }

    //Start up method
    public static void startShell() {
        System.out.println("Please enter start >> ");
        Scanner sc =  new Scanner(System.in);
        String line;
        boolean stop = false;

        while (!stop) {
            line = sc.nextLine();
            line = line.trim();
            if (line.equalsIgnoreCase("exit")) {
                System.out.println("Exiting !!!");
                stop = true;
            }
            if (line.equalsIgnoreCase("start")) {
                FormatCSV();
                System.out.println("Please enter the name >> ");
            } 
        }
    }


    //Process CSV method
    public static void FormatCSV() {
        
    try {
    String path = "task01/thankyou.csv";
    Map<String, List<String>> wordMap = new HashMap<String, List<String>>();
    BufferedReader br = new BufferedReader(new FileReader(path));
    List<String> firstNameList = new ArrayList<>();
    List<String> lastNameList = new ArrayList<>();
    List<String> addressList = new ArrayList<>();
    List<String> yearsList = new ArrayList<>();

    String linex = br.readLine();
    for (Integer i = 1; i <= 1; i++) {
        String line = br.readLine();
        if (null == line)
            break;
        String[] index = line.split(",");
        firstNameList.add(index[0]);
        lastNameList.add(index[1]);
        addressList.add(index[2]);
        yearsList.add(index[3]);
        wordMap.put("first_name", firstNameList);
        wordMap.put("last_name", lastNameList);
        wordMap.put("address", addressList);
        wordMap.put("years", yearsList);
 
    }
    br.close();

    //Print to .txt file
    try (FileOutputStream fos = new FileOutputStream("task01/thankyou.txt")) {
        OutputStreamWriter osw = new OutputStreamWriter(fos);

            String line1 = String.format("%s\n\n", wordMap.get("address").toString().replaceAll("[\\[\\],]","").replaceAll("\\n", ""));
            String line2 = String.format("Dear %s,\n\n", wordMap.get("first_name").toString().replaceAll("[\\[\\],]",""));
            String line3 = String.format("Thank you for staying with us over these %s years.\n\n", wordMap.get("years").toString().replaceAll("[\\[\\],]",""));
            osw.write(line1);
            osw.write(line2);
            osw.write(line3);


        osw.flush();
        osw.close();
        fos.close();
    } catch (IOException e) {
        e.printStackTrace();
    }

     } catch (FileNotFoundException e) {
        e.printStackTrace();
     } catch (IOException e) {
        e.printStackTrace();
     }     
     
    }

    //Process input(Names) to run method
    public static void ProcessInput(String input) {
        Scanner sc  = new Scanner(input);
        String command = sc.next().trim();

        switch (command) {
            case SHERLOCK:
            
                break;
    
            case HARRY:
                break;
    
            case HOMLER:
                break;
    
            case SHELDON:
                break;
    
            case BOB:
            break;
    
            case FRED:
            break;
    
            default:
                break;
        }
    
        sc.close();
    }

}
    
