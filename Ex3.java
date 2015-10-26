import FormatIO.*;
public class Ex3 {
	public static void main (String[] arg){
		
		Console con = new Console();
		
		//taking info from user
		con.println("Please enter the account number and initial balance for the first account");
		
		String accountNumber1 = con.readWord();
		double initialBalance1 = con.readDouble();
		
		
		con.println("Please enter the account number and initial balance for the second account");
		
		String accountNumber2 = con.readWord();
		double initialBalance2 = con.readDouble();
		
		//creating file name and account line for both accounts
		
		String fileName1 = "account-" + accountNumber1 +".txt";
		String accountLine1 = accountNumber1 + " " + initialBalance1;
		
		FileOut fout = new FileOut(fileName1);
		fout.println(accountLine1);
		
		//now file 2
		
		String fileName2 = "account-" + accountNumber2 +".txt";
		String accountLine2 = accountNumber2 + " " + initialBalance2;
		
		fout = new FileOut(fileName2);
		fout.println(accountLine2);
		
		con.println(String.format("Thanks! the first account number is %s and its balance is %.2f", accountNumber1, initialBalance1));
		con.println(String.format("the second account number is %s and its balance is %.2f", accountNumber2, initialBalance2));
		
		
		//now rent
		con.println("Please enter the monthly rent amount");
		double rentAmount = con.readDouble();
		con.println("how many months you want to pay?");
		int numOfMonths = con.readInt();
		con.println("Please enter the account number you want to pay from");
		String accountNumber = con.readWord();
		
		//now that I have the info from user I'll first construct file name and pull account info
		String fileName = "account-" + accountNumber + ".txt";
		FileIn fin = new FileIn(fileName);
		 accountNumber = fin.readWord();
		double balance = fin.readDouble();
		
		//now calculate total amount
		double totalAmount = numOfMonths * rentAmount;
		
		balance = balance - totalAmount;
		
		//now to print updated balance on console
		con.println(String.format("Done! the new balance for account %s is %.2f", accountNumber, balance));
		
		//now to write on file
		fout = new FileOut(fileName);
		fout.println(accountNumber + " " + balance);
		
		con.println(String.format("account with number %s has been updated successfully", accountNumber));
		
		//now transfer
		con.println("Please enter the amount you want to transfer");
		double transferAmount = con.readDouble();
		
		con.println("What account you want to transfer from?");
		String accountNumberFrom = con.readWord();
		
		con.println("What account you want to transfer to?");
		String accountNumberTo = con.readWord();
		
		//pull file to transfer from
		//make fileName
		String fileNameFrom = "account-" + accountNumberFrom + ".txt";
		//pull file and read balance
		fin = new FileIn(fileNameFrom);
		accountNumberFrom = fin.readWord();
		balance = fin.readDouble();
		
		//subtract transfer amount
		balance -= transferAmount;
		
		//update file
		fout = new FileOut(fileNameFrom);
		fout.println(accountNumberFrom + " " + balance);
		con.println(String.format("Done! account with number %s has been transfered from and it is now %.2f, transfer amount is %.2f", accountNumberFrom, balance, transferAmount));
		
		
		//now add amount to other account
		String fileNameTo = "account-" + accountNumberTo + ".txt";
		fin = new FileIn(fileNameTo);
		accountNumberTo = fin.readWord();
		balance = fin.readDouble();
		
		balance += transferAmount;
		
		//update file
		fout = new FileOut(fileNameTo);
		fout.println(accountNumberTo + " " + balance);
		
		con.println(String.format("Done! account with number %s has been transfered to and it is now %.2f, transfer amount is: %.2f", accountNumberTo, balance, transferAmount));
		
		//now with dollar account
		con.println("Please enter american account number and balance");
		String americanAccountNumber = con.readWord();
		double americanBalance = con.readDouble();
		
		//prepare file name/file line
		String americanFileName = "account-" + americanAccountNumber + ".txt";
		String americanFileLine = americanAccountNumber + " " + americanBalance;
		
		//fout = new FileOut(americanFileName);
		con.println(String.format("You have created an American account in Dollars, the account number is %s and its balance is %.2f", americanAccountNumber, americanBalance));
		
		
		con.println("Please enter which british account you want to transfer from");
		accountNumberFrom = con.readWord();
		
		
		//create file name and pull
		fileNameFrom = "account-" + accountNumberFrom + ".txt";
		fin = new FileIn(fileNameFrom);
		accountNumberFrom = fin.readWord();
		balance = fin.readDouble();
		
		con.println("Please enter how many pounds you want to transfer, followed by transfer rate for 1 pound and commision");
		transferAmount = con.readDouble();
		double rate = con.readDouble();
		double comis = con.readDouble();
		
		//calculations
		balance = (balance) - (transferAmount * comis) - transferAmount;
		transferAmount = transferAmount * rate;
		
		//update British account
		String accountLineFrom = accountNumberFrom + " " + balance;
		fout = new FileOut(fileNameFrom);
		fout.println(accountLineFrom);
		con.println(String.format("Your UK account has been updated. account number %s has a balance of %.2f", accountNumberFrom, balance));
		
		//update American account
		americanBalance += transferAmount;
		americanFileLine = americanAccountNumber + " " + americanBalance;
		fout = new FileOut(americanFileName);
		fout.println(americanFileLine);
		
		con.println(String.format("Done! your US account has been updated. account with number %s has a balance of %.2f. the transfer amount is %.2f", americanAccountNumber, americanBalance, transferAmount));
		
	}

}
