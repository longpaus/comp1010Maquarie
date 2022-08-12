package pastAssignments.s2_2021.assignment1.basic;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface Graded {
	public String description();
	public int marks();
}
