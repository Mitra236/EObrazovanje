import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { ExamRegistrationChecked } from 'src/app/types/exam-registration-check';
import { Subscription } from 'rxjs';
import { AdminStudyProgrammeService } from 'src/app/services/admin/admin-study-programme.service';
import { switchMap } from 'rxjs/operators';

// const mockData = [
//   {
//     firstName: 'Valentina',
//     lastName: 'Mackovic',
//     status: 'passed',
//     finalGrade: 10
//   },
//   {
//     firstName: 'Ana',
//     lastName: 'Anic',
//     status: 'passed',
//     finalGrade: 10
//   }
// ];

@Component({
  selector: 'app-admin-booking3-list',
  templateUrl: './admin-booking3-list.component.html',
  styleUrls: ['./admin-booking3-list.component.css']
})
export class AdminBooking3ListComponent implements OnInit {
  subscription: Subscription;
  examBooking: ExamRegistrationChecked[];
  constructor(private adminStudyProgrammeService: AdminStudyProgrammeService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.snapshot.params['id'] ?
    this.subscription = this.route.params
      .pipe(switchMap((params: Params) =>
        this.adminStudyProgrammeService.getActiveExamsToCheck(+params["id"])))
        .subscribe(course => {
          this.examBooking = course
      })
  : this.examBooking
  }

  onCheck(id: number, index: number) {
    this.adminStudyProgrammeService.checkExam(id)
      .subscribe(course => {
        this.examBooking.splice(index, 1)
      }
    )
  }


}
