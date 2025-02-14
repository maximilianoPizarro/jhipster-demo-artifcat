import { type ICountry } from '@/shared/model/country.model';

export interface ILocation {
  id?: number;
  streetAddress?: string | null;
  city?: string | null;
  stateProvince?: string | null;
  country?: ICountry | null;
}

export class Location implements ILocation {
  constructor(
    public id?: number,
    public streetAddress?: string | null,
    public city?: string | null,
    public stateProvince?: string | null,
    public country?: ICountry | null,
  ) {}
}
