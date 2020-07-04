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
      startDate: ['', Validators.required],
      endDate: ['', Validators.required],
      student: [0, Validators.required],
      course: this.course
    }, { validator: this.dateLessThan('startDate', 'endDate') })
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

  dateLessThan(startDate: string, endDate: string) {
    return (group: FormGroup): {[key: string]: any} => {
      let s = group.controls[startDate];
      let e = group.controls[endDate];
      if (s.value > e.value) {
        return {
          dates: "End date shouldn't be before start date"
        };
      }
      return {};
    }
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe()
  }
}
