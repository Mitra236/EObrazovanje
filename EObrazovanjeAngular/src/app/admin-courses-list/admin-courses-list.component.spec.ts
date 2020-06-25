import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminCoursesListComponent } from './admin-courses-list.component';

describe('AdminCoursesListComponent', () => {
  let component: AdminCoursesListComponent;
  let fixture: ComponentFixture<AdminCoursesListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminCoursesListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminCoursesListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
