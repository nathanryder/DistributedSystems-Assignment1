package main;

import main.exception.InvalidLogin;
import main.exception.InvalidSession;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;

public class Bank implements BankInterface {

    private List<Account> accounts; // users accounts
    public Bank() throws RemoteException {
        super();
    }

    @Override
    public long login(String username, String password) throws RemoteException, InvalidLogin {
        return 0;
    }

    @Override
    public void deposit(int accountnum, BigDecimal amount, long sessionID) throws RemoteException, InvalidSession {

    }

    @Override
    public void withdraw(int accountnum, BigDecimal amount, long sessionID) throws RemoteException, InvalidSession {

    }

    @Override
    public BigDecimal getBalance(int accountnum, long sessionID) throws RemoteException, InvalidSession{
        return null;
    }

    @Override
    public Statement getStatement(Date from, Date to, long sessionID) throws RemoteException, InvalidSession {
        return null;
    }

    public static void main(String args[]) throws Exception {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
            System.out.println("Security manager set");
        }

        BankInterface bankServer = new Bank();
        BankInterface stub = (BankInterface) UnicastRemoteObject.exportObject(bankServer, 0);
        Registry registry = LocateRegistry.getRegistry();

        registry.rebind("Bank", stub);

        System.out.println("Name rebind completed");
        System.out.println("Server ready for requests!");
    }
}