import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminAllCoursesListComponent } from './admin-all-courses-list.component';

describe('AdminAllCoursesListComponent', () => {
  let component: AdminAllCoursesListComponent;
  let fixture: ComponentFixture<AdminAllCoursesListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminAllCoursesListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminAllCoursesListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
