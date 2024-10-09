package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    public void equals_if_same_object_returns_true() {
        assertTrue(team.equals(team));
    }

    @Test
    public void equals_if_different_class_returns_false() {
        assertFalse(team.equals(new String()));
    }

    @Test
    public void equals_if_same_name_same_members_returns_true() {
        Team team2 = new Team(team.name);
        team2.addMember("John");
        team.addMember("John");
        assertTrue(team.equals(team2));
    }

    @Test
    public void equals_if_same_name_different_members_returns_false() {
        Team team2 = new Team(team.name);
        team2.addMember("Not John");
        team.addMember("John");
        assertFalse(team.equals(team2));
    }

    @Test
    public void equals_if_different_name_returns_false() {
        Team team2 = new Team("different-name");
        team2.addMember("Not John");
        team.addMember("John");
        assertFalse(team.equals(team2));
    }

    @Test
    public void hash_code_on_similar_objects_returns_true() {
        team.addMember("bar");
        Team t2 = new Team();
        t2.setName("test-team");
        t2.addMember("bar");
        assertEquals(team.hashCode(), t2.hashCode());
    }

    @Test
    public void hash_code_succeeds() {
        team.addMember("bar");
        assertEquals(team.hashCode(), team.name.hashCode() | team.members.hashCode());
    }


    
}
