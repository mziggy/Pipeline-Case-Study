import { Timestamp } from 'rxjs';

export class Trade {
  transactionId: number;
  securityId: string;
  customerId: string;
  brokerId: string;
  transType: string;
  timedate: string;
  amount: number;
  status: boolean;
  purchasePrice: DoubleRange;
  totalPrice: DoubleRange;
}
