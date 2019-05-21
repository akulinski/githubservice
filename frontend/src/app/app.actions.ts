import {Action} from "@ngrx/store";
import {ProfileStatistics} from "./profile-statistics";

export const CHANGE_DATA = '[ APP] Change';
export const CLEAR = '[APP] Clear';

export class ChangeData implements Action {

  readonly type = CHANGE_DATA;


  constructor(public payload: ProfileStatistics) {
  };

}


export class ClearData implements Action {
  readonly type = CLEAR;

  constructor() {
  }
}

export type Actions = ChangeData | ClearData
