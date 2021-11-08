export class JwtResponse{
    token : string;
    type : string;
    email : string;
    firstname: string;
    lastname: string;
    roles : string[];

    constructor(token: string, type: string, email : string) {
        this.token = token;
        this.type = type;
        this.email = email;
        this.roles = ['user'];
      }

}