package Login;

public enum Permissions {
    Anonymous(0),
    Customer(1),
    Admin(2),
    Airline(3);

    final int levels;
    Permissions(int levels) {
        this.levels = levels;
    }
}
