import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Course } from 'src/app/types/course';
import { AdminStudyProgrammeService } from 'src/app/services/admin/admin-study-programme.service';
import { Subscription } from 'rxjs';
import { switchMap } from 'rxjs/operators';

// const mockData = [
//   {
//     name: 'Softverske i informacione tehnologije',
//     courseCode: 'SF',
//     ECTS: 180,
//     lectures: 30,
//     practicalCLasses: 10
//   },
//   {
//     name: 'Energetika i elektronika',
//     courseCode: 'EE',
//     ECTS: 240,
//     lectures: 40,
//     practicalCLasses: 20
//   }
// ];

@Component({
  selector: 'app-admin-booking2-list',
  templateUrl: './admin-booking2-list.component.html',
  styleUrls: ['./admin-booking2-list.component.css']
})
export class AdminBooking2ListComponent implements OnInit {
  subscription: Subscription;
  courseBooking: Course[];

  constructor(private adminStudyProgrammeService: AdminStudyProgrammeService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.route.snapshot.params['id'] ?
    this.subscription = this.route.params
      .pipe(switchMap((params: Params) =>
        this.adminStudyProgrammeService.getStudyProgrammeCourses(+params["id"])))
        .subscribe(course => {
          this.courseBooking = course
      })
  : this.courseBooking
  }

  goToCourseBooking(id: number) {
    this.router.navigate(['admin/bookings/examBooking/', id])
  }
}
