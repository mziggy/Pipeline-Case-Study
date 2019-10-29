import {User} from './user';

export class Customer extends User {
  constructor(
    id: string,
    brokerId: string,
    password: string,
    name: string
  ) {
    super();
  }
}
