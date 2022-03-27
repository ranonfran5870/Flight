package Login;

public class LoginToken {
//    enum Permissionstest {
//        Customer,
//        Admin,
//        Airline
//    }
    private long id;
    private String name;
    private Permissions role;

    public LoginToken(int id, String name, int role) {
        this.id = id;
        this.name = name;
        this.role = setEnum(role);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Permissions getRole() {
        return role;
    }

    private Permissions setEnum(int coin){
        switch (coin){
            case 0 -> {return Permissions.Anonymous;
            }
            case 1 -> {return Permissions.Customer;
            }
            case 2 -> {return Permissions.Admin;
            }
            case 3 -> {return Permissions.Airline;
            }
            default -> {return Permissions.Anonymous;}
        }
    }
}
