package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue(job instanceof Job);
        assertTrue(job.getLocation() instanceof Location);
        assertTrue(job.getEmployer() instanceof Employer);
        assertTrue(job.getPositionType() instanceof PositionType);
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Product tester", job.getName());
        assertEquals("ACME", job.getEmployer().getValue());
        assertEquals("Desert", job.getLocation().getValue());
        assertEquals("Quality control", job.getPositionType().getValue());
        assertEquals("Persistence", job.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        String jobToString = job.toString();
        assertEquals('\n', jobToString.charAt(0));
        assertEquals('\n', jobToString.charAt(jobToString.length()-1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        String jobToString = job.toString();
        String jobInfo = "\nID: " + job.getId() +
                "\nName: Product tester" +
                "\nEmployer: ACME" +
                "\nLocation: Desert" +
                "\nPosition Type: Quality control" +
                "\nCore Competency: Persistence" +
                "\n";
        assertEquals(jobInfo, jobToString);
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job emptyJob = new Job ("", new Employer("ACME"), new Location(""), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String emptyJobString = emptyJob.toString();
        String jobInfo = "\nID: " + emptyJob.getId() +
                "\nName: Data not available" +
                "\nEmployer: ACME" +
                "\nLocation: Data not available" +
                "\nPosition Type: Quality control" +
                "\nCore Competency: Persistence" +
                "\n";
        assertEquals(jobInfo, emptyJobString);
    }

}
