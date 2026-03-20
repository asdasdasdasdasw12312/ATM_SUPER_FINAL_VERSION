
public class ATM {
    private UserManager userManager;
    private User currentUser;
    static clsGenerales cls = new clsGenerales();

    public ATM() {
        userManager = new UserManager();
        
    }

    private int validateOption(int min, int max) {
        int option;
        while (true) {
            option = cls.leerEnteroPos("Enter your option: ");

            if (option >= min && option <= max) {
                return option;
            }
            cls.mensaje("Invalid number. Range: " + min + " - " + max);
            
        }
    }

    public void start() {
        int option;

        do {
            cls.mensaje("\n ATM SYSTEM \n 1. login \n 2. register \n 3. exit");
          
            option = validateOption(1, 3);

            switch (option) {
                case 1:
                    if (login()) {
                        secondaryMenu();
                    }
                    break;
                case 2:
                    register();
                    break;
            }

        } while (option != 3);
    }

    private void register() {
        int id = cls.leerEnteroPos("Enter ID: ");

    
        String username = cls.leerCadena2("Enter username");

        String password = cls.leerCadena2("Enter the password: ");

        User user = new User(id, username, password);
        userManager.registerUser(user);

        cls.mensaje("User registered successfully.");
    }

    private boolean login() {
        

        String username = cls.leerCadena2("Enter username");

     
        String password = cls.leerCadena2("Enter password");

        User user = userManager.findUser(username);

        if (user == null) {
            cls.mensaje("User not found.");
            return false;
        }

        if (user.isBlocked()) {
            cls.mensaje("Account is blocked.");
            return false;
        }

        if (user.getPassword().equals(password)) {
            user.resetAttempts();
            currentUser = user;
            cls.mensaje("Welcome " + username);
            return true;
        } else {
            user.increaseAttempts();

            if (user.getFailedAttempts() >= 3) {
                user.setBlocked(true);
                cls.mensaje("Account blocked due to multiple failed attempts.");
            } else {
                cls.mensaje("Incorrect password. Attempts: " + user.getFailedAttempts());
            }
            return false;
        }
    }

    private void secondaryMenu() {
        int option;

        do {
            cls.mensaje("\n MENU \n 1. Withdraw \n 2. Check balance \n 3. Deposit \n 4. View transactions \n 5. Exit ");

            option = validateOption(1, 5);

            switch (option) {
                case 1:
                    withdraw();
                    break;
                case 2:
                    cls.mensaje("Current balance: $" + currentUser.getBalance());
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    showTransactions();
                    break;
            }

        } while (option != 5);
    }

    private void withdraw() {
        cls.mensaje("Enter amount: ");
        double amount = cls.leerRealPos_f("Enter amount");

        if (!currentUser.withdraw(amount)) {
            cls.mensaje("Invalid amount or insufficient balance.");
        } else {
            cls.mensaje("Withdrawal successful.");
        }
    }

    private void deposit() {
        System.out.print("Enter amount: ");
        double amount = cls.leerRealPos_f("Enter amount");

        if (amount <= 0) {
            cls.mensaje("Amount must be positive.");
            return;
        }

        currentUser.deposit(amount);
        cls.mensaje("Deposit successful.");
    }

    private void showTransactions() {
        if (currentUser.getTransactions().isEmpty()) {
            System.out.println("No transactions available.");
            return;
        }

        for (Transaction t : currentUser.getTransactions()) {
            System.out.println(t);
        }
    }
}