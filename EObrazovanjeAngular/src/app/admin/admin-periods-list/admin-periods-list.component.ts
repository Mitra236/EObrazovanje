import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { StudyProgramme } from 'src/app/types/study.programme';
import { AdminStudyProgrammeService } from 'src/app/services/admin/admin-study-programme.service';
import { Subscription } from 'rxjs';


@Component({
  selector: 'app-admin-periods-list',
  templateUrl: './admin-periods-list.component.html',
  styleUrls: ['./admin-periods-list.component.css']
})
export class AdminPeriodsListComponent implements OnInit, OnDestroy {
  subscription: Subscription
  periods: StudyProgramme[];
  constructor(
    private studyService: AdminStudyProgrammeService,
    private router: ActivatedRoute,
    private route: Router) { }

  ngOnInit(): void {
    this.subscription = this.studyService.getStudyProgrammes()
        .subscribe(programme => {
          this.periods = programme
      })
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe()
  }

  goToExams(id: number, period: string) {
    this.route.navigate(['admin/examPeriod', id, period])
  }
}
