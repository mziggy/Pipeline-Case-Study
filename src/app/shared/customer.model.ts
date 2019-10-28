import { Posit } from './Posit.model';

export class Customer {
  constructor(
    public id: number,
    public password: string,
    public name: string
  //public positions: Posit []
  ) {}
}
