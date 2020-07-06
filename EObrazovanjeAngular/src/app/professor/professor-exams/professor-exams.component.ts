import { Component, OnInit, OnDestroy } from '@angular/core';
import { Exam } from 'src/app/types/exam';
import { ProfessorService } from 'src/app/services/professor/professor.service';
import { ActivatedRoute, Params } from '@angular/router';
import { Subscription } from 'rxjs';
import { switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-professor-exams',
  templateUrl: './professor-exams.component.html',
  styleUrls: ['./professor-exams.component.css']
})
export class ProfessorExamsComponent implements OnInit, OnDestroy {
  subscription: Subscription;
  examJanuary?: Exam[];
  examFebruary?: Exam[];
  examApril?: Exam[];
  examJune?: Exam[];
  examJuly?: Exam[];
  examAugust?: Exam[];
  examSeptember?: Exam[];
  examOctober?: Exam[];

  constructor(private professorService: ProfessorService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.getJanuaryExams('Januarski');
    this.getFebruaryExams('Februarski');
    this.getAprilExams('Aprilski');
    this.getJuneExams('Junski');
    this.getJulyExams('Julski');
    this.getSeptemberExams('Septembarski');
    this.getOctoberExams('Oktobarski');
  }

  getJanuaryExams(period: string) {
    this.subscription = this.route.parent.params
    .pipe(switchMap((params: Params) =>
      this.professorService.getExamsByPeriod(+params["id"], period)))
      .subscribe(exam => {
        this.examJanuary = exam
      }
    )
  }

  getFebruaryExams(period: string) {
    this.subscription = this.route.parent.params
    .pipe(switchMap((params: Params) =>
      this.professorService.getExamsByPeriod(+params["id"], period)))
      .subscribe(exam => {
        this.examFebruary = exam
    }
    )
  }

  getAprilExams(period: string) {
    this.subscription = this.route.parent.params
    .pipe(switchMap((params: Params) =>
      this.professorService.getExamsByPeriod(+params["id"], period)))
      .subscribe(exam => {
        this.examApril = exam
    })
  }

  getJuneExams(period: string) {
    this.subscription = this.route.parent.params
    .pipe(switchMap((params: Params) =>
      this.professorService.getExamsByPeriod(+params["id"], period)))
      .subscribe(exam => {
        this.examJune = exam
    })
  }

  getJulyExams(period: string) {
    this.subscription = this.route.parent.params
    .pipe(switchMap((params: Params) =>
      this.professorService.getExamsByPeriod(+params["id"], period)))
      .subscribe(exam => {
        this.examJuly = exam
    })
  }

  getSeptemberExams(period: string) {
    this.subscription = this.route.parent.params
    .pipe(switchMap((params: Params) =>
      this.professorService.getExamsByPeriod(+params["id"], period)))
      .subscribe(exam => {
        this.examSeptember = exam
    })
  }

  getOctoberExams(period: string) {
    this.subscription = this.route.parent.params
    .pipe(switchMap((params: Params) =>
      this.professorService.getExamsByPeriod(+params["id"], period)))
      .subscribe(exam => {
        this.examOctober = exam
    })
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }
}
