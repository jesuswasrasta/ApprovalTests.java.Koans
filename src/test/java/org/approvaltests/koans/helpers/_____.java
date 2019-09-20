package org.approvaltests.koans.helpers;

import org.approvaltests.core.ApprovalFailureReporter;
import org.junit.Assert;

public class _____ implements ApprovalFailureReporter {
    @Override
    public void report(String received, String approved) {
        Assert.fail("You need to fill in the blank");
    }
}
