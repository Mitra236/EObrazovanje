import { Component, OnInit, OnDestroy } from '@angular/core';
import { ProfessorService } from 'src/app/services/professor/professor.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { StudentBasicInfo } from 'src/app/types/student-basic-info';
import { Student } from 'src/app/types/student';
import { Enrollment } from 'src/app/types/enrollment';
import { Course } from 'src/app/types/course';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';

@Component({
  selector: 'app-student-course-insert-screen',
  templateUrl: './student-course-insert-screen.component.html',
  styleUrls: ['./student-course-insert-screen.component.css']
})
export class StudentCourseInsertScreenComponent implements OnInit, OnDestroy {
  subscription: Subscription;
  student: Student;
  students: StudentBasicInfo[]
  course: number;
  enrollmentForm: FormGroup;

  constructor(
    private professorService: ProfessorService,
    private route: ActivatedRoute,
    private fb: FormBuilder,
    private router: Router) { }

  ngOnInit(): void {
    this.getStudents(+this.route.snapshot.paramMap.get("id"));
    this.course = +this.route.snapshot.paramMap.get("id")
    this.enrollmentForm = this.fb.group({
      startDate: new FormControl('', [Validators.required]),
      endDate: new FormControl('', [Validators.required]),
      student: new FormControl(0, [Validators.required]),
      course: this.course
    })
  }

  getStudents(id: number) {
    this.subscription = this.professorService.getNotEnrolledStudents(id)
      .subscribe(data => {
        this.students = data
      });
  }

  onSubmit() {
    this.professorService.addEnrollment(this.enrollmentForm.value).subscribe(res => {
      this.router.navigate(['professor/courseDetails', this.course]);
    })
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe()
  }
}
