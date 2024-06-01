package myproj;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

import models.*;
import services.*;

public class AllTests {
	
//	static List<Account> accounts = new ArrayList<>();
//	static AccountService accountService = new AccountServiceImpl(accounts);
//	
//	
//	@Test
//	public void createAccount_Test_Success() {
//		Account expectedResult = new Account(accounts.size(), AccountType.checkings, "John Doe", 90000);
//		Account actualResult = accountService.createAccount(expectedResult);
//		assertEquals(expectedResult, actualResult);
//		accounts.remove(expectedResult);
//	}
//	
//	@Test
//	public void withdraw_Test_Success() {
//		Account accountToTest = new Account(accounts.size()+1, AccountType.savings, "Jack Ville", 110);
//		accounts.add(accounts.size(), accountToTest);
//		
//		double initialBalance = accountToTest.getBalance();//110
//		double amountToWithdraw = 100;
//		double expectedResult = initialBalance - amountToWithdraw;//110-100=10
//		
//		double actualResult = accountService.withdraw(accountToTest.getAccountID(), amountToWithdraw);//10==10
//		double delta = 0.0;
//		assertEquals(expectedResult, actualResult, 10.0);
//		
//		accounts.remove(accountToTest);
//	}

	
	
	List<Account> accounts;
    AccountService accountService;

    @Before
    public void setUp() throws Exception {
        accounts = new ArrayList<>();
        accountService = new AccountServiceImpl(accounts);
    }

    @After
    public void tearDown() throws Exception {
        accounts.clear();
    }

    // Test cases for getAllAccounts()

    @Test
    public void getAllAccounts_Test_Success() {
        Account account1 = new Account(1, AccountType.checkings, "John Doe", 90000);
        Account account2 = new Account(2, AccountType.savings, "Jane Doe", 50000);
        accounts.add(account1);
        accounts.add(account2);

        List<Account> actualResult = accountService.getAllAccounts();
        assertEquals(2, actualResult.size());
        assertEquals(account1, actualResult.get(0));
        assertEquals(account2, actualResult.get(1));
    }

//    @Test
//    public void getAllAccounts_Test_Failure() {
//        List<Account> actualResult = accountService.getAllAccounts();
//        assertEquals(0, actualResult.size());
//    }

    // Test cases for getAccountByID(int id)

    @Test
    public void getAccountByID_Test_Success() {
        Account expectedAccount = new Account(1, AccountType.checkings, "John Doe", 90000);
        accounts.add(expectedAccount);

        Account actualResult = accountService.getAccountByID(1);
        assertEquals(expectedAccount, actualResult);
    }

//    @Test
//    public void getAccountByID_Test_Failure() {
//        Account actualResult = accountService.getAccountByID(999);
//        assertEquals(null, actualResult);
//    }

    // Test cases for getBalanceByAccountID(int id)

    @Test
    public void getBalanceByAccountID_Test_Success() {
        Account account = new Account(1, AccountType.checkings, "John Doe", 90000);
        accounts.add(account);

        double actualBalance = accountService.getBalanceByAccountID(1);
        assertEquals(90000, actualBalance, 0.001);
    }

//    @Test
//    public void getBalanceByAccountID_Test_Failure() {
//        double actualBalance = accountService.getBalanceByAccountID(999);
//        assertEquals(0, actualBalance, 0.001);
//    }

    // Test cases for createAccount(Account account)

    @Test
    public void createAccount_Test_Success() {
        Account account = new Account(1, AccountType.checkings, "John Doe", 90000);
        Account actualResult = accountService.createAccount(account);
        assertEquals(account, actualResult);
        assertEquals(1, accounts.size());
    }

//    @Test
//    public void createAccount_Test_Failure() {
//        Account account = null;
//        Account actualResult = accountService.createAccount(account);
//        assertEquals(null, actualResult);
//    }

    // Test cases for deleteAccount(int accountID)

    @Test
    public void deleteAccount_Test_Success() {
        Account accountToDelete = new Account(1, AccountType.checkings, "John Doe", 90000);
        accounts.add(accountToDelete);

        Account deletedAccount = accountService.deleteAccount(1);
        assertEquals(accountToDelete, deletedAccount);
        assertEquals(0, accounts.size());
    }

//    @Test
//    public void deleteAccount_Test_Failure() {
//        Account actualResult = accountService.deleteAccount(999);
//        assertEquals(null, actualResult);
//    }

    // Test cases for updateAccount(Account account)

    @Test
    public void updateAccount_Test_Success() {
        Account account = new Account(1, AccountType.checkings, "John Doe", 90000);
        accounts.add(account);

        Account updatedAccount = new Account(1, AccountType.checkings, "John Doe", 120000);
        Account actualResult = accountService.updateAccount(updatedAccount);
        assertEquals(updatedAccount, actualResult);
        assertEquals(120000, accounts.get(0).getBalance(), 0.001);
    }

//    @Test
//    public void updateAccount_Test_Failure() {
//        Account updatedAccount = new Account(999, AccountType.checkings, "John Doe", 120000);
//        Account actualResult = accountService.updateAccount(updatedAccount);
//        assertEquals(null, actualResult);
//    }

    // Test cases for withdraw(int accountID, double amount)

    @Test
    public void withdraw_Test_Success() {
        Account account = new Account(1, AccountType.checkings, "John Doe", 90000);
        accounts.add(account);

        double actualResult = accountService.withdraw(1, 10000);
        assertEquals(80000, actualResult, 0.001);
    }

//    @Test
//    public void withdraw_Test_Failure() {
//        Account account = new Account(1, AccountType.checkings, "John Doe", 9000);
//        accounts.add(account);
//
//        double actualResult = accountService.withdraw(1, 10000);
//        assertEquals(9000, actualResult, 0.001);
//    }

    @Test
    public void getAllAccounts_Test_Fixed() {
        List<Account> actualResult = accountService.getAllAccounts();
        assertEquals(0, actualResult.size());
    }

    // Test cases for getAccountByID(int id)

    @Test
    public void getAccountByID_Test_Fixed() {
        Account actualResult = accountService.getAccountByID(999);
        assertNull(actualResult);
    }

    // Test cases for getBalanceByAccountID(int id)

    @Test
    public void getBalanceByAccountID_Test_Fixed() {
        double actualBalance = accountService.getBalanceByAccountID(999);
        assertEquals(0, actualBalance, 0.001);
    }

    // Test cases for createAccount(Account account)

    @Test
    public void createAccount_Test_Fixed() {
        Account account = null;
        Account actualResult = accountService.createAccount(account);
        assertNull(actualResult);
    }

    // Test cases for deleteAccount(int accountID)
    @Test
    public void deleteAccount_Test_Fixed() {
        Account actualResult = accountService.deleteAccount(999);
        assertNull(actualResult);
    }

    // Test cases for updateAccount(Account account)


    @Test
    public void updateAccount_Test_Fixed() {
        Account updatedAccount = new Account(999, AccountType.checkings, "John Doe", 1500);
        Account actualResult = accountService.updateAccount(updatedAccount);
        assertNull(actualResult);
    }

    // Test cases for withdraw(int accountID, double amount)

    @Test
    public void withdraw_Test_Fixed() {
        Account account = new Account(1, AccountType.checkings, "John Doe", 1000);
        accounts.add(account);

        double actualResult = accountService.withdraw(1, 1500);
        assertEquals(1000, actualResult, 0.001);
    }
}