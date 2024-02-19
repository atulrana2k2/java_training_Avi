package Singletonclass;

public class SingleTon {                                                                //SingleTon class having only one instance(object)
    String s;
    private SingleTon(String s) {                                                  //private constructor so no object is created
        this.s=s;                                                                               //outside the class
    }



    private static SingleTon instance;

    public static SingleTon getInstance(String s) {                                     //public function to create the Instance(1) of the class

        if (instance == null) {
            instance = new SingleTon(s);                                                //creating a new instance if no instance exist
            System.out.println("Name of Prime Minister is : "+instance.s);
            return instance;
        }
        else {
            System.out.println("Instance all ready Created (one Instance is allowed)");
            System.out.println("Name of Prime Minister is : "+instance.s);
            return instance;                                                            //returning the already existing instance
        }
    }


}