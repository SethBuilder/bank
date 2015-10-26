import FormatIO.*;

public class Ex2 {
	
	public static void main (String[] arg){
		
		Console con = new Console();
		
		//take info from user
		con.println("Please enter your preferred account number:");
		String accountNumber = con.readWord();
		con.println("Please enter your initial balance: ");
		Double initialBalance = con.readDouble();
		
		//construct fileName
		String fileName = "account-" + accountNumber + ".txt";
		
		//construct account line
		String accountLine = accountNumber + " " + initialBalance;
		
		//create file and write to it
		
		FileOut fout = new FileOut(fileName);
		fout.println(accountLine);
		
		//tell user that account is created
		
		con.println("account <" + fileName + "> has been written");
		
		//DONE WITH STEP ONE
		//NOW STEP TWO TO PULL ACCOUNT AND WRITE ITS BALANCE
		
		con.println("Please enter your account number");
		accountNumber = con.readWord();
		
		//construct file name
		fileName = "account-" + accountNumber + ".txt";
		
		FileIn fin = new FileIn(fileName);
		accountNumber = fin.readWord();
		Double balance = fin.readDouble();
		fin.close();
		//print account number and balance
		con.println(String.format("the balance of account %s is %.2f", accountNumber, balance));
		
		
		//END OF PART TWO
		//PART THREE IS TRANSACTIONS
		
		con.println("Please enter you account number");
		accountNumber = con.readWord();
		
		//Construct file name
		fileName = "account-" + accountNumber + ".txt";
		
		fin = new FileIn(fileName);
		
		accountNumber = fin.readWord();
		balance = fin.readDouble();
		
		//enter trans amount
		con.println("Please enter transaction amount:");
		Double amount = con.readDouble();
		
		balance = balance + amount;
		
		//print out account number and new balance
		
		con.println(String.format("your transaction amount is %f", amount));
	//NOW we must print results into file
		
		fileName = "account-" + accountNumber + ".txt";
		fout = new FileOut(fileName);
		accountLine = accountNumber + " " + balance;
		fout.println(accountLine);
		con.println("account <" + fileName + "> has been written");
		
		//print final statements
		con.println("Please enter account number");
		accountNumber = con.readWord();
		
		fileName = "account-" + accountNumber + ".txt";
		
		fin = new FileIn(fileName);
		accountNumber = fin.readWord();
		balance = fin.readDouble();
		
		con.println(String.format("Statement for account: %s", accountNumber));
		con.println(String.format("Your transaction was: %.2f and your balance is %.2f", amount, balance));
		
		
		
		
	}

}
