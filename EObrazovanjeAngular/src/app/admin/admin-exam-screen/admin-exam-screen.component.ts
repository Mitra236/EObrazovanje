import { Component, OnInit, OnDestroy } from '@angular/core';
import { AdminStudyProgrammeService } from 'src/app/services/admin/admin-study-programme.service';
import { ActivatedRoute, Params } from '@angular/router';
import { Exam } from 'src/app/types/exam';
import { Subscription } from 'rxjs';
import { switchMap } from 'rxjs/operators';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ExamAdmin } from 'src/app/types/exam-admin';
import { Location } from '@angular/common';

@Component({
  selector: 'app-admin-exam-screen',
  templateUrl: './admin-exam-screen.component.html',
  styleUrls: ['./admin-exam-screen.component.css']
})
export class AdminExamScreenComponent implements OnInit, OnDestroy {
  subscription: Subscription;
  exam: ExamAdmin;
  examForm: FormGroup;

  constructor(private adminService: AdminStudyProgrammeService, private route: ActivatedRoute, private fb: FormBuilder, private location: Location) { }

  ngOnInit(): void {
    this.subscription = this.route.params
    .pipe(switchMap((params: Params) =>
      this.adminService.getExam(+params["id"])))
      .subscribe(ex => {
        console.log(ex.date)
        this.exam = ex
        this.getExamForm()
    })

  }

  getExamForm() {
    this.examForm = this.fb.group({
      id: +this.route.snapshot.params['id'],
      date: [this.exam.date],
      classroom: [this.exam.classroom]
    })
  }

  onSubmit() {
    this.adminService.updateExam(this.examForm.value).subscribe(res => {
      this.location.back()
    })
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe()
  }

}
