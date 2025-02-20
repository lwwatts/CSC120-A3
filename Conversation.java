
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

class Conversation implements Chatbot {

  // Attributes 
  ArrayList<String> transcript;
  static ArrayList<String> genericResponses;


  /**
   * Constructor 
   */
  public Conversation() {
    this.transcript = new ArrayList<>();
    this.transcript.add("Hi there! What's on your mind?");
    genericResponses = new ArrayList<>();
    genericResponses.add("Mhm.");
    genericResponses.add("Okay.");
    genericResponses.add("Tell me more.");
    genericResponses.add("What else?");
  }

  /**
   * Starts and runs the conversation with the user
   */
  public void chat() {
    Scanner in = new Scanner(System.in);
    System.out.println("How many rounds? ");
    int rounds = Integer.parseInt(in.nextLine());
    System.out.println(this.transcript.get(0));
    while(rounds > 0){
      String statement = in.nextLine();
      this.transcript.add(statement);
      String response = respond(statement);
      System.out.println(response);
      this.transcript.add(response);
      rounds -= 1;
    }
    System.out.println("See ya!");
    this.transcript.add("See ya!");
    in.close();
    System.out.println();
    this.printTranscript();
  }

  /**
   * Prints transcript of conversation
   */
  public void printTranscript() {
    System.out.println("TRANSCRIPT: ");
    for(int i = 0; i < this.transcript.size(); i++){
      System.out.println(this.transcript.get(i));
    }
  }

  /**
   * Gives appropriate response (mirrored or canned) to user input
   * @param inputString the users last line of input
   * @return mirrored or canned response to user input  
   */
  public String respond(String inputString) {
    boolean flag = false;
    if(inputString.contains("I ")){
      inputString = inputString.replaceAll("I ", "you ");
      flag = true;
      if(inputString.contains(" am ")){
        inputString = inputString.replaceAll(" am ", " are ");
      }
    }
    else if(inputString.contains(" you ")){
      inputString = inputString.replaceAll(" you ", " I ");
      flag = true;
      if(inputString.contains(" are ")){
        inputString = inputString.replaceAll(" are ", " am ");
      }
    }
    if(inputString.contains(" my ")){
      inputString = inputString.replaceAll(" my ", " your ");
      flag = true;
    }
    else if(inputString.contains(" your ")){
      inputString = inputString.replaceAll(" your ", " my ");
      flag = true;
    }
    if(inputString.contains(" yours ")){
      inputString = inputString.replaceAll(" yours ", " mine ");
      flag = true;
    }
    else if(inputString.contains( " mine ")){
      inputString = inputString.replaceAll(" mine ", " yours ");
      flag = true;
    }
    if(flag == false){
      Random rand = new Random();
      int idx = rand.nextInt(genericResponses.size());
      inputString = genericResponses.get(idx);
    }
    else{
      if(inputString.endsWith(".")){
        inputString = inputString.substring(0, inputString.length()-1);
      }
      if(inputString.endsWith("!")){
        inputString = inputString.substring(0, inputString.length()-1);
      }
      inputString += "?";
    }
    return inputString;
  }

  public static void main(String[] arguments) {
    Conversation myConversation = new Conversation();
    myConversation.chat();
  }
}
