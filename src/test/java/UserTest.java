import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void deveRetornarFollowersVazio() {
        User user = new User("José", "@zezinho");
        assertEquals(new ArrayList<User>(), user.getFollowers());

    }

    @Test
    void deveRetornarFollowers1() {
        User user1 = new User("José", "@zezinho");
        User user2 = new User("Maria", "@maria");

        user2.follow(user1);

        assertEquals(Arrays.asList(user2), user1.getFollowers());
    }

    @Test
    void deveRetornarFollowing1() {
        User user1 = new User("José", "@zezinho");
        User user2 = new User("Maria", "@maria");

        user2.follow(user1);

        assertEquals(Arrays.asList(user1), user2.getFollowing());

    }

    @Test
    void deveRetornarFollowers2() {
        User user1 = new User("José", "@zezinho");
        User user2 = new User("Maria", "@maria");
        User user3 = new User("Pedro", "@pedro");

        user2.follow(user1);
        user3.follow(user1);

        assertEquals(Arrays.asList(user2, user3), user1.getFollowers());

    }

    @Test
    void deveRetornarFollowing2() {
        User user1 = new User("José", "@zezinho");
        User user2 = new User("Maria", "@maria");
        User user3 = new User("Pedro", "@pedro");

        user3.follow(user1);
        user3.follow(user2);


        assertEquals(Arrays.asList(user1, user2), user3.getFollowing());

    }

    @Test
    void deveRemoverSeguidor() {
        User user1 = new User("José", "@zezinho");
        User user2 = new User("Maria", "@maria");
        User user3 = new User("Pedro", "@pedro");

        user3.follow(user1);
        user3.follow(user2);
        user3.unfollow("@zezinho");

        assertEquals(Arrays.asList(user2), user3.getFollowing());
    }
}