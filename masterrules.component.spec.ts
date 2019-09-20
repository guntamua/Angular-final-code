import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MasterrulesComponent } from './masterrules.component';

describe('MasterrulesComponent', () => {
  let component: MasterrulesComponent;
  let fixture: ComponentFixture<MasterrulesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MasterrulesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MasterrulesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
