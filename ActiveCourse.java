/**
* ActiveCourse.java
* Stores information about a course in which a student is currently enrolled.
*/

public class ActiveCourse extends Course {
	public ActiveCourse (String courseCode, double mark) {
		super(courseCode, mark);
	}

	public boolean updateMark (double newMark) {
		if (newMark > 0) {
			mark = newMark;
			return true;
		}
		return false;
	}
}