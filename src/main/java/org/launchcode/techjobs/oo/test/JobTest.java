package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {


    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job3 = new Job(
                "Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence")
        );

        assertTrue(job3 instanceof Job);
        assertEquals("Product tester", job3.getName());
        assertTrue(job3 instanceof Job);
        assertEquals("ACME", job3.getEmployer().getValue());
        assertTrue(job3 instanceof Job);
        assertEquals("Desert", job3.getLocation().getValue());
        assertTrue(job3 instanceof Job);
        assertEquals("Quality control", job3.getPositionType().getValue());
        assertTrue(job3 instanceof Job);
        assertEquals("Persistence", job3.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job job4 = new Job(
                "Software Engineer",
                new Employer("Qualcomm"),
                new Location("Tokyo"),
                new PositionType("Front End"),
                new CoreCompetency("JavaScript")
        );

        Job job5 = new Job(
                "Software Engineer",
                new Employer("Qualcomm"),
                new Location("Tokyo"),
                new PositionType("Front End"),
                new CoreCompetency("JavaScript")
        );

        assertFalse(job4 == job5);
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job6 = new Job(
                "Software Engineer",
                new Employer("Qualcomm"),
                new Location("Tokyo"),
                new PositionType("Front End"),
                new CoreCompetency("JavaScript")
        );

        assertEquals('\n', job6.toString().charAt(0));
        assertEquals('\n', job6.toString().charAt(job6.toString().length() - 1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job7 = new Job(
                "Software Engineer",
                new Employer("Qualcomm"),
                new Location("Tokyo"),
                new PositionType("Front End"),
                new CoreCompetency("JavaScript")
        );

        assertEquals(
    "\nID: " + job7.getId() +
                "\nName: Software Engineer" +
                "\nEmployer: Qualcomm" +
                "\nLocation: Tokyo" +
                "\nPosition Type: Front End" +
                "\nCore Competency: JavaScript\n",
            job7.toString()
        );
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job jobIsEmpty = new Job(
                "",
                new Employer(""),
                new Location(""),
                new PositionType(""),
                new CoreCompetency("")
        );

        assertEquals(
    "\nID: " + jobIsEmpty.getId() +
                "\nName: Data not available" +
                "\nEmployer: Data not available" +
                "\nLocation: Data not available" +
                "\nPosition Type: Data not available" +
                "\nCore Competency: Data not available\n",
            jobIsEmpty.toString()
        );
    }


}
