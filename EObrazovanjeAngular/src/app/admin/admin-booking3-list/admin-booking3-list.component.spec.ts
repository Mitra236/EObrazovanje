import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminBooking3ListComponent } from './admin-booking3-list.component';

describe('AdminBooking3ListComponent', () => {
  let component: AdminBooking3ListComponent;
  let fixture: ComponentFixture<AdminBooking3ListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminBooking3ListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminBooking3ListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
