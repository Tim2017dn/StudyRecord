package learnBuilder;

public class testUser {

    public static void main(String[] args) {
        User u= User.builder()
                .id(1)
                .name("mike")
                .address("nanjing")
                .build();
        System.out.println(u);
    }

}
