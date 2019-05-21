import { TestBed } from '@angular/core/testing';

import { UserStatisticsService } from './user-statistics.service';

describe('UserStatisticsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: UserStatisticsService = TestBed.get(UserStatisticsService);
    expect(service).toBeTruthy();
  });
});
