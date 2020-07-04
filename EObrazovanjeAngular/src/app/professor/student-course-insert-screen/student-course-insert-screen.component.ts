import { Component, OnInit, OnDestroy } from '@angular/core';
import { ProfessorService } from 'src/app/services/professor/professor.service';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { StudentBasicInfo } from 'src/app/types/student-basic-info';
import { Student } from 'src/app/types/student';
import { Enrollment } from 'src/app/types/enrollment';
import { Course } from 'src/app/types/course';
import { FormGroup, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-student-course-insert-screen',
  templateUrl: './student-course-insert-screen.component.html',
  styleUrls: ['./student-course-insert-screen.component.css']
})
export class StudentCourseInsertScreenComponent implements OnInit, OnDestroy {
  subscription: Subscription;
  student: Student;
  students: StudentBasicInfo[]
  course: Course;
  enrollment: Enrollment;

  constructor(private professorService: ProfessorService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.getStudents(+this.route.snapshot.paramMap.get("id"));
    this.getCourse(+this.route.snapshot.paramMap.get("id"))
  }

  getStudents(id: number) {
    this.subscription = this.professorService.getNotEnrolledStudents(id)
      .subscribe(data => {
        this.students = data
      });
  }

  getCourse(id: number) {
    this.subscription = this.professorService.getCourse(id)
      .subscribe(data => {
        this.course = data
      });
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe()
  }
}
