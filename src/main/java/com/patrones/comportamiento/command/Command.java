package com.patrones.comportamiento.command;
/**
 * Este patrón permite solicitar una operación a un objeto sin conocer realmente el contenido 
 * de esta operación, ni el receptor real de la misma. Para ello se encapsula la petición como 
 * un objeto, con lo que además facilita la parametrización de los métodos.
 * 
 * https://es.wikipedia.org/wiki/Command_(patr%C3%B3n_de_dise%C3%B1o)
 * @author alexg
 *
 * CARDIO_BRAIN_VASCULAR
 *
 */
/* The Invoker class */
class Switch {

    private Command flipUpCommand;
    private Command flipDownCommand;

    public Switch(Command flipUpCmd, Command flipDownCmd) {
         this.flipUpCommand = flipUpCmd;
         this.flipDownCommand = flipDownCmd;
    }

    public void flipUp() {
         flipUpCommand.execute();
    }

    public void flipDown() {
         flipDownCommand.execute();
    }
}

/* The Receiver class */
class Light {

     public Light() {  }

     public void turnOn() {
        System.out.println("The light is on");
     }

     public void turnOff() {
        System.out.println("The light is off");
     }
}

/* The Command interface */
interface Command {
    void execute();
}

/* The Command for turning the light on in North America, or turning the light off in most other places */
class FlipUpCommand implements Command {

   private Light theLight;

   public FlipUpCommand(Light light) {
        this.theLight=light;
   }

   public void execute(){
      theLight.turnOn();
   }
}

/* The Command for turning the light off in North America, or turning the light on in most other places */
class FlipDownCommand implements Command {

   private Light theLight;

   public FlipDownCommand(Light light) {
        this.theLight=light;
   }

   public void execute() {
      theLight.turnOff();
   }
}

/* The test class or client */
class PressSwitch {

   public static void main(String[] args){
      // Check number of arguments
      if (args.length != 1) {
         System.err.println("Argument \"ON\" or \"OFF\" is required.");
         System.exit(-1);
      }

      Light lamp = new Light();
      Command switchUp = new FlipUpCommand(lamp);
      Command switchDown = new FlipDownCommand(lamp);

      // See criticism of this model above:
      // The switch itself should not be aware of lamp details (switchUp, switchDown)
      // either directly or indirectly
      Switch mySwitch = new Switch(switchUp, switchDown);

      switch (args[0]) {
         case "ON":
            mySwitch.flipUp();
            break;
         case "OFF":
            mySwitch.flipDown();
            break;
         default:
            System.err.println("Argument \"ON\" or \"OFF\" is required.");
            System.exit(-1);
      }
   }
}