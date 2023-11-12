package christmas.enums;

public enum Badge {
    NO_BADGE("없음",0),
    STAR("별",5000),
    TREE("트리",10000),
    SANTA("산타",20000);

    private final String name;
    private final int criteria;

    Badge(String name, int criteria){
        this.name=name;
        this.criteria=criteria;
    }

    public String getName(){
        return name;
    }

    public int getCriteria(){
        return criteria;
    }
}
