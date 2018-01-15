/**
* CourseTracker.java
* Responsible for managing and updating a single student's courses.
*/

import java.util.ArrayList;
import java.io.*;

public class CourseTracker {
	private ArrayList<ActiveCourse> courseList;

	public CourseTracker (ArrayList<ActiveCourse> courseList) {
		this.courseList = courseList;
	}

	public ArrayList<ActiveCourse> getCourseList () {
		return courseList;
	}

	public boolean addCourse (ActiveCourse course) {
		String courseCode = course.getCourseCode();
		if (findByCourseCode(courseCode) == null) {
			courseList.add(course);
			return true;
		}
		return false;
	}

	public boolean updateMark (String courseCode, double newMark) {
		ActiveCourse course = findByCourseCode(courseCode);
		if (course != null && course.updateMark(newMark)) {
			return true;
		}
		return false;
	}

	private ActiveCourse findByCourseCode (String courseCode) {
		for (ActiveCourse course : courseList) {
			if (course.getCourseCode().equals(courseCode)) {
				return course;
			}
		}
		return null;
	}

	/**
	* checkAverageTopSix
	* Takes in an array of 6 course codes and calculates the average mark.
	*/
	public double checkAverageTopSix (String[] topSixCourseList) {
		final int NUM_COURSES = 6;
		double markSum = 0;
		int count = 0;

		for (int i = 0; i < topSixCourseList.length; i++) {
			for (ActiveCourse course : courseList) {
				if (topSixCourseList[i].equals(course.getCourseCode())) {
					markSum += course.getMark();
					count++;
				}
			}
		}
		if (count == NUM_COURSES) {
			return markSum / NUM_COURSES;
		}
		return -1;
	}

	public boolean dropCourse (String courseCode) {
		ActiveCourse course = findByCourseCode(courseCode);
		if (course != null) {
			courseList.remove(course);
			return true;
		}
		return false;
	}
}