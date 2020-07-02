import { Component, OnInit, OnDestroy } from '@angular/core';
import { ProfessorCourseDetails } from 'src/app/types/professor-course-details';
import { ProfessorService } from 'src/app/services/professor/professor.service';
import { ActivatedRoute, Params } from '@angular/router';
import { Subscription } from 'rxjs';
import { switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-professor-course-details',
  templateUrl: './professor-course-details.component.html',
  styleUrls: ['./professor-course-details.component.css']
})
export class ProfessorCourseDetailsComponent implements OnInit, OnDestroy {
  private subscription: Subscription;
  course: ProfessorCourseDetails;

  constructor(private professorService: ProfessorService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.snapshot.params['id'] ?
      this.getData()
    : this.course;
  }

  getData() {
    this.subscription = this.route.params
    .pipe(switchMap((params: Params) =>
      this.professorService.getProfessorCourseDetails(+params["id"])))
      .subscribe(course => {
        this.course = course
    })
  }

  deleteCourseEnrollment(id: number) {
    this.professorService.deleteCourseEnrollment(id).subscribe(() => {
      this.getData();
    })
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe()
  }

}
