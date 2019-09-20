package org.approvaltests.koans.lesson01;

import static org.junit.Assert.assertEquals;

import java.awt.Rectangle;

import org.approvaltests.Approvals;
import org.approvaltests.koans.helpers.FileAssert;
import org.approvaltests.koans.helpers.Koans;
import org.approvaltests.koans.helpers.Person;
import org.approvaltests.namer.ApprovalNamer;
import org.approvaltests.reporters.DiffReporter;
import org.approvaltests.reporters.JunitReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.Assert;
import org.junit.Test;


/**
 * How to do Koans:
 * Step 1: Press the Run Button (Place cursor on the Method name to run a single method)
 * PC: Ctrl+F11
 * Mac: Command+fn+F11
 * Step 2: Read the name of the Method that Failed
 * Step 3: Fill in the blank (___) to make it pass
 * Step 4: Repeat Until Enlightenment
 * Do not change anything except the blank (___)
 */
@UseReporter(JunitReporter.class)
public class GettingStarted extends Koans {
    @Test
    public void normalJunitAsserts() {
        /** Just a plain JUnit test */
        assertEquals("Small String", "Small String");
    }

    @Test
    public void assertAgainstFileContents() {
        /** Verify the content of `expected.txt` file */
        FileAssert.verifyContentsIsEqual("expected.txt", "Small String");
    }

    @Test
    public void automaticallyGeneratedNames() {
        /** Approvals.createApprovalNamer() creates an ApprovalNamer which name is the name of the `class name`.`test method` -> GettingStarted.automaticallyGeneratedNames */
        ApprovalNamer namer = Approvals.createApprovalNamer();
        assertEquals(namer.getApprovalName(), "GettingStarted.automaticallyGeneratedNames");
    }

    @Test
    public void usingAutomaticFileNames() {
        /** Same as before; you can use it to create a text file -> `GettingStarted.usingAutomaticFileNames.txt` */
        ApprovalNamer namer = Approvals.createApprovalNamer();
        FileAssert.verifyContentsIsEqual(namer.getApprovalName() + ".txt", "Prefer Convention over Configuration");
    }

    @Test
    public void ___() throws Exception {
        /** Same as before, practicing ApprovalNamer */
        ApprovalNamer namer = Approvals.createApprovalNamer();
        assertEquals("GettingStarted.___", namer.getApprovalName());
    }

    @Test
    public void fileNames() throws Exception {
        /** Same as before, practicing ApprovalNamer */
        ApprovalNamer namer = Approvals.createApprovalNamer();
        String className = "GettingStarted";
        String methodName = "fileNames";
        String approvalName = className + "." + methodName;
        Assert.assertEquals(namer.getApprovalName(), approvalName);
    }

    @Test
    public void verifyBiggerText() throws Exception {
        /** Verifying objects using toString() representation */
        Rectangle r = new Rectangle();
        r.width = 40;
        r.height = 189;
        r.x = 136;
        r.y = 200;
        ApprovalNamer namer = Approvals.createApprovalNamer();
        FileAssert.verifyContentsIsEqual(namer.getApprovalName() + ".txt", r.toString());
    }

    @Test
    public void approvalsUsesThisFileNameConvention() throws Exception {
        /**
         * If you don't use an ApprovalNamer, the defuat convention is to create a text file
         * where the name is composed by `class name`.`test method name`.approved.txt,
         * like this --> GettingStarted.approvalsUsesThisFileNameConvention.approved.txt
         */
        Approvals.verify("This is in the approved file");
        // Hint: If you double click the 1st line of the Failure Trace a diff tool will open
    }

    @Test
    @UseReporter(DiffReporter.class)
    public void seeingFilesSideBySide() throws Exception {
        /**
         * Reportes are those who notifies test results
         * They comes to action the first time, when no `approved version` of the test exists.
         * Then appears if test stops passing.
         *
         * One of the easiest reporter is the DiffReporter, the opens your default diff tool
         */
        ApprovalNamer namer = Approvals.createApprovalNamer();
        Approvals.verify("This file is called" + "\r\n" + namer.getApprovalName());
    }

    @Test
    public void changingTheGoldenMaster() throws Exception {
        /**
         * The appoved file acts as a Golden Master.
         * In this test, the golden master `approved` version was wrong,
         * you need to edit GettingStarted.changingTheGoldenMaster.approved.txt
         */
        Approvals.verify("This is the golden master");
        //Hint: What is the name of the file where the blank is?
    }

    @Test
    public void verifyObjects() throws Exception {
        Rectangle r = new Rectangle();
        r.width = 40;
        r.height = 100;
        r.x = ____;
        r.y = 200;
        Approvals.verify(r);
    }

    @Test
    public void sometimeYouNeedABetterToString() throws Exception {
        Person p = new Person("jayne", "cobb", true, 38);
        String format = "Person\n  FirstName:%s\n  LastName:%s\n  Sex:%s\n  Age:%s\n";
        String custom = String.format(format, p.getFirstName(), p.getLastName(), p.isMale() ? "Male" : "Female", p.getAge());
        Approvals.verify(custom);
    }
}
