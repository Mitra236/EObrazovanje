import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { StudyProgramme } from 'src/app/types/study.programme';
import { Subscription } from 'rxjs';
import { AdminStudyProgrammeService } from 'src/app/services/admin/admin-study-programme.service';

// const mockData = [
//   {
//     name: 'SIT'
//   },
//   {
//     name: 'EE'
//   },
//   {
//     name: 'RA'
//   }
// ];

@Component({
  selector: 'app-admin-booking-list',
  templateUrl: './admin-booking-list.component.html',
  styleUrls: ['./admin-booking-list.component.css']
})
export class AdminBookingListComponent implements OnInit {
  subscription: Subscription;
  bookings: StudyProgramme[];

  constructor(private adminStudyProgrammeService: AdminStudyProgrammeService, private router: Router) { }

  ngOnInit(): void {
    this.subscription = this.adminStudyProgrammeService.getStudyProgrammes()
      .subscribe(booking => {
          this.bookings = booking
      })
  }

  goToCourses(id: number) {
    this.router.navigate(["admin/bookings/courseBooking", id])
  }

}
