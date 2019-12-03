package com.ww.SomeExceptionHandlingSuggestions18;

import com.google.common.base.Preconditions;
import com.ww.HowToSolveTheMultiLevelNestingProblemOfConditionalStatements17.entity.Student;
import org.apache.commons.lang3.Validate;
import org.junit.Test;

/**
 * @author: Sun
 * @create: 2019-12-03 11:21
 * @version: v1.0
 */
public class SomeExceptionHandlingSuggestions18Test {

    /**
     * org.apache.commons.lang3.Validate
     */

    @Test
    public void useValidate() {
        Validate.notNull(new Student(), "Student is null");

        Validate.notEmpty("sun", "String is empty %s", "sun");
    }

    /**
     * com.google.common.base.Preconditions
     */
    @Test
    public void usePreconditions() {
        Student student = Preconditions.checkNotNull(new Student(), "error message");

        Preconditions.checkArgument(1 == 1, "Error argument");

        Preconditions.checkState(true, "Error state");
    }
}
