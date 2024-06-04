interface IFlyBehaviour{
    void fly();
}
interface IQuackBehaviour{
    void quack();
}
class LoudQuackBehaviour implements IQuackBehaviour{
    @Override
    public void quack() {
        System.out.println("QUACK!!");
    }
}
class LowQuackBehaviour implements  IQuackBehaviour{
    @Override
    public void quack() {
        System.out.println("qua!");
    }
}

class LongFlyBehaviour  implements IFlyBehaviour{
    @Override
    public void fly() {
        System.out.println("fly high");
    }
}

class ShortFlyBehaviour  implements IFlyBehaviour{
    @Override
    public void fly() {
        System.out.println("fly short");
    }
}
interface Duck extends IFlyBehaviour, IQuackBehaviour{
    @Override
    public void fly();

    @Override
    public void quack();
}

class SampleDuck implements Duck {

    private IQuackBehaviour quackBehaviour;
    private IFlyBehaviour flyBehaviour;
    SampleDuck(IFlyBehaviour flyBehaviour, IQuackBehaviour quackBehaviour){
        this.flyBehaviour = flyBehaviour;
        this.quackBehaviour = quackBehaviour;
    }
    @Override
    public void fly() {
        flyBehaviour.fly();
    }

    @Override
    public void quack() {
        quackBehaviour.quack();
    }

    public void setQuackBehaviour(IQuackBehaviour quackBehaviour) {
        this.quackBehaviour = quackBehaviour;
    }

    public void setFlyBehaviour(IFlyBehaviour flyBehaviour) {
        this.flyBehaviour = flyBehaviour;
    }
}
public class Main {
    public static void main(String[] args) {
        SampleDuck duck = new SampleDuck(new LongFlyBehaviour(), new LoudQuackBehaviour());
        duck.quack();
        duck.fly();
        duck.setFlyBehaviour(new ShortFlyBehaviour());
        duck.quack();
        duck.fly();
        duck.setQuackBehaviour(new LowQuackBehaviour());
        duck.quack();
        duck.fly();
    }
}
