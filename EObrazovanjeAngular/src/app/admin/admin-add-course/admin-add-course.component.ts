import { Component, OnInit, Output } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Course } from 'src/app/types/course';
import { CourseService } from '../../services/course.service';
import { EventEmitter } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { forkJoin } from 'rxjs';
import { Enrollment } from 'src/app/types/enrollment';
import { Student } from 'src/app/types/student';
import { StudyProgramme } from 'src/app/types/study.programme';
import { EnrollmentAdd } from 'src/app/types/enrollment-add';
import { ProfessorService } from 'src/app/services/professor/professor.service';

@Component({
  selector: 'app-admin-add-course',
  templateUrl: './admin-add-course.component.html',
  styleUrls: ['./admin-add-course.component.css']
})
export class AdminAddCourseComponent implements OnInit {
  @Output()
  saveNewCourse = new EventEmitter<Course>();

  id?: number;
  name: string;
  courseCode: string;
  ECTS?: number;
  lectures?: number;
  practicalClasses?: number;


  studyProgrammeId?: Number;
  
  enrollments: Enrollment[];

  
  selectedStudent: Student;
  availableStudents: Student[];

  constructor(
    private courseService : CourseService,
    private professorService: ProfessorService,
    private router: Router,
    private fb: FormBuilder,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'] ? 
              this.route.snapshot.params['id'] 
              : 0;

    this.availableStudents = [];
    if(this.id > 0) {
      forkJoin(
        this.fillOutCourse(this.id),
        this.fillOutEnrollments(this.id),
        this.getAvailableStudents()
      ).subscribe(
        ([course, enrollments, availableStudentsRead]) => {
          console.log(enrollments);
          if(enrollments != null)
            this.enrollments = enrollments;

            availableStudentsRead.forEach((student) => {
              if (this.enrollments.findIndex((y) => y.student.id == student.id) == -1 &&
                this.availableStudents.findIndex((y) => y.id == student.id) == -1) {
                this.availableStudents.push(student);
              }
            });
           

          if(course != null) {
            this.name = course.name;
            this.courseCode = course.courseCode;
            this.ECTS = course.ECTS; 
            this.lectures = course.lectures;
            this.practicalClasses = course.practicalClasses;

            if(course.studyProgramme != null)
              this.studyProgrammeId = course.studyProgramme.id;

          } else {
            this.name = '';
            this.courseCode ='' ;
            this.ECTS = null; 
            this.lectures = 0;
            this.practicalClasses = 0;
          }

          console.log(course);
          
        }
      );
    }
  }

  fillOutCourse(id: number) {
    return this.courseService.getCourse(id);
  }

  fillOutEnrollments(courseId: number) {
    return this.courseService.getCourseEnrollments(courseId);
  }

  getAvailableStudents() {
    return this.courseService.getAvailableStudents(this.id);
  }

  addStudentToCourse() {
    let enrollment = {
      id: 0,
      student: this.selectedStudent.id,
      startDate: new Date(),
      endDate: new Date(),
      course: this.id
    } as EnrollmentAdd;

    this.courseService.addEnrollment(enrollment);
    
    this.availableStudents
      .splice(this.availableStudents
      .findIndex(x => x.id == this.selectedStudent.id), 1);
    
    let enrollmentTmp = {
      course: { id: this.id } as Course,
      startDate: 0,
      endDate: 0,
      id: 0,
      student: this.selectedStudent
    } as unknown as Enrollment;

    this.enrollments.push(enrollmentTmp);

    forkJoin(
      this.fillOutEnrollments(this.id)
    ).subscribe(
      ([enrollments]) => {
        if(enrollments != null)
          this.enrollments = enrollments;
      }
    );
    this.selectedStudent = null;
  }

  removeEnrollment(id: Number) {
    this.courseService.removeStudentFromCourse(id);

    this.enrollments.splice(this.enrollments.findIndex(x => x.id == id), 1);
    this.availableStudents
    .splice(this.availableStudents
    .findIndex(x => x.id == this.selectedStudent.id), 1);

    forkJoin(
      this.fillOutEnrollments(this.id)
    ).subscribe(
      ([enrollments]) => {
        if(enrollments != null)
          this.enrollments = enrollments;
      }
    );

  }

  saveCourse(){
    if(this.name.length < 3)
    {
      alert("Morate uneti naziv kursa!");
      return;
    }
    let newCourse = {

    } as Course;
    if(this.id != null && this.id > 0) {
      newCourse.id = this.id;
    }
    newCourse.name = this.name;
    newCourse.courseCode = this.courseCode;
    newCourse.ECTS = this.ECTS;
    newCourse.lectures = this.lectures;
    newCourse.practicalClasses = this.practicalClasses;

    if(newCourse.id > 0) {
      this.courseService.editCourse(newCourse);
    } else {
      this.courseService.saveCourse(newCourse);
    }

    this.saveNewCourse.emit(newCourse);
    this.router.navigate(["admin/courses"]);
  }



}
