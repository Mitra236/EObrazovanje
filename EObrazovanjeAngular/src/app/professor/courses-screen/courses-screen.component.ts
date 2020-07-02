import { Component, OnInit, OnDestroy } from '@angular/core';
import { ProfessorService } from 'src/app/services/professor/professor.service';
import { ActivatedRoute, Router, Params } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { Course } from 'src/app/types/course';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-courses-screen',
  templateUrl: './courses-screen.component.html',
  styleUrls: ['./courses-screen.component.css']
})
export class CoursesScreenComponent implements OnInit, OnDestroy {
  private subscription: Subscription;
  courses: Course[]

  constructor(private professorService: ProfessorService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.route.snapshot.params['id'] ?
      this.subscription = this.route.params
        .pipe(switchMap((params: Params) =>
          this.professorService.getProfessorsCourses(+params["id"])))
          .subscribe(course => {
            this.courses = course
        })
    : this.courses
  }

  goToCourse(course: Course) {
    this.router.navigate(['professor/courseDetails', course.id]);
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }
}
