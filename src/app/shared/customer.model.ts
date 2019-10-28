import {User} from '../user';

export class Customer extends User {
  constructor(
    public id: string,
    public password: string,
    public name: string
  ) {
    super();
  }
}
