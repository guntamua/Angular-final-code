import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TablejoinsComponent } from './tablejoins.component';

describe('TablejoinsComponent', () => {
  let component: TablejoinsComponent;
  let fixture: ComponentFixture<TablejoinsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TablejoinsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TablejoinsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
