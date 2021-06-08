export class ClienteDTO {
    id       : string;
	name     : string;
	phone    : string;
	email    : string;
	starDate : Date;
	endDate  : Date;
  constructor(	
	id?:string,
	name?:string,
	phone?:string,
	email?:string,
	starDate?:Date,
	endDate?:Date
  )	{

	this.id =id,
	this.name=name,
	this.phone=phone,
	this.email=email,
	this.starDate=starDate,
	this.endDate=endDate


  }
}
