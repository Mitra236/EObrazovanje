import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

const mockData = [
  {
    name: 'SIT'
  },
  {
    name: 'EE'
  },
  {
    name: 'RA'
  }
];

@Component({
  selector: 'app-admin-booking-list',
  templateUrl: './admin-booking-list.component.html',
  styleUrls: ['./admin-booking-list.component.css']
})
export class AdminBookingListComponent implements OnInit {
  bookings;
  constructor(private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.bookings = mockData;
  }

}
