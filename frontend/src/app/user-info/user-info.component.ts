import {Component, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {Store} from "@ngrx/store";
import {AppState} from "../app.state";
import {ProfileStatistics} from "../profile-statistics";


@Component({
  selector: 'app-user-info',
  templateUrl: './user-info.component.html',
  styleUrls: ['./user-info.component.css'],
})
export class UserInfoComponent implements OnInit {

  githubData: Observable<ProfileStatistics[]>;

  data: ProfileStatistics;

  constructor(private store: Store<AppState>) {
    this.githubData = store.select('githubData');
  }

  ngOnInit() {
    this.githubData.subscribe(s => {
      this.data = s[s.length - 1];
    });
  }


}
