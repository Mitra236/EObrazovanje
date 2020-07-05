import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminExamsListComponent } from './admin-exams-list.component';

describe('AdminExamsListComponent', () => {
  let component: AdminExamsListComponent;
  let fixture: ComponentFixture<AdminExamsListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminExamsListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminExamsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
