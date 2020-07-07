import { Component, OnInit, OnDestroy } from '@angular/core';
import { ExamRegistration } from 'src/app/types/exam-registration';
import { ProfessorService } from 'src/app/services/professor/professor.service';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { switchMap } from 'rxjs/operators';
import { Student } from 'src/app/types/student';

@Component({
  selector: 'app-active-exam-registrations',
  templateUrl: './active-exam-registrations.component.html',
  styleUrls: ['./active-exam-registrations.component.css']
})
export class ActiveExamRegistrationsComponent implements OnInit, OnDestroy {
  subscription: Subscription;
  examRegistration: ExamRegistration[]
  student: Student;
  id: number;

  constructor(private professorService: ProfessorService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.id = +localStorage.getItem("id")
    this.route.parent.snapshot.params['id'] ?
      this.subscription = this.route.parent.params
        .pipe(switchMap((params: Params) =>
          this.professorService.getActiveExamRegistrations(+params["id"])))
          .subscribe(registration => {
            this.examRegistration = registration
              for( let e of this.examRegistration ) {
                this.getStudent(e.studentId)
              }
        })
    : this.examRegistration
  }

  getStudent(id: number) {
    this.subscription = this.route.params
      .pipe(switchMap((params: Params) =>
        this.professorService.getStudent(id)))
        .subscribe(student => {
            this.student = student;
        })
  }

  goToInsertPointsScreen(id: number) {
    this.router.navigate(['professor/', this.id, 'insertPoints', id])
  }

  isDateInFuture(date: string) : boolean {
    let current = new Date()
    let examDate = new Date(date);
    if (examDate > current) {
      return false
    }
      return true;
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe()
  }
}
