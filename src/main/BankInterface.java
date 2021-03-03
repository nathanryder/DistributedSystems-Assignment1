package main;

import main.exception.InvalidLogin;
import main.exception.InvalidSession;

import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface BankInterface extends Remote {

    public long login(String username, String password) throws RemoteException, InvalidLogin;
    public void deposit(int accountnum, BigDecimal amount, long sessionID) throws RemoteException, InvalidSession;
    public void withdraw(int accountnum, BigDecimal amount, long sessionID) throws RemoteException, InvalidSession;
    public BigDecimal getBalance(int accountnum, long sessionID) throws RemoteException, InvalidSession;
    public Statement getStatement(Date from, Date to, long sessionID) throws RemoteException, InvalidSession;

} 