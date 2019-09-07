import java.util.Scanner;

public class ScannerUtils{

public static final Scanner scanner=new Scanner(System.in);

public static Scanner getScanner(){
    return scanner;
}

public static String readString(){
    return scanner.next();
}
public static int readInt(){
 return scanner.nextInt();
}

}