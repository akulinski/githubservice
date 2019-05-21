import {Component, OnInit} from '@angular/core';
import {UserStatisticsService} from "../user-statistics.service";
import {ProfileStatistics} from "../profile-statistics";
import {Store} from "@ngrx/store";
import {AppState} from "../app.state";
import {ChangeData} from "../app.actions";

@Component({
  selector: 'app-finder',
  templateUrl: './finder.component.html',
  styleUrls: ['./finder.component.css'],
})
export class FinderComponent implements OnInit {

  username: String;

  constructor(private userStatisticsService: UserStatisticsService, private store: Store<AppState>) {

  }


  ngOnInit() {
  }

  find() {

    console.log("called find");

    this.userStatisticsService.getUsers(this.username).subscribe((data: ProfileStatistics) => {
      this.store.dispatch(new ChangeData(data));
    });

  }

}
