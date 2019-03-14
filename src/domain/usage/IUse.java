package domain.usage;

public interface IUse {
    public int getUseId();
    public void setUseId(int useId);
    public String getUseDescription();
    public void setUseDescription(String useDescription);
    public float getUseCost();
    public void setUseCost(float useCost);
    public int getNumOfPeople();
    public void setNumOfPeople(int numOfPeople);
}
