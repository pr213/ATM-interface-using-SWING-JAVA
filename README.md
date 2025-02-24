# ATM GUI System

This is a simple ATM GUI system built using Java Swing that allows users to perform basic banking operations such as checking balance, withdrawing money, and depositing money. The application also includes a PIN verification feature to ensure secure access to the ATM functionalities.

## Features

- **PIN Authentication:** The user is required to enter a PIN to access the ATM interface. If the correct PIN is entered, the user can proceed to interact with the ATM. Otherwise, the application will terminate.
- **Check Balance:** The current account balance is displayed, and users can check their balance at any time.
- **Withdraw Funds:** Users can withdraw a specified amount, provided there are sufficient funds in the account.
- **Deposit Funds:** Users can deposit a specified amount to their account.
- **User-friendly Interface:** The ATM interface is simple, clean, and intuitive with a few buttons for interaction.

## Requirements

- Java Development Kit (JDK) 8 or higher
- A Java IDE or text editor to run the Java code (e.g., IntelliJ IDEA, Eclipse, or VS Code)

## Setup and Installation

### Prerequisites

1. **Install Java:**
   - Ensure that Java is installed on your machine. You can download and install the latest version from the [official Java website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).

2. **Set up your Java development environment:**
   - If you don't have an IDE, you can use a simple text editor and the terminal/command line to compile and run the project.

### Steps to Run the Project:

1. **Clone the repository** or download the `.java` file:
   - Clone or download the project folder to your local machine.

2. **Compile the code:**
   - Open your terminal or IDE and navigate to the directory where the `ATMGUI.java` file is located.
   - To compile the Java file, run the following command:

     ```bash
     javac ATMGUI.java
     ```

3. **Run the application:**
   - Once compiled, you can run the application using the following command:

     ```bash
     java ATMGUI
     ```

4. **Interact with the ATM:**
   - When you run the application, it will ask for a PIN. The default PIN is `1234`. If the PIN is correct, the ATM interface will be displayed.
   - You can now perform actions like withdrawing money, depositing funds, and checking your balance.

## How It Works

1. **PIN Authentication:** 
   - On startup, the user is prompted to enter their PIN. If the entered PIN is correct (currently set as `1234`), they will be granted access to the ATM interface. If incorrect, an error message is shown, and the program terminates.
   
2. **Main Menu:**
   - Once the PIN is authenticated, the user can choose from the following options:
     - **Withdraw:** Withdraw a specific amount of money.
     - **Deposit:** Deposit a specific amount of money.
     - **Check Balance:** View the current balance in the account.
     - **Exit:** Exit the application.

3. **Transaction Handling:** 
   - For withdrawals, the program checks if the user has enough balance. If they do, the transaction proceeds, and the balance is updated. Otherwise, an error message is shown.
   - For deposits, the program simply adds the deposit amount to the balance and updates the display.
   
4. **Error Handling:**
   - The program handles invalid inputs, ensuring that only valid amounts (greater than zero) are accepted for withdrawals and deposits. It also prevents withdrawals that exceed the available balance.

## Example Usage

1. The application starts, and you're prompted to enter a PIN:
   
   ```
   Enter PIN: ____
   ```

2. If the PIN is correct (e.g., `1234`), the main ATM interface appears with the following options:

   - Withdraw
   - Deposit
   - Check Balance
   - Exit

3. You can then select an action (e.g., withdraw money), and the program will ask for the amount to withdraw.

   - If the entered amount is valid, the balance is updated, and a message will show the new balance.

4. To exit the program, select the "Exit" button.

## Project Structure

```
ATM_GUI_Project/
│
├── ATMGUI.java           # Main Java file for ATM GUI system
├── README.md             # This file
└── (optional folders for additional resources, images, etc.)
```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

