import {Actions, CHANGE_DATA} from "./app.actions";
import {ProfileStatistics} from "./profile-statistics";

const initalState: ProfileStatistics = {
  userName: '',

  avatarLink: '',

  repositoriesCount: 0,

  languages: null
}


export function reducer(state: ProfileStatistics[] = [initalState], action: Actions) {

  switch (action.type) {
    case CHANGE_DATA:
      return [...state, action.payload];
    default:
      return state;
  }
}
