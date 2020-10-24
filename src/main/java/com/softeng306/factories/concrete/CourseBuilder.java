package com.softeng306.factories.concrete;

import com.softeng306.domain.course.Course;
import com.softeng306.domain.course.group.Group;
import com.softeng306.domain.professor.Professor;
import com.softeng306.factories.interfaces.ICourseBuilder;

import java.util.List;

public class CourseBuilder implements ICourseBuilder {
    private Course course;

    public CourseBuilder() {
        course = new Course();
    }

    @Override
    public void setID(String id) {
        course.setID(id);
    }

    @Override
    public void setName(String name) {
        course.setName(name);
    }

    @Override
    public void setProfInCharge(Professor profInCharge) {
        course.setProfInCharge(profInCharge);
    }

    @Override
    public void setTotalSeats(int totalSeats) {
        course.setTotalSeat(totalSeats);
        course.setVacancies(totalSeats);
    }

    @Override
    public void setLectureGroups(List<Group> lectureGroups) {
        course.setLectureGroups(lectureGroups);
    }

    @Override
    public void setTutorialGroups(List<Group> tutorialGroups) {
        course.setTutorialGroups(tutorialGroups);
    }

    @Override
    public void setLabGroups(List<Group> labGroups) {
        course.setLabGroups(labGroups);
    }

    @Override
    public void setAU(int AU) {
        course.setAU(AU);
    }

    @Override
    public void setDepartment(String department) {
        course.setCourseDepartment(department);
    }

    @Override
    public void setType(String type) {
        course.setType(type);
    }

    @Override
    public void setLecWeeklyHour(int lecWeeklyHour) {
        course.setLecWeeklyHour(lecWeeklyHour);
    }

    @Override
    public void setTutWeeklyHour(int tutWeeklyHour) {
        course.setTutWeeklyHour(tutWeeklyHour);
    }

    @Override
    public void setLabWeeklyHour(int labWeeklyHour) {
        course.setLabWeeklyHour(labWeeklyHour);
    }

    @Override
    public Course getCourse() {
        return course;
    }
}
