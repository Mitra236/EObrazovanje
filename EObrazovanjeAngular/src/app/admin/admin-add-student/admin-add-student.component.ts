import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AdminStudentService } from 'src/app/services/admin/admin-student.service';
import { Student } from '../../types/student';
import { forkJoin, Observable } from 'rxjs';
import { StudentCourseInsertScreenComponent } from 'src/app/professor/student-course-insert-screen/student-course-insert-screen.component';
import { Enrollment } from 'src/app/types/enrollment';

export enum EMethodOfFinancing {
  Budget = "Budget",
  SelfFinancing = "SelfFinancing"
}


@Component({
  selector: 'app-admin-add-student',
  templateUrl: './admin-add-student.component.html',
  styleUrls: ['./admin-add-student.component.css']
})
export class AdminAddStudentComponent implements OnInit {
  student: Student;
  @Output()
  saveNewStudent = new EventEmitter<Student>();

  methods = EMethodOfFinancing;

  id?: number;
  username: string;
  password: string;
  firstName: string;
  lastName: string;
  email: string;
  phoneNumber?: string;
  JMBG: string;
  index: string;
  yearOfEnrollment?: number;
  yearOfStudy?: number;
  timeEnrolled?: number;
  methodOfFinancing? : string;
  giroAccountNumber?: string;
  modelNumber?: string;
  personalReferenceNumber?: string;
  accountBalance?: number

  enrollments: Enrollment[];

  constructor(
    private adminStudentService: AdminStudentService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    
    this.id = this.route.snapshot.params['id'] ? 
              this.route.snapshot.params['id'] 
              : 0;
    if(this.id > 0){
        forkJoin(
          this.fillOutStudentDetails(this.id),
          this.fillOutEnrollments(this.id)
        ).subscribe(
          ([student, enrollments]) => {
            if(enrollments != null)
              this.enrollments = enrollments;

            if(student != null) {
              this.username = student.username;
              this.password = student.password;
              this.firstName = student.firstName;
              this.lastName = student.lastName;
              this.email = student.email;
              this.phoneNumber = student.phone;
              this.JMBG = student.JMBG;
              this.index = student.index;
              this.yearOfEnrollment = student.yearOfEnrollment;
              this.yearOfStudy = student.yearOfStudy;
              this.timeEnrolled = student.timeEnrolled;
              this.methodOfFinancing  = student.methodOfFinancing;
              this.giroAccountNumber = student.giroAccountNumber;
              this.modelNumber = student.modelNumber;
              this.personalReferenceNumber = student.personalReferenceNumber;
              this.accountBalance = student.accountBalance;
            } else {
              this.username = null;
              this.password = null;
              this.firstName = null;
              this.lastName = null;
              this.email = null;
              this.phoneNumber = null;
              this.JMBG = null;
              this.index = null;
              this.yearOfEnrollment = null;
              this.yearOfStudy = null;
              this.timeEnrolled = null;
              this.methodOfFinancing  = null;
              this.giroAccountNumber = null;
              this.modelNumber = null;
              this.personalReferenceNumber = null;
              this.accountBalance = null;
        
            console.log(student);
          
        }
      });
    }
    }
    

  fillOutStudentDetails(id: number) {
    return this.adminStudentService.getStudent(id);
  }

  fillOutEnrollments(studentId: number) {
    return this.adminStudentService.getStudentEnrollments(studentId);
  }

 
  saveStudent(){
    let newStudent = {

    } as Student;
    if(this.id != null && this.id > 0) {
      newStudent.id = this.id;
    }
    newStudent.username = this.username;
    newStudent.password = this.password;
    newStudent.firstName = this.firstName;
    newStudent.lastName = this.lastName;
    newStudent.email = this.email;
    newStudent.phone = this.phoneNumber;
    newStudent.JMBG = this.JMBG;
    newStudent.index = this.index;
    newStudent.yearOfEnrollment = this.yearOfEnrollment;
    newStudent.yearOfStudy = this.yearOfStudy;
    newStudent.timeEnrolled = this.timeEnrolled;
    newStudent.methodOfFinancing = this.methodOfFinancing;
    newStudent.giroAccountNumber = this.giroAccountNumber;
    newStudent.modelNumber = this.modelNumber;
    newStudent.personalReferenceNumber = this.personalReferenceNumber;
    newStudent.accountBalance = this.accountBalance;

    if(newStudent.id > 0) {
      this.adminStudentService.updateStudent(newStudent);
    } else {
      this.adminStudentService.addStudent(newStudent);
    }

    this.saveNewStudent.emit(newStudent);
    this.router.navigate(["admin/students"]);
  }

}
