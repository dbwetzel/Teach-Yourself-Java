// Chapter 1 No. 5
// This is the house that Jack built
import java.util.*;  
public class Jack {
  public static String[] noun = {"house that Jack built", "malt", "rat", "cat", "dog", "cow with the crumpled horn", "maiden all forlorn"};
  public static String[] verb = {"lay in", "ate", "killed", "worried", "tossed", "milked"};  
  
  public static void main(String[] args) {
    System.out.println("This is the house that Jack built.");
    System.out.println("(generative poetry edition)\n");
    System.out.println();
    for(int i = 0; i < noun.length; i++){
      verse(i);
    }
    while(continuing()){
      // prompt the user to continue. 
      // if 'yes' ask for a noun and verb
      // generate a new line using the "Jack" formula
      // if yes, return false and terminate this loop
    }
  }
  public static boolean continuing(){
      Scanner ui = new Scanner(System.in); 
      System.out.println("Continue with your own verse? (type the word 'yes')");
      String c = ui.next();
      ui.nextLine(); // throw away the carriage return
      if(c.matches("yes")){
        System.out.println("let's proceed!");
        System.out.println("Enter a noun:");  
        String n = ui.nextLine();
        // add n to the noun[] array
        int newVerse = noun.length; // number of the next verse
        noun = addToStringArray(noun, n);
        System.out.println("Enter a verb: (applies to the " + noun[noun.length-2] + ")");
        String v = ui.nextLine();
        // add v to the verb[] array
        verb = addToStringArray(verb, v);
        verse(newVerse);
        return true;
      } else {
        return false;        
      }
  }

  public static String[] addToStringArray(String[] arr, String s){
    int i = 0;
    String[] newArr = new String[arr.length + 1];
    for(i = 0; i < arr.length; i++){
      newArr[i] = arr[i]; // copy the old array to the new array
    }
    newArr[arr.length] = s; // add the new string to the last place in the new array
    
    return newArr;
  }

  public static void verse(int vnum){
    System.out.print("This is the ");
    System.out.print(noun[vnum]); //noun array member at [vnum]
    System.out.print("\n"); 
    refrain(vnum);
  }

  public static void refrain(int vnum){
    if(vnum > 0) {    
      for(int i = vnum-1; i >= 0; i--){
        System.out.print("That ");
        System.out.print(verb[i]); // verb array member at [i]
        System.out.print(" the ");
        System.out.print(noun[i]);
        System.out.print("\n");
      }
    }    
    System.out.println();
  }
}
