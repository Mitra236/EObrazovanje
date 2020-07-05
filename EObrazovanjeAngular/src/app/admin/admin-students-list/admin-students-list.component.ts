import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { switchMap } from 'rxjs/operators';
import { StudentServiceService } from '../../services/student/student.service';
import { Student } from '../../types/student';

@Component({
  selector: 'app-admin-students-list',
  templateUrl: './admin-students-list.component.html',
  styleUrls: ['./admin-students-list.component.css'],
})
export class AdminStudentsListComponent implements OnInit, OnDestroy {
  private subscription: Subscription;
  students: Student[];
  constructor(
    private studentService: StudentServiceService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.subscription = this.route.params
      .pipe(
        switchMap((params: Params) => this.studentService.getListOfStudents())
      )
      .subscribe((student) => {
        this.students = student;
      });
  }
  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }
}
