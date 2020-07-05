import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Subscription, forkJoin } from 'rxjs';
import { switchMap } from 'rxjs/operators';
import { StudyProgrammeService } from '../services/study.programme.service';
import { CourseService } from '../services/course.service';
import { StudentServiceService } from '../services/student/student.service';
import { StudyProgramme } from 'src/app/types/study.programme';
import { Course } from 'src/app/types/course';
import { Student } from 'src/app/types/student';

@Component({
  selector: 'app-admin-programme-list',
  templateUrl: './admin-programme-list.component.html',
  styleUrls: ['./admin-programme-list.component.css']
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
  constructor(private studyProgrammeService: StudyProgrammeService, 
    private coursesService: CourseService, 
    private studentService: StudentServiceService,
    private route: ActivatedRoute, private router: Router) { 
  }

  ngOnInit(): void {
    this.programmeId = this.route.snapshot.paramMap.get('id');
    this.availableStudents = [];
    forkJoin(this.getCourses(), this.getStudents(), this.getAvailableStudents(), this.getCurrentStudyProgramme())
      .subscribe(([courses, students, availableStudentsRead, studyProgramme]) => {
        this.courses = courses;
        this.students = students;
        this.currentStudyProgramme = studyProgramme;

        console.log(availableStudentsRead);
        availableStudentsRead.forEach(student => {
          if(this.students.findIndex(y => y.index == student.index) == -1) {
            this.availableStudents.push(student);
          }
        });

        console.log(this.availableStudents);
      });
  }

  getCurrentStudyProgramme() {
    return this.studyProgrammeService.getStudyProgramme(this.programmeId);
  }

  getCourses() {
    return this.studyProgrammeService.getListOfCoursesForProgramme(+this.programmeId);
  }
  getStudents() {
    return this.studyProgrammeService.getListOfStudentsForProgramme(+this.programmeId);
  }

  getAvailableStudents() {
    return this.studentService.getListOfStudents();
  }
  // getAvailableCourses() {
  //   return this.coursesService.getCourses();
  // }

  addCourse() {

  }

  addStudentToProgramme() {
    this.studyProgrammeService.addStudentToProgramme(this.programmeId, this.selectedStudent);
  }

  ngOnDestroy(): void {
  }

}
