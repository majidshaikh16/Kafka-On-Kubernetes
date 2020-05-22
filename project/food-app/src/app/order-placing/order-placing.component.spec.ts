import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderPlacingComponent } from './order-placing.component';

describe('OrderPlacingComponent', () => {
  let component: OrderPlacingComponent;
  let fixture: ComponentFixture<OrderPlacingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OrderPlacingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OrderPlacingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
