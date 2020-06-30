import { Component, OnInit, OnDestroy } from '@angular/core';
import { ProfessorService } from 'src/app/services/professor/professor.service';
import { ActivatedRoute, Router, Params } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { Course } from 'src/app/types/course';

@Component({
  selector: 'app-courses-screen',
  templateUrl: './courses-screen.component.html',
  styleUrls: ['./courses-screen.component.css']
})
export class CoursesScreenComponent implements OnInit, OnDestroy {
  courses: Course[]

  constructor(private professorService: ProfessorService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    if (this.route.snapshot.params['id']) {
      this.route.params
        .pipe(switchMap((params: Params) =>
          this.professorService.getProfessorsCourses(+params["id"])))
          .subscribe(course => {
            this.courses = course
            console.log(course)
        })
    }
  }

  ngOnDestroy(): void {
    throw new Error("Method not implemented.");
  }
}
