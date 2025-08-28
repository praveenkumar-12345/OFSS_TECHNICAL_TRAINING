public class Association {
    public static void main(String[] args) {
        Passenger p = new Passenger("Praveen");
        Routes r = new Routes("Teynampet", "Little mount");
        Booking b = new Booking(r.route1, r.route2,19);

        Cab c = new Cab(p, r, b);
    }
}


class Vehicle { }


class Cab extends Vehicle { //isa
    Driver d = new Driver("Hari");//hasa
    License l = new License("1234");//hasa
    Cab(Passenger p, Routes r, Booking b) {//usesa
        System.out.println("The driver name is "+d.name+" and his license id is "+l.id);
        System.out.println("The passenger named " + p.name + " booked a cab");
        System.out.println(p.name + " booked from " + r.route1 + " to " + r.route2);
        System.out.println("The fare is Rs. " + b.payment());
    }
}

class Driver {
    String name;
    Driver(String n) {
        this.name = n;
    }
}

class License {
    String id;
    License(String id) {
        this.id = id;
    }
}

class Passenger {
    String name;
    Passenger(String n) {
        this.name = n;
    }
}

class Booking {
    String r1;
    String r2;
    int t;

    Booking(String r1, String r2,int t) {
        this.r1 = r1;
        this.r2 = r2;
        this.t=t;
    }

    int payment() {
        if (r1.equals("Guindy") || r1.equals("Teynampet") && r2.equals("Teynampet") || r2.equals("Guindy")) {
            if(t>18) {
                return 220;
            }else{
                return 200;
            }
        }
        else if(r1.equals("Little mount") || r1.equals("Teynampet") && r2.equals("Teynampet") || r2.equals("Little mount")){
            if(t>18){
                return 170;
            }else{
                return 150;
            }
        }
        else {
            return 0;
        }
    }
}

class Routes {
    String route1;
    String route2;

    Routes(String r1, String r2) {
        this.route1 = r1;
        this.route2 = r2;
    }
}
