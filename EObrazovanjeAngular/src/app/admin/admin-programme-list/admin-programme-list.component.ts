import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { forkJoin } from 'rxjs';
import { Course } from 'src/app/types/course';
import { Student } from 'src/app/types/student';
import { StudyProgramme } from 'src/app/types/study.programme';
import { CourseService } from '../../services/course.service';
import { StudentServiceService } from '../../services/student/student.service';
import { StudyProgrammeService } from '../../services/study.programme.service';

@Component({
  selector: 'app-admin-programme-list',
  templateUrl: './admin-programme-list.component.html',
  styleUrls: ['./admin-programme-list.component.css'],
})
export class AdminProgrammeListComponent implements OnInit, OnDestroy {
  courses: Course[];
  students: Student[];

  selectedCourse: Course;
  availableCourses: Course[];

  selectedStudent: Student;
  availableStudents: Student[];

  currentStudyProgramme: StudyProgramme;
  programmeId;
  constructor(
    private studyProgrammeService: StudyProgrammeService,
    private coursesService: CourseService,
    private studentService: StudentServiceService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.programmeId = this.route.snapshot.paramMap.get('id');
    this.availableStudents = [];
    this.availableCourses = [];
    this.displayData();
  }

  displayData() {
    forkJoin(
      this.getCourses(),
      this.getStudents(),
      this.getAvailableStudents(),
      this.getAvailableCourses(),
      this.getCurrentStudyProgramme()
    ).subscribe(
      ([courses, students, availableStudentsRead, availableCoursesRead, studyProgramme]) => {
        this.courses = courses;
        this.students = students;
        this.currentStudyProgramme = studyProgramme;

        
        availableStudentsRead.forEach((student) => {
          if (this.students.findIndex((y) => y.index == student.index) == -1 &&
            this.availableStudents.findIndex((y) => y.index == student.index) == -1) {
            this.availableStudents.push(student);
          }
        });
        availableCoursesRead.forEach((course) => {
          if (this.courses.findIndex((y) => y.courseCode == course.courseCode) == -1 &&
            this.availableCourses.findIndex((y) => y.courseCode == course.courseCode) == -1) {
            this.availableCourses.push(course);
          }
        });

        console.log(this.availableStudents);
        console.log(this.availableCourses);
      }
    );
  }

  getCurrentStudyProgramme() {
    return this.studyProgrammeService.getStudyProgramme(this.programmeId);
  }

  getCourses() {
    return this.studyProgrammeService.getListOfCoursesForProgramme(
      +this.programmeId
    );
  }
  getStudents() {
    return this.studyProgrammeService.getListOfStudentsForProgramme(
      +this.programmeId
    );
  }

  getAvailableStudents() {
    return this.studentService.getListOfStudents();
  }
  getAvailableCourses() {
    return this.coursesService.getListOfCourses();
  }

  addCourseToProgramme() {
    this.studyProgrammeService.addCourseToProgramme(
      this.programmeId,
      this.selectedCourse
    );
    this.courses.push(this.selectedCourse);
    this.availableCourses
      .splice(this.availableCourses
      .findIndex(x => x.courseCode == this.selectedCourse.courseCode), 1);
    this.selectedCourse = null;
  }

  removeCourseFromProgramme(course: Course) {
    this.courses.splice(this.courses.findIndex(x => x.courseCode == course.courseCode), 1);
    this.studyProgrammeService.removeCourseFromProgramme(
      this.programmeId,
      course
    );
    this.availableCourses.push(course);
  }

  addStudentToProgramme() {
    this.studyProgrammeService.addStudentToProgramme(
      this.programmeId,
      this.selectedStudent
    );
    this.students.push(this.selectedStudent);
    this.availableStudents
      .splice(this.availableStudents
      .findIndex(x => x.index == this.selectedStudent.index), 1);
    this.selectedStudent = null;
  }

  removeStudentFromProgramme(student: Student) {
    this.students.splice(this.students.findIndex(x => x.index == student.index), 1);
    this.studyProgrammeService.removeStudentFromProgramme(
      this.programmeId,
      student
    );
    this.availableStudents.push(student);
  }

  ngOnDestroy(): void {}
}
