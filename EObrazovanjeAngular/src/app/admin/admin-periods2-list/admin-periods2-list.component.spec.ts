import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminPeriods2ListComponent } from './admin-periods2-list.component';

describe('AdminPeriods2ListComponent', () => {
  let component: AdminPeriods2ListComponent;
  let fixture: ComponentFixture<AdminPeriods2ListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminPeriods2ListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminPeriods2ListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
