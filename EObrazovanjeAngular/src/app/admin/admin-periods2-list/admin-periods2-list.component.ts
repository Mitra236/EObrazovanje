import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Exam } from 'src/app/types/exam';
import { AdminStudyProgrammeService } from 'src/app/services/admin/admin-study-programme.service';
import { Subscription } from 'rxjs';
import { switchMap } from 'rxjs/operators';
import { ExamAdmin } from 'src/app/types/exam-admin';

@Component({
  selector: 'app-admin-periods2-list',
  templateUrl: './admin-periods2-list.component.html',
  styleUrls: ['./admin-periods2-list.component.css']
})
export class AdminPeriods2ListComponent implements OnInit {
  subscription: Subscription;
  examPeriod: ExamAdmin[];
  constructor(private studyProgramme: AdminStudyProgrammeService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.subscription = this.route.params
    .pipe(switchMap((params: Params) =>
      this.studyProgramme.getExams(+params["id1"], params["id2"])))
      .subscribe(exam => {
        this.examPeriod = exam
      }
    )
  }

  deleteExam(id: number, index: number) {
    this.studyProgramme.delete(id).subscribe(() => {
      this.examPeriod.splice(index, 1)
    })
  }

  goToDetails(id: number) {
    this.router.navigate(['admin/exam-screen', id])
  }

  goToAdd() {
    this.router.navigate(['admin/exam-add'])
  }
}
