
import java.util.Scanner;

class Conversation implements Chatbot {

  // Attributes 
  String transcript;

  /**
   * Constructor 
   */
  Conversation() {
    transcript = "\nHi there! What's on your mind?";
  }

  /**
   * Starts and runs the conversation with the user
   */
  public void chat() {
    Scanner in = new Scanner(System.in);
    System.out.println("How many rounds? ");
    int rounds = in.nextInt();
    System.out.println(transcript);
    while(rounds > 0){
      String statement = in.nextLine();
      transcript += "\n" + statement;
      String response = respond(statement);
      System.out.println(response);
      transcript += "\n" + response;
      rounds -= 1;
    }
  }

  /**
   * Prints transcript of conversation
   */
  public void printTranscript() {
    System.out.println(transcript);
  }

  /**
   * Gives appropriate response (mirrored or canned) to user input
   * @param inputString the users last line of input
   * @return mirrored or canned response to user input  
   */
  public String respond(String inputString) {
    String returnString = "Mhm."; 
    return returnString; 
  }

  public static void main(String[] arguments) {

    Conversation myConversation = new Conversation();
    myConversation.chat();
    myConversation.printTranscript();

  }
}
