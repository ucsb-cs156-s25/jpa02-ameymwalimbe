package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.beans.Transient;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }
    
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_true_for_same_object() {
        assert(team.equals(team));
    }

    @Test
    public void equals_returns_false_for_different_class() {
        assert(!team.equals(new Object()));
    }

    @Test
    public void equals_returns_true_for_same_team_name_and_members() {
        Team team2 = new Team("test-team");
        assert(team.equals(team2));
    }

    @Test 
    public void equals_returns_false_for_different_members() {
        Team team2 = new Team("test-team");
        team2.addMember("test-member");
        assert(!team.equals(team2));
    }

    @Test
    // Covers final 2 tests through short circuiting
    public void equals_returns_false_for_different_team() {
        Team team2 = new Team("test-team2");
        assert(!team.equals(team2));
    }

    @Test 
    public void hashCode_returns_same_value_for_same_team() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        // we overspecify and require the hashcode implementation to use | instead of &
        int result = t1.hashCode();
        int expectedResult = 130294;
        assertEquals(expectedResult, result);
    }
}
