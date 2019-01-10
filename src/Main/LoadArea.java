package Main;

public class LoadArea extends MasterStage {
    public LoadArea(int i) throws Exception {
        try {
            if (i == 1){
                s1town.tavern();
            }
            else{ throw new Exception();}
        }
        catch(Exception e){
            System.out.println("Corrupt Save");
            Thread.sleep(3000);
        }
    }
}
