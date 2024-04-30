class Problem1 extends ConsoleProgram {

  /**
   * A program that will create and validate a username and password for the user
   * @author: Erick M
   */

  public void run() {

    // Initializes variables
    String strUserName;
    String strPasscode;

    // Outputs header
    System.out.println("***** Student Account Registration *****");

    // Prompts user for username and password data
    strPasscode = createPassword(readLine("Enter your first name: "), readLine("Enter your last name: "),
        readLine("Enter your student number: "));
    strUserName = readLine("Enter a new username: ");

    // Outputs empty line for spacing
    System.out.println("");

    // Outputs the validation of the username and the password
    System.out.println("Valid username: " + validateUsername(strUserName));
    System.out.println("Your password is: " + strPasscode);

  }

  /**
   * A method that will determine if the username is valid
   * @param strUserName
   * @return blnResult
   */
  private boolean validateUsername(String strUserName) {

    // Initializes variables
    boolean blnResult = false;
    
    // Creates a conditional selective algorithm to see if the username is more than 7 characters
    if (strUserName.length() > 7) {

      // Creates a for loop for each letter in the username
      for (int i = 0; i <= strUserName.length() - 1; i++) {

        // Updates the letter
        char charCurrentCharacter = strUserName.charAt(i);

        // Creates a conditional selective algorithm to check if its a letter or digit
        if (Character.isDigit(charCurrentCharacter) || Character.isLetter(charCurrentCharacter)) {

          // Updates variable
          blnResult = true;
        } else {

          // Updates variable
          blnResult = false;
        }
      }

      // Creates a conditional selectvie algorithm to check if at leat one character is a digit
      if (Character.isDigit(strUserName.charAt(0)) == false && Character.isDigit(strUserName.charAt(1)) == false && Character.isDigit(strUserName.charAt(2)) == false && Character.isDigit(strUserName.charAt(3)) == false && Character.isDigit(strUserName.charAt(4)) == false && Character.isDigit(strUserName.charAt(5)) == false && Character.isDigit(strUserName.charAt(6)) == false){
        
        // Updates the variable
        blnResult = false;
      }
    } else {

      // Updates the variable
      blnResult = true;
    }

    // Returns the result
    return blnResult;
  }

  /**
   * A method to create a password for the user
   * @param strFirstName
   * @param strLastName
   * @param strStudentID
   * @return strPassword
   */
  private String createPassword(String strFirstName, String strLastName, String strStudentID) {

    // Initializes variables
    String strPassword = "";
    char charCurrentLetter;
    char charFirstInitial;
    char charDigit;

    // Creates a conditional selectvie algorithm to check if the last name is less than 4 characters
    if (strLastName.length() > 4) {

      // Creates a for loop for each character
      for (int i = 0; i <= 3; i++) {
        charCurrentLetter = strLastName.charAt(i);

        // Updates the variable
        strPassword = strPassword + Character.toLowerCase(charCurrentLetter);
      }

      // Updates the letter
      charFirstInitial = strFirstName.charAt(0);

      // Updates the variable
      strPassword = strPassword + Character.toUpperCase(charFirstInitial);

      // Creates a for loop for each number
      for (int i = 3; i <= strStudentID.length() - 4; i++) {

        // Updates the letter
        charDigit = strStudentID.charAt(i);

        // Updates the variable
        strPassword = strPassword + charDigit;
      }
    } else if (strLastName.length() < 4) {

      // Creates a for loop for each letter in the last name
      for (int i = 0; i <= strLastName.length() - 1; i++) {

        // Updates the letter
        charCurrentLetter = strLastName.charAt(i);

        // Updates the variable
        strPassword = strPassword + Character.toUpperCase(charCurrentLetter);
      }
      charFirstInitial = strFirstName.charAt(0);

      // Updates the variable
      strPassword = strPassword + Character.toUpperCase(charFirstInitial);

      // Creates a for loop for each number in the student id
      for (int i = 3; i <= strStudentID.length() - 4; i++) {

        // Updates the number
        charDigit = strStudentID.charAt(i);

        // Updates variable
        strPassword = strPassword + charDigit;
      }
    }

    // Returns the password
    return strPassword;
  }
}