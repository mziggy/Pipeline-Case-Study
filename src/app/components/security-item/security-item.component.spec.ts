import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SecurityItemComponent } from './security-item.component';

describe('SecurityItemComponent', () => {
  let component: SecurityItemComponent;
  let fixture: ComponentFixture<SecurityItemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SecurityItemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SecurityItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
