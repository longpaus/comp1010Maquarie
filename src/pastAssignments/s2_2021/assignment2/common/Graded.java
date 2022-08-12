package pastAssignments.s2_2021.assignment2.common;

//DO NOT MODIFY

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface Graded {
	String description();
	int marks();
}
