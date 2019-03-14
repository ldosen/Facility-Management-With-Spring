package domain.usage;

public class Use implements IUse {

    private int useId;
    private String useDescription;
    private float useCost;
    private int numOfPeople;

    public Use() {}

    public Use(int id, String useDescription, float useCost, int numOfPeople){
        this.useId = id;
        this.useDescription = useDescription;
        this.useCost = useCost;
        this.numOfPeople = numOfPeople;
    }

    public int getUseId() {
        return useId;
    }

    public void setUseId(int useId) {
        this.useId = useId;
    }

    public String getUseDescription() {
        return useDescription;
    }

    public void setUseDescription(String useDescription) {
        this.useDescription = useDescription;
    }

    public float getUseCost() {
        return useCost;
    }

    public void setUseCost(float useCost) {
        this.useCost = useCost;
    }

    public int getNumOfPeople(){
        return numOfPeople;
    }

    public void setNumOfPeople(int numOfPeople){
        this.numOfPeople = numOfPeople;
    }
}
