package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.beans.Transient;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Amey W.", Developer.getName());
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

    @Test
    public void getGithubId_returns_correct_github_id() {
        assertEquals("ameymwalimbe", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_correct_team() {
        Team team = Developer.getTeam();
        assertEquals("s25-00", team.getName());
        assertEquals(6, team.getMembers().size());
        assertTrue(team.getMembers().contains("Alice"));
        assertTrue(team.getMembers().contains("Bob"));
        assertTrue(team.getMembers().contains("Chris G."));
        assertTrue(team.getMembers().contains("Danny"));
        assertTrue(team.getMembers().contains("Eve"));
        assertTrue(team.getMembers().contains("Frances"));
    }

}
