import {Client} from "./client.interface";
import {Coffee} from "./coffee.interface";

export interface Report {

  client: Client;
  coffees: Coffee[];
}
