import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class UserStatisticsService {

  static url = "statistics/";

  constructor(private http: HttpClient) {
  }

  getUsers(username: String) {
    return this.http.get(UserStatisticsService.url + username);
  }
}




